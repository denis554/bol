package com.lifenautjoe.bol.services.games;

import com.lifenautjoe.bol.Mappings;
import com.lifenautjoe.bol.domain.GamePlayOutcome;
import com.lifenautjoe.bol.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Service
public class GamesRealtimeService {
    private static final int SEND_GAME_PLAY_W_DELAY_SECONDS = 8;

    private GamesRepositoryService gamesRepositoryService;
    private SimpMessagingTemplate messagingTemplate;
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Autowired
    public GamesRealtimeService(GamesRepositoryService gamesRepositoryService, SimpMessagingTemplate messagingTemplate) {
        this.gamesRepositoryService = gamesRepositoryService;
        this.messagingTemplate = messagingTemplate;
    }

    public void terminateGameForUser(User user) {
        String gameName = user.getGameName();
        GamePlayOutcome gamePlayOutcome = user.terminateGame();
        sendGamePlayOutcome(gamePlayOutcome);
        gamesRepositoryService.removeGameWithName(gameName);
    }

    public void startGameForUser(User user) {
        GamePlayOutcome gamePlayOutcome = user.startGame();
        sendGamePlayOutcomeWithDelay(gamePlayOutcome);
    }

    public void playGameAtSlotWithIdForUser(int slotId, User user) {
        GamePlayOutcome playOutcome = user.playGameAtSlotWithId(slotId);
        sendGamePlayOutcome(playOutcome);

        if (playOutcome.isGameFinished()) {
            gamesRepositoryService.removeGameWithName(playOutcome.getGameName());
        }
    }

    private void sendGamePlayOutcomeWithDelay(GamePlayOutcome gamePlayOutcome) {
        ScheduledFuture<?> countdown = scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                // do the thing
                sendGamePlayOutcome(gamePlayOutcome);
            }
        }, SEND_GAME_PLAY_W_DELAY_SECONDS, TimeUnit.SECONDS);
    }

    private void sendGamePlayOutcome(GamePlayOutcome gamePlayOutcome) {
        String gameName = gamePlayOutcome.getGameName();
        messagingTemplate.convertAndSend(Mappings.REALTIME_GAME + '/' + gameName, gamePlayOutcome);
    }
}
