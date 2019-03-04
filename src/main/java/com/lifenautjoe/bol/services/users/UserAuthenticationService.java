package com.lifenautjoe.bol.services.users;

import com.lifenautjoe.bol.domain.User;
import com.lifenautjoe.bol.services.games.GamesRealtimeService;
import com.lifenautjoe.bol.services.users.exceptions.SessionHasNoUserException;
import com.lifenautjoe.bol.services.users.exceptions.UserAlreadyExistsException;
import com.lifenautjoe.bol.services.users.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserAuthenticationService {
    private static final String SESSION_USERNAME_KEY = "username";

    private GamesRealtimeService gamesRealtimeService;
    private Map<String, User> sessionIdToUserMap;
    private Map<String, User> loggedInUsers;

    @Autowired
    public UserAuthenticationService(GamesRealtimeService gamesRealtimeService) {
        this.gamesRealtimeService = gamesRealtimeService;
        this.sessionIdToUserMap = new HashMap<>();
        this.loggedInUsers = new HashMap<>();
    }

    public void logoutUserForSession(HttpSession httpSession) {
        String sessionId = httpSession.getId();
        logoutUserForSessionWithId(sessionId);
    }

    public void logoutUserForSessionWithId(String sessionId) {
        User user = getLoggedInUserForSessionWithId(sessionId);
        if (user.hasGame()) {
            gamesRealtimeService.terminateGameForUser(user);
        }
        sessionIdToUserMap.remove(sessionId);
    }

    public User getLoggedInUserForSession(HttpSession httpSession) {
        String sessionId = httpSession.getId();
        return getLoggedInUserForSessionWithId(sessionId);
    }

    public User loginUserForSession(String userName, HttpSession httpSession) throws UserAlreadyExistsException {
        if (userWithNameExists(userName)) {
            throw new UserAlreadyExistsException();
        }
        User user = new User(userName);
        sessionIdToUserMap.put(httpSession.getId(), user);
        loggedInUsers.put(user.getName(), user);
        return user;
    }

    public boolean isLoggedInForSession(HttpSession session) {
        String sessionId = session.getId();
        return isLoggedInForSessionWithId(sessionId);
    }

    public boolean isLoggedInForSessionWithId(String sessionId) {
        return sessionIdToUserMap.containsKey(sessionId);
    }

    public User getLoggedInUserForSessionWithId(String sessionId) {
        User user = sessionIdToUserMap.get(sessionId);
        if (user == null) {
            throw new UserDoesNotExistException();
        }
        return user;
    }

    public boolean userWithNameExists(String userName) {
        return loggedInUsers.containsKey(userName);
    }
}
