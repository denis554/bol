package com.lifenautjoe.bol.controllers.games.converters;

import com.lifenautjoe.bol.controllers.games.responses.GameResponse;
import com.lifenautjoe.bol.domain.Game;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class GameToGameResponseConverter implements Converter<Game, GameResponse> {
    @Override
    public GameResponse convert(Game source) {
        return new GameResponse(source);
    }
}
