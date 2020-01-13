package com.fabg21.mysport.team.web.rest;

import com.fabg21.mysport.team.service.SeasonService;
import com.fabg21.mysport.team.web.rest.errors.BadRequestAlertException;
import com.fabg21.mysport.team.service.dto.SeasonDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.fabg21.mysport.team.domain.Season}.
 */
@RestController
@RequestMapping("/api")
public class SeasonResource {

    private final Logger log = LoggerFactory.getLogger(SeasonResource.class);

    private static final String ENTITY_NAME = "mySportTeamSeason";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SeasonService seasonService;

    public SeasonResource(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    /**
     * {@code POST  /seasons} : Create a new season.
     *
     * @param seasonDTO the seasonDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new seasonDTO, or with status {@code 400 (Bad Request)} if the season has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/seasons")
    public ResponseEntity<SeasonDTO> createSeason(@RequestBody SeasonDTO seasonDTO) throws URISyntaxException {
        log.debug("REST request to save Season : {}", seasonDTO);
        if (seasonDTO.getId() != null) {
            throw new BadRequestAlertException("A new season cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SeasonDTO result = seasonService.save(seasonDTO);
        return ResponseEntity.created(new URI("/api/seasons/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /seasons} : Updates an existing season.
     *
     * @param seasonDTO the seasonDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated seasonDTO,
     * or with status {@code 400 (Bad Request)} if the seasonDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the seasonDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/seasons")
    public ResponseEntity<SeasonDTO> updateSeason(@RequestBody SeasonDTO seasonDTO) throws URISyntaxException {
        log.debug("REST request to update Season : {}", seasonDTO);
        if (seasonDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SeasonDTO result = seasonService.save(seasonDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, seasonDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /seasons} : get all the seasons.
     *
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of seasons in body.
     */
    @GetMapping("/seasons")
    public List<SeasonDTO> getAllSeasons(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all Seasons");
        return seasonService.findAll();
    }

    /**
     * {@code GET  /seasons/:id} : get the "id" season.
     *
     * @param id the id of the seasonDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the seasonDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/seasons/{id}")
    public ResponseEntity<SeasonDTO> getSeason(@PathVariable Long id) {
        log.debug("REST request to get Season : {}", id);
        Optional<SeasonDTO> seasonDTO = seasonService.findOne(id);
        return ResponseUtil.wrapOrNotFound(seasonDTO);
    }

    /**
     * {@code DELETE  /seasons/:id} : delete the "id" season.
     *
     * @param id the id of the seasonDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/seasons/{id}")
    public ResponseEntity<Void> deleteSeason(@PathVariable Long id) {
        log.debug("REST request to delete Season : {}", id);
        seasonService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
