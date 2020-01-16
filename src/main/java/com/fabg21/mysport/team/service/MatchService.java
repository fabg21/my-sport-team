package com.fabg21.mysport.team.service;

import com.fabg21.mysport.team.service.dto.MatchDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.fabg21.mysport.team.domain.Match}.
 */
public interface MatchService {

    /**
     * Save a match.
     *
     * @param matchDTO the entity to save.
     * @return the persisted entity.
     */
    MatchDTO save(MatchDTO matchDTO);

    /**
     * Get all the matches.
     *
     * @return the list of entities.
     */
    List<MatchDTO> findAll();


    /**
     * Get the "id" match.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MatchDTO> findOne(Long id);

    /**
     * Delete the "id" match.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}