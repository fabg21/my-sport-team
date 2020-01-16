package com.fabg21.mysport.team.web.rest;

import com.fabg21.mysport.team.MySportTeamApp;
import com.fabg21.mysport.team.domain.OpposingTeam;
import com.fabg21.mysport.team.repository.OpposingTeamRepository;
import com.fabg21.mysport.team.service.OpposingTeamService;
import com.fabg21.mysport.team.service.dto.OpposingTeamDTO;
import com.fabg21.mysport.team.service.mapper.OpposingTeamMapper;
import com.fabg21.mysport.team.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static com.fabg21.mysport.team.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link OpposingTeamResource} REST controller.
 */
@SpringBootTest(classes = MySportTeamApp.class)
public class OpposingTeamResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    @Autowired
    private OpposingTeamRepository opposingTeamRepository;

    @Autowired
    private OpposingTeamMapper opposingTeamMapper;

    @Autowired
    private OpposingTeamService opposingTeamService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restOpposingTeamMockMvc;

    private OpposingTeam opposingTeam;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final OpposingTeamResource opposingTeamResource = new OpposingTeamResource(opposingTeamService);
        this.restOpposingTeamMockMvc = MockMvcBuilders.standaloneSetup(opposingTeamResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static OpposingTeam createEntity(EntityManager em) {
        OpposingTeam opposingTeam = new OpposingTeam()
            .name(DEFAULT_NAME);
        return opposingTeam;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static OpposingTeam createUpdatedEntity(EntityManager em) {
        OpposingTeam opposingTeam = new OpposingTeam()
            .name(UPDATED_NAME);
        return opposingTeam;
    }

    @BeforeEach
    public void initTest() {
        opposingTeam = createEntity(em);
    }

    @Test
    @Transactional
    public void createOpposingTeam() throws Exception {
        int databaseSizeBeforeCreate = opposingTeamRepository.findAll().size();

        // Create the OpposingTeam
        OpposingTeamDTO opposingTeamDTO = opposingTeamMapper.toDto(opposingTeam);
        restOpposingTeamMockMvc.perform(post("/api/opposing-teams")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(opposingTeamDTO)))
            .andExpect(status().isCreated());

        // Validate the OpposingTeam in the database
        List<OpposingTeam> opposingTeamList = opposingTeamRepository.findAll();
        assertThat(opposingTeamList).hasSize(databaseSizeBeforeCreate + 1);
        OpposingTeam testOpposingTeam = opposingTeamList.get(opposingTeamList.size() - 1);
        assertThat(testOpposingTeam.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    public void createOpposingTeamWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = opposingTeamRepository.findAll().size();

        // Create the OpposingTeam with an existing ID
        opposingTeam.setId(1L);
        OpposingTeamDTO opposingTeamDTO = opposingTeamMapper.toDto(opposingTeam);

        // An entity with an existing ID cannot be created, so this API call must fail
        restOpposingTeamMockMvc.perform(post("/api/opposing-teams")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(opposingTeamDTO)))
            .andExpect(status().isBadRequest());

        // Validate the OpposingTeam in the database
        List<OpposingTeam> opposingTeamList = opposingTeamRepository.findAll();
        assertThat(opposingTeamList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = opposingTeamRepository.findAll().size();
        // set the field null
        opposingTeam.setName(null);

        // Create the OpposingTeam, which fails.
        OpposingTeamDTO opposingTeamDTO = opposingTeamMapper.toDto(opposingTeam);

        restOpposingTeamMockMvc.perform(post("/api/opposing-teams")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(opposingTeamDTO)))
            .andExpect(status().isBadRequest());

        List<OpposingTeam> opposingTeamList = opposingTeamRepository.findAll();
        assertThat(opposingTeamList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllOpposingTeams() throws Exception {
        // Initialize the database
        opposingTeamRepository.saveAndFlush(opposingTeam);

        // Get all the opposingTeamList
        restOpposingTeamMockMvc.perform(get("/api/opposing-teams?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(opposingTeam.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)));
    }
    
    @Test
    @Transactional
    public void getOpposingTeam() throws Exception {
        // Initialize the database
        opposingTeamRepository.saveAndFlush(opposingTeam);

        // Get the opposingTeam
        restOpposingTeamMockMvc.perform(get("/api/opposing-teams/{id}", opposingTeam.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(opposingTeam.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME));
    }

    @Test
    @Transactional
    public void getNonExistingOpposingTeam() throws Exception {
        // Get the opposingTeam
        restOpposingTeamMockMvc.perform(get("/api/opposing-teams/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateOpposingTeam() throws Exception {
        // Initialize the database
        opposingTeamRepository.saveAndFlush(opposingTeam);

        int databaseSizeBeforeUpdate = opposingTeamRepository.findAll().size();

        // Update the opposingTeam
        OpposingTeam updatedOpposingTeam = opposingTeamRepository.findById(opposingTeam.getId()).get();
        // Disconnect from session so that the updates on updatedOpposingTeam are not directly saved in db
        em.detach(updatedOpposingTeam);
        updatedOpposingTeam
            .name(UPDATED_NAME);
        OpposingTeamDTO opposingTeamDTO = opposingTeamMapper.toDto(updatedOpposingTeam);

        restOpposingTeamMockMvc.perform(put("/api/opposing-teams")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(opposingTeamDTO)))
            .andExpect(status().isOk());

        // Validate the OpposingTeam in the database
        List<OpposingTeam> opposingTeamList = opposingTeamRepository.findAll();
        assertThat(opposingTeamList).hasSize(databaseSizeBeforeUpdate);
        OpposingTeam testOpposingTeam = opposingTeamList.get(opposingTeamList.size() - 1);
        assertThat(testOpposingTeam.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingOpposingTeam() throws Exception {
        int databaseSizeBeforeUpdate = opposingTeamRepository.findAll().size();

        // Create the OpposingTeam
        OpposingTeamDTO opposingTeamDTO = opposingTeamMapper.toDto(opposingTeam);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restOpposingTeamMockMvc.perform(put("/api/opposing-teams")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(opposingTeamDTO)))
            .andExpect(status().isBadRequest());

        // Validate the OpposingTeam in the database
        List<OpposingTeam> opposingTeamList = opposingTeamRepository.findAll();
        assertThat(opposingTeamList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteOpposingTeam() throws Exception {
        // Initialize the database
        opposingTeamRepository.saveAndFlush(opposingTeam);

        int databaseSizeBeforeDelete = opposingTeamRepository.findAll().size();

        // Delete the opposingTeam
        restOpposingTeamMockMvc.perform(delete("/api/opposing-teams/{id}", opposingTeam.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<OpposingTeam> opposingTeamList = opposingTeamRepository.findAll();
        assertThat(opposingTeamList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
