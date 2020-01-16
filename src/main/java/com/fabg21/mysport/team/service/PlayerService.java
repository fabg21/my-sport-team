package com.fabg21.mysport.team.service;

import com.fabg21.mysport.team.service.dto.PlayerDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.fabg21.mysport.team.domain.Player}.
 */
public interface PlayerService {

    /**
     * Save a player.
     *
     * @param playerDTO the entity to save.
     * @return the persisted entity.
     */
    PlayerDTO save(PlayerDTO playerDTO);

    /**
     * Get all the players.
     *
     * @return the list of entities.
     */
    List<PlayerDTO> findAll();


    /**
     * Get the "id" player.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PlayerDTO> findOne(Long id);

    /**
     * Delete the "id" player.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}