package com.fabg21.mysport.team.repository;
import com.fabg21.mysport.team.domain.Season;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Season entity.
 */
@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

    @Query(value = "select distinct season from Season season left join fetch season.players",
        countQuery = "select count(distinct season) from Season season")
    Page<Season> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct season from Season season left join fetch season.players")
    List<Season> findAllWithEagerRelationships();

    @Query("select season from Season season left join fetch season.players where season.id =:id")
    Optional<Season> findOneWithEagerRelationships(@Param("id") Long id);

}
