package com.fabg21.mysport.team.service.impl;

import com.fabg21.mysport.team.service.SeasonService;
import com.fabg21.mysport.team.domain.Season;
import com.fabg21.mysport.team.repository.SeasonRepository;
import com.fabg21.mysport.team.service.dto.SeasonDTO;
import com.fabg21.mysport.team.service.mapper.SeasonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing {@link Season}.
 */
@Service
@Transactional
public class SeasonServiceImpl implements SeasonService {

    private final Logger log = LoggerFactory.getLogger(SeasonServiceImpl.class);

    private final SeasonRepository seasonRepository;

    private final SeasonMapper seasonMapper;

    public SeasonServiceImpl(SeasonRepository seasonRepository, SeasonMapper seasonMapper) {
        this.seasonRepository = seasonRepository;
        this.seasonMapper = seasonMapper;
    }

    /**
     * Save a season.
     *
     * @param seasonDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public SeasonDTO save(SeasonDTO seasonDTO) {
        log.debug("Request to save Season : {}", seasonDTO);
        Season season = seasonMapper.toEntity(seasonDTO);
        season = seasonRepository.save(season);
        return seasonMapper.toDto(season);
    }

    /**
     * Get all the seasons.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<SeasonDTO> findAll() {
        log.debug("Request to get all Seasons");
        return seasonRepository.findAllWithEagerRelationships().stream()
            .map(seasonMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get all the seasons with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<SeasonDTO> findAllWithEagerRelationships(Pageable pageable) {
        return seasonRepository.findAllWithEagerRelationships(pageable).map(seasonMapper::toDto);
    }
    


    /**
    *  Get all the seasons where Calendar is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true) 
    public List<SeasonDTO> findAllWhereCalendarIsNull() {
        log.debug("Request to get all seasons where Calendar is null");
        return StreamSupport
            .stream(seasonRepository.findAll().spliterator(), false)
            .filter(season -> season.getCalendar() == null)
            .map(seasonMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one season by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SeasonDTO> findOne(Long id) {
        log.debug("Request to get Season : {}", id);
        return seasonRepository.findOneWithEagerRelationships(id)
            .map(seasonMapper::toDto);
    }

    /**
     * Delete the season by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Season : {}", id);
        seasonRepository.deleteById(id);
    }
}
