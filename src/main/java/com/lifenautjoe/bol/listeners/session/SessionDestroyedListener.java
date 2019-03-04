package com.lifenautjoe.bol.listeners.session;

import com.lifenautjoe.bol.services.games.GamesRealtimeService;
import com.lifenautjoe.bol.services.users.UserAuthenticationService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.session.events.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Component
public class SessionDestroyedListener implements ApplicationListener<SessionDestroyedEvent> {

    private final Log logger = LogFactory.getLog(SessionDestroyedListener.class);

    private GamesRealtimeService gamesRealtimeService;
    private UserAuthenticationService userAuthenticationService;

    @Autowired
    public SessionDestroyedListener(GamesRealtimeService gamesRealtimeService,
                                    UserAuthenticationService userAuthenticationService) {
        this.gamesRealtimeService = gamesRealtimeService;
        this.userAuthenticationService = userAuthenticationService;
    }

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        logger.debug("Session destroyed!");
        String sessionId = event.getSessionId();
        if (userAuthenticationService.isLoggedInForSessionWithId(sessionId)) {
            userAuthenticationService.logoutUserForSessionWithId(sessionId);
        }
    }

}