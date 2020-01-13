package com.fabg21.mysport.team.service.mapper;

import com.fabg21.mysport.team.domain.*;
import com.fabg21.mysport.team.service.dto.SeasonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Season} and its DTO {@link SeasonDTO}.
 */
@Mapper(componentModel = "spring", uses = {TeamMapper.class, PlayerMapper.class})
public interface SeasonMapper extends EntityMapper<SeasonDTO, Season> {

    @Mapping(source = "teamId.id", target = "teamIdId")
    SeasonDTO toDto(Season season);

    @Mapping(source = "teamIdId", target = "teamId")
    @Mapping(target = "removePlayers", ignore = true)
    Season toEntity(SeasonDTO seasonDTO);

    default Season fromId(Long id) {
        if (id == null) {
            return null;
        }
        Season season = new Season();
        season.setId(id);
        return season;
    }
}
