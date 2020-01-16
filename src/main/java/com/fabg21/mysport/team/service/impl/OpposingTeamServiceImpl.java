package com.fabg21.mysport.team.service.impl;

import com.fabg21.mysport.team.service.OpposingTeamService;
import com.fabg21.mysport.team.domain.OpposingTeam;
import com.fabg21.mysport.team.repository.OpposingTeamRepository;
import com.fabg21.mysport.team.service.dto.OpposingTeamDTO;
import com.fabg21.mysport.team.service.mapper.OpposingTeamMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link OpposingTeam}.
 */
@Service
@Transactional
public class OpposingTeamServiceImpl implements OpposingTeamService {

    private final Logger log = LoggerFactory.getLogger(OpposingTeamServiceImpl.class);

    private final OpposingTeamRepository opposingTeamRepository;

    private final OpposingTeamMapper opposingTeamMapper;

    public OpposingTeamServiceImpl(OpposingTeamRepository opposingTeamRepository, OpposingTeamMapper opposingTeamMapper) {
        this.opposingTeamRepository = opposingTeamRepository;
        this.opposingTeamMapper = opposingTeamMapper;
    }

    /**
     * Save a opposingTeam.
     *
     * @param opposingTeamDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public OpposingTeamDTO save(OpposingTeamDTO opposingTeamDTO) {
        log.debug("Request to save OpposingTeam : {}", opposingTeamDTO);
        OpposingTeam opposingTeam = opposingTeamMapper.toEntity(opposingTeamDTO);
        opposingTeam = opposingTeamRepository.save(opposingTeam);
        return opposingTeamMapper.toDto(opposingTeam);
    }

    /**
     * Get all the opposingTeams.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<OpposingTeamDTO> findAll() {
        log.debug("Request to get all OpposingTeams");
        return opposingTeamRepository.findAll().stream()
            .map(opposingTeamMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one opposingTeam by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OpposingTeamDTO> findOne(Long id) {
        log.debug("Request to get OpposingTeam : {}", id);
        return opposingTeamRepository.findById(id)
            .map(opposingTeamMapper::toDto);
    }

    /**
     * Delete the opposingTeam by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete OpposingTeam : {}", id);
        opposingTeamRepository.deleteById(id);
    }
}
