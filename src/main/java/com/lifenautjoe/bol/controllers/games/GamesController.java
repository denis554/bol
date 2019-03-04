package com.lifenautjoe.bol.controllers.games;

import com.lifenautjoe.bol.Mappings;
import com.lifenautjoe.bol.controllers.ApiResponse;
import com.lifenautjoe.bol.controllers.games.requests.GamePlayRequest;
import com.lifenautjoe.bol.controllers.games.requests.JoinGameRequest;
import com.lifenautjoe.bol.controllers.games.responses.GameResponse;
import com.lifenautjoe.bol.domain.Game;
import com.lifenautjoe.bol.domain.User;
import com.lifenautjoe.bol.services.games.GamesRealtimeService;
import com.lifenautjoe.bol.services.games.GamesRepositoryService;
import com.lifenautjoe.bol.services.users.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = Mappings.API_GAMES)
public class GamesController {
    private GamesRealtimeService gamesRealtimeService;
    private GamesRepositoryService gamesRepositoryService;
    private UserAuthenticationService userAuthenticationService;
    private ConversionService conversionService;

    @Autowired
    public GamesController(GamesRealtimeService gamesRealtimeService,
                           GamesRepositoryService gamesRepositoryService,
                           UserAuthenticationService userAuthenticationService,
                           ConversionService conversionService) {
        this.gamesRealtimeService = gamesRealtimeService;
        this.gamesRepositoryService = gamesRepositoryService;
        this.userAuthenticationService = userAuthenticationService;
        this.conversionService = conversionService;
    }


    @RequestMapping(path = Mappings.API_GAMES_GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<Object> getAll(HttpSession httpSession) {
        if (!userAuthenticationService.isLoggedInForSession(httpSession)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse("User must be logged in before joining a game"));
        }

        User user = userAuthenticationService.getLoggedInUserForSession(httpSession);

        if (user.hasGame()) {
            gamesRealtimeService.terminateGameForUser(user);
        }

        Collection<Game> games = gamesRepositoryService.getAll();
        List<GameResponse> responseGames = new ArrayList<>();

        for (Game game : games) {
            GameResponse gameReponse = conversionService.convert(game, GameResponse.class);
            responseGames.add(gameReponse);
        }
        return ResponseEntity.ok().body(responseGames);
    }

    @RequestMapping(path = Mappings.API_GAMES_JOIN, method = RequestMethod.POST)
    public ResponseEntity<Object> joinGame(@Validated @RequestBody() JoinGameRequest body,
                                           HttpSession httpSession) {

        if (!userAuthenticationService.isLoggedInForSession(httpSession)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse("User must be logged in before joining a game"));
        }

        User user = userAuthenticationService.getLoggedInUserForSession(httpSession);

        if (user.hasGame()) {
            gamesRealtimeService.terminateGameForUser(user);
        }

        String gameName = body.getGameName();

        if (!gamesRepositoryService.hasGameWithName(gameName)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("Game does not exist"));
        }

        Game game = gamesRepositoryService.getGameWithName(gameName);

        if (game.isFull()) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse("Game is full"));
        }

        user.setGame(game);

        return ResponseEntity.ok(new ApiResponse("Game joined!"));
    }

    @RequestMapping(path = Mappings.API_GAMES_CREATE, method = RequestMethod.PUT)
    public ResponseEntity<Object> createGame(@Validated @RequestBody() JoinGameRequest body,
                                             HttpSession httpSession) {

        if (!userAuthenticationService.isLoggedInForSession(httpSession)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse("User must be logged in before creating a game"));
        }

        User user = userAuthenticationService.getLoggedInUserForSession(httpSession);

        if (user.hasGame()) {
            gamesRealtimeService.terminateGameForUser(user);
        }

        String gameName = body.getGameName();

        if (gamesRepositoryService.hasGameWithName(gameName)) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ApiResponse("Game already exists!"));
        }

        Game game = gamesRepositoryService.createGameWithName(gameName);

        user.setGame(game);

        return ResponseEntity.ok(new ApiResponse("Game created!"));
    }

    @RequestMapping(path = Mappings.API_GAMES_PLAY, method = RequestMethod.POST)
    public ResponseEntity gamePlay(@Validated @RequestBody() GamePlayRequest body,
                                   HttpSession httpSession) {
        if (!userAuthenticationService.isLoggedInForSession(httpSession)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse("User is not logged in"));
        }


        String gameName = body.getGameName();
        User user = userAuthenticationService.getLoggedInUserForSession(httpSession);

        if (!user.hasGameWithName(gameName)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse("User is not in given game"));
        }

        if (!user.hasCurrentGameNextTurn()) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse("User has no turn!"));
        }

        int slotIdToPlayAt = body.getSlotId();


        if (!user.currentGameCanBePlayedWithSlotAtId(slotIdToPlayAt)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse("The chosen slot cannot be played"));
        }

        gamesRealtimeService.playGameAtSlotWithIdForUser(slotIdToPlayAt, user);
        return ResponseEntity.ok(new ApiResponse("Played successfully!"));
    }

    @RequestMapping(path = Mappings.API_GAMES_QUIT, method = RequestMethod.POST)
    public ResponseEntity gameQuit(HttpSession httpSession) {
        if (!userAuthenticationService.isLoggedInForSession(httpSession)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse("User is not logged in"));
        }

        User user = userAuthenticationService.getLoggedInUserForSession(httpSession);

        if (user.hasGame()) {
            gamesRealtimeService.terminateGameForUser(user);
        }

        return ResponseEntity.ok(new ApiResponse("Ok"));
    }
}
