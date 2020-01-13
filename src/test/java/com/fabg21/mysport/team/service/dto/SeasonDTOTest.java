package com.fabg21.mysport.team.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.fabg21.mysport.team.web.rest.TestUtil;

public class SeasonDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SeasonDTO.class);
        SeasonDTO seasonDTO1 = new SeasonDTO();
        seasonDTO1.setId(1L);
        SeasonDTO seasonDTO2 = new SeasonDTO();
        assertThat(seasonDTO1).isNotEqualTo(seasonDTO2);
        seasonDTO2.setId(seasonDTO1.getId());
        assertThat(seasonDTO1).isEqualTo(seasonDTO2);
        seasonDTO2.setId(2L);
        assertThat(seasonDTO1).isNotEqualTo(seasonDTO2);
        seasonDTO1.setId(null);
        assertThat(seasonDTO1).isNotEqualTo(seasonDTO2);
    }
}
