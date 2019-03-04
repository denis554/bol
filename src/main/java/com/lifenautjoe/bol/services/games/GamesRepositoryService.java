package com.lifenautjoe.bol.services.games;

import com.lifenautjoe.bol.domain.Game;
import com.lifenautjoe.bol.services.games.exceptions.GameAlreadyExistsException;
import com.lifenautjoe.bol.services.games.exceptions.GameDoesNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GamesRepositoryService {

    private GameFactoryService gameFactoryService;

    private Map<String, Game> games;

    @Autowired
    public GamesRepositoryService(GameFactoryService gameFactoryService) {
        this.gameFactoryService = gameFactoryService;
        this.games = Collections.synchronizedMap(new HashMap<String, Game>());
    }

    public Game getGameWithName(String gameName) {
        Game game = games.get(gameName);
        if (game == null) {
            throw new GameDoesNotExistsException();
        }
        return game;
    }

    public Game createGameWithName(String gameName) {
        if (hasGameWithName(gameName)) {
            throw new GameAlreadyExistsException();
        }
        Game game = gameFactoryService.makeGameWithName(gameName);
        games.put(game.getName(), game);
        return game;
    }

    public boolean hasGameWithName(String gameName) {
        return games.containsKey(gameName);
    }

    public Collection<Game> getAll() {
        return games.values();
    }

    public void removeGame(Game game) {
        String gameName = game.getName();
        removeGameWithName(gameName);
    }

    public void removeGameWithName(String gameName) {
        games.remove(gameName);
    }

}
