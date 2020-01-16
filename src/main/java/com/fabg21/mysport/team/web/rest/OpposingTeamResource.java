package com.fabg21.mysport.team.web.rest;

import com.fabg21.mysport.team.service.OpposingTeamService;
import com.fabg21.mysport.team.web.rest.errors.BadRequestAlertException;
import com.fabg21.mysport.team.service.dto.OpposingTeamDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.fabg21.mysport.team.domain.OpposingTeam}.
 */
@RestController
@RequestMapping("/api")
public class OpposingTeamResource {

    private final Logger log = LoggerFactory.getLogger(OpposingTeamResource.class);

    private static final String ENTITY_NAME = "mySportTeamOpposingTeam";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OpposingTeamService opposingTeamService;

    public OpposingTeamResource(OpposingTeamService opposingTeamService) {
        this.opposingTeamService = opposingTeamService;
    }

    /**
     * {@code POST  /opposing-teams} : Create a new opposingTeam.
     *
     * @param opposingTeamDTO the opposingTeamDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new opposingTeamDTO, or with status {@code 400 (Bad Request)} if the opposingTeam has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/opposing-teams")
    public ResponseEntity<OpposingTeamDTO> createOpposingTeam(@Valid @RequestBody OpposingTeamDTO opposingTeamDTO) throws URISyntaxException {
        log.debug("REST request to save OpposingTeam : {}", opposingTeamDTO);
        if (opposingTeamDTO.getId() != null) {
            throw new BadRequestAlertException("A new opposingTeam cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OpposingTeamDTO result = opposingTeamService.save(opposingTeamDTO);
        return ResponseEntity.created(new URI("/api/opposing-teams/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /opposing-teams} : Updates an existing opposingTeam.
     *
     * @param opposingTeamDTO the opposingTeamDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated opposingTeamDTO,
     * or with status {@code 400 (Bad Request)} if the opposingTeamDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the opposingTeamDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/opposing-teams")
    public ResponseEntity<OpposingTeamDTO> updateOpposingTeam(@Valid @RequestBody OpposingTeamDTO opposingTeamDTO) throws URISyntaxException {
        log.debug("REST request to update OpposingTeam : {}", opposingTeamDTO);
        if (opposingTeamDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OpposingTeamDTO result = opposingTeamService.save(opposingTeamDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, opposingTeamDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /opposing-teams} : get all the opposingTeams.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of opposingTeams in body.
     */
    @GetMapping("/opposing-teams")
    public List<OpposingTeamDTO> getAllOpposingTeams() {
        log.debug("REST request to get all OpposingTeams");
        return opposingTeamService.findAll();
    }

    /**
     * {@code GET  /opposing-teams/:id} : get the "id" opposingTeam.
     *
     * @param id the id of the opposingTeamDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the opposingTeamDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/opposing-teams/{id}")
    public ResponseEntity<OpposingTeamDTO> getOpposingTeam(@PathVariable Long id) {
        log.debug("REST request to get OpposingTeam : {}", id);
        Optional<OpposingTeamDTO> opposingTeamDTO = opposingTeamService.findOne(id);
        return ResponseUtil.wrapOrNotFound(opposingTeamDTO);
    }

    /**
     * {@code DELETE  /opposing-teams/:id} : delete the "id" opposingTeam.
     *
     * @param id the id of the opposingTeamDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/opposing-teams/{id}")
    public ResponseEntity<Void> deleteOpposingTeam(@PathVariable Long id) {
        log.debug("REST request to delete OpposingTeam : {}", id);
        opposingTeamService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
