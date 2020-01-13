package com.fabg21.mysport.team.service.mapper;

import com.fabg21.mysport.team.domain.*;
import com.fabg21.mysport.team.service.dto.PlayerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Player} and its DTO {@link PlayerDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PlayerMapper extends EntityMapper<PlayerDTO, Player> {


    @Mapping(target = "seasons", ignore = true)
    @Mapping(target = "removeSeasons", ignore = true)
    Player toEntity(PlayerDTO playerDTO);

    default Player fromId(Long id) {
        if (id == null) {
            return null;
        }
        Player player = new Player();
        player.setId(id);
        return player;
    }
}
