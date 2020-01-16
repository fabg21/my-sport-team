package com.fabg21.mysport.team.service;

import com.fabg21.mysport.team.service.dto.OpposingTeamDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.fabg21.mysport.team.domain.OpposingTeam}.
 */
public interface OpposingTeamService {

    /**
     * Save a opposingTeam.
     *
     * @param opposingTeamDTO the entity to save.
     * @return the persisted entity.
     */
    OpposingTeamDTO save(OpposingTeamDTO opposingTeamDTO);

    /**
     * Get all the opposingTeams.
     *
     * @return the list of entities.
     */
    List<OpposingTeamDTO> findAll();


    /**
     * Get the "id" opposingTeam.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OpposingTeamDTO> findOne(Long id);

    /**
     * Delete the "id" opposingTeam.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
