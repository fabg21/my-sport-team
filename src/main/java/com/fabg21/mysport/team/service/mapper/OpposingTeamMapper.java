package com.fabg21.mysport.team.service.mapper;

import com.fabg21.mysport.team.domain.*;
import com.fabg21.mysport.team.service.dto.OpposingTeamDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link OpposingTeam} and its DTO {@link OpposingTeamDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface OpposingTeamMapper extends EntityMapper<OpposingTeamDTO, OpposingTeam> {



    default OpposingTeam fromId(Long id) {
        if (id == null) {
            return null;
        }
        OpposingTeam opposingTeam = new OpposingTeam();
        opposingTeam.setId(id);
        return opposingTeam;
    }
}
