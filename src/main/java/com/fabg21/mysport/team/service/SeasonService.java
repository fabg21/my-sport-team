package com.fabg21.mysport.team.service;

import com.fabg21.mysport.team.service.dto.SeasonDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.fabg21.mysport.team.domain.Season}.
 */
public interface SeasonService {

    /**
     * Save a season.
     *
     * @param seasonDTO the entity to save.
     * @return the persisted entity.
     */
    SeasonDTO save(SeasonDTO seasonDTO);

    /**
     * Get all the seasons.
     *
     * @return the list of entities.
     */
    List<SeasonDTO> findAll();
    /**
     * Get all the SeasonDTO where Calendar is {@code null}.
     *
     * @return the list of entities.
     */
    List<SeasonDTO> findAllWhereCalendarIsNull();

    /**
     * Get all the seasons with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<SeasonDTO> findAllWithEagerRelationships(Pageable pageable);
    
    /**
     * Get the "id" season.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SeasonDTO> findOne(Long id);

    /**
     * Delete the "id" season.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
