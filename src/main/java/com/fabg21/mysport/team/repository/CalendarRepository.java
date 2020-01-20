package com.fabg21.mysport.team.repository;

import com.fabg21.mysport.team.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Spring Data  repository for the Calendar entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    /**
     * Find the calendar from a specific season with all the matches
     * @param seasonId
     * @return
     */
    @Query("SELECT cal FROM Calendar cal LEFT JOIN cal.season sea LEFT JOIN FETCH cal.matchs mat " +
        "LEFT JOIN FETCH mat.opponent WHERE sea.id =(:pSeasonId)")
    Optional<Calendar> findBySeasonIdWithMatches(@Param("pSeasonId") Long seasonId);
}
