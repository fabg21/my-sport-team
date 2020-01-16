package com.fabg21.mysport.team.service.mapper;

import com.fabg21.mysport.team.domain.*;
import com.fabg21.mysport.team.service.dto.MatchDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Match} and its DTO {@link MatchDTO}.
 */
@Mapper(componentModel = "spring", uses = {OpposingTeamMapper.class, CalendarMapper.class})
public interface MatchMapper extends EntityMapper<MatchDTO, Match> {

    @Mapping(source = "opponent.id", target = "opponentId")
    @Mapping(source = "calendar.id", target = "calendarId")
    MatchDTO toDto(Match match);

    @Mapping(source = "opponentId", target = "opponent")
    @Mapping(source = "calendarId", target = "calendar")
    Match toEntity(MatchDTO matchDTO);

    default Match fromId(Long id) {
        if (id == null) {
            return null;
        }
        Match match = new Match();
        match.setId(id);
        return match;
    }
}
