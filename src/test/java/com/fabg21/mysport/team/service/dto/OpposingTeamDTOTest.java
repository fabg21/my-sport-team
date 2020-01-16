package com.fabg21.mysport.team.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.fabg21.mysport.team.web.rest.TestUtil;

public class OpposingTeamDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(OpposingTeamDTO.class);
        OpposingTeamDTO opposingTeamDTO1 = new OpposingTeamDTO();
        opposingTeamDTO1.setId(1L);
        OpposingTeamDTO opposingTeamDTO2 = new OpposingTeamDTO();
        assertThat(opposingTeamDTO1).isNotEqualTo(opposingTeamDTO2);
        opposingTeamDTO2.setId(opposingTeamDTO1.getId());
        assertThat(opposingTeamDTO1).isEqualTo(opposingTeamDTO2);
        opposingTeamDTO2.setId(2L);
        assertThat(opposingTeamDTO1).isNotEqualTo(opposingTeamDTO2);
        opposingTeamDTO1.setId(null);
        assertThat(opposingTeamDTO1).isNotEqualTo(opposingTeamDTO2);
    }
}
