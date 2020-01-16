package com.fabg21.mysport.team.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.fabg21.mysport.team.web.rest.TestUtil;

public class OpposingTeamTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(OpposingTeam.class);
        OpposingTeam opposingTeam1 = new OpposingTeam();
        opposingTeam1.setId(1L);
        OpposingTeam opposingTeam2 = new OpposingTeam();
        opposingTeam2.setId(opposingTeam1.getId());
        assertThat(opposingTeam1).isEqualTo(opposingTeam2);
        opposingTeam2.setId(2L);
        assertThat(opposingTeam1).isNotEqualTo(opposingTeam2);
        opposingTeam1.setId(null);
        assertThat(opposingTeam1).isNotEqualTo(opposingTeam2);
    }
}
