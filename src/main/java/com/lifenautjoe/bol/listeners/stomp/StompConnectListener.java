package com.lifenautjoe.bol.listeners.stomp;

import com.lifenautjoe.bol.config.HttpSessionIdHandshakeInterceptor;
import com.lifenautjoe.bol.domain.User;
import com.lifenautjoe.bol.services.games.GamesRealtimeService;
import com.lifenautjoe.bol.services.users.UserAuthenticationService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@Component
public class StompConnectListener implements ApplicationListener<SessionConnectEvent> {

    private final Log logger = LogFactory.getLog(StompConnectListener.class);

    private UserAuthenticationService userAuthenticationService;
    private GamesRealtimeService gamesManager;

    @Autowired
    public StompConnectListener(UserAuthenticationService userAuthenticationService,
                                GamesRealtimeService gamesManager) {
        this.userAuthenticationService = userAuthenticationService;
        this.gamesManager = gamesManager;
    }

    public void onApplicationEvent(SessionConnectEvent event) {
        MessageHeaders headers = event.getMessage().getHeaders();
        String sessionId = SimpMessageHeaderAccessor.getSessionAttributes(headers).get(HttpSessionIdHandshakeInterceptor.SESSION_ID_STOMP_HEADER_ATTRIBUTE).toString();

        if (userAuthenticationService.isLoggedInForSessionWithId(sessionId)) {
            User sessionUser = userAuthenticationService.getLoggedInUserForSessionWithId(sessionId);
            if (sessionUser.hasGame() && sessionUser.currentGameIsFull() && !sessionUser.currentGameStarted()) {
                gamesManager.startGameForUser(sessionUser);
            }
        }
        logger.debug("Connect event [sessionId: " + sessionId + "]");
    }
}