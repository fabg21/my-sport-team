package com.fabg21.mysport.team.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class SeasonMapperTest {

    private SeasonMapper seasonMapper;

    @BeforeEach
    public void setUp() {
        seasonMapper = new SeasonMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(seasonMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(seasonMapper.fromId(null)).isNull();
    }
}
