package com.fabg21.mysport.team.repository;
import com.fabg21.mysport.team.domain.OpposingTeam;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the OpposingTeam entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OpposingTeamRepository extends JpaRepository<OpposingTeam, Long> {

}
