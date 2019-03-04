package com.lifenautjoe.bol.services.games;

import com.lifenautjoe.bol.domain.Game;
import org.springframework.stereotype.Service;


@Service
public class GameFactoryService {
    Game makeGameWithName(String gameName) {
        return new Game(gameName);
    }

}
