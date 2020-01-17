package com.fabg21.mysport.team.repository;
import com.fabg21.mysport.team.domain.Match;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the Match entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    /**
     * Find all Matches from a calendar
     * @param seasonId
     * @return
     */
    @Query("SELECT mat FROM Match mat LEFT JOIN mat.calendar cal LEFT JOIN cal.season sea WHERE sea.id =(:pSeasonId)")
    List<Match> findAllFromSeason(@Param("pSeasonId") Long seasonId);
}
