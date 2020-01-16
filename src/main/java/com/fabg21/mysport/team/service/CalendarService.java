package com.fabg21.mysport.team.service;

import com.fabg21.mysport.team.service.dto.CalendarDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.fabg21.mysport.team.domain.Calendar}.
 */
public interface CalendarService {

    /**
     * Save a calendar.
     *
     * @param calendarDTO the entity to save.
     * @return the persisted entity.
     */
    CalendarDTO save(CalendarDTO calendarDTO);

    /**
     * Get all the calendars.
     *
     * @return the list of entities.
     */
    List<CalendarDTO> findAll();


    /**
     * Get the "id" calendar.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CalendarDTO> findOne(Long id);

    /**
     * Delete the "id" calendar.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
