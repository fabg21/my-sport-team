package com.fabg21.mysport.team.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class CalendarMapperTest {

    private CalendarMapper calendarMapper;

    @BeforeEach
    public void setUp() {
        calendarMapper = new CalendarMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(calendarMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(calendarMapper.fromId(null)).isNull();
    }
}
