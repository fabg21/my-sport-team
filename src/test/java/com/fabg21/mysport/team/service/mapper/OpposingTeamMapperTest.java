package com.fabg21.mysport.team.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class OpposingTeamMapperTest {

    private OpposingTeamMapper opposingTeamMapper;

    @BeforeEach
    public void setUp() {
        opposingTeamMapper = new OpposingTeamMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(opposingTeamMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(opposingTeamMapper.fromId(null)).isNull();
    }
}
