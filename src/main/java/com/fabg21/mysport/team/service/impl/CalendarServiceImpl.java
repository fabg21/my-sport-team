package com.fabg21.mysport.team.service.impl;

import com.fabg21.mysport.team.service.CalendarService;
import com.fabg21.mysport.team.domain.Calendar;
import com.fabg21.mysport.team.repository.CalendarRepository;
import com.fabg21.mysport.team.repository.SeasonRepository;
import com.fabg21.mysport.team.service.dto.CalendarDTO;
import com.fabg21.mysport.team.service.mapper.CalendarMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Calendar}.
 */
@Service
@Transactional
public class CalendarServiceImpl implements CalendarService {

    private final Logger log = LoggerFactory.getLogger(CalendarServiceImpl.class);

    private final CalendarRepository calendarRepository;

    private final CalendarMapper calendarMapper;

    private final SeasonRepository seasonRepository;

    public CalendarServiceImpl(CalendarRepository calendarRepository, CalendarMapper calendarMapper, SeasonRepository seasonRepository) {
        this.calendarRepository = calendarRepository;
        this.calendarMapper = calendarMapper;
        this.seasonRepository = seasonRepository;
    }

    /**
     * Save a calendar.
     *
     * @param calendarDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CalendarDTO save(CalendarDTO calendarDTO) {
        log.debug("Request to save Calendar : {}", calendarDTO);
        Calendar calendar = calendarMapper.toEntity(calendarDTO);
        long seasonId = calendarDTO.getSeasonId();
        seasonRepository.findById(seasonId).ifPresent(calendar::season);
        calendar = calendarRepository.save(calendar);
        return calendarMapper.toDto(calendar);
    }

    /**
     * Get all the calendars.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CalendarDTO> findAll() {
        log.debug("Request to get all Calendars");
        return calendarRepository.findAll().stream()
            .map(calendarMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one calendar by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CalendarDTO> findOne(Long id) {
        log.debug("Request to get Calendar : {}", id);
        return calendarRepository.findById(id)
            .map(calendarMapper::toDto);
    }

    /**
     * Delete the calendar by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Calendar : {}", id);
        calendarRepository.deleteById(id);
    }

    @Override
    public Optional<CalendarDTO> findOneFromSeason(Long seasonId) {
        log.debug("Request to get Calendar from season : {}", seasonId);
        return calendarRepository.findBySeasonIdWithMatches(seasonId)
            .map(calendarMapper::toDto);
    }
}
