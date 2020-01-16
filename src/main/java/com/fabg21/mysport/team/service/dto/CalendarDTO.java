package com.fabg21.mysport.team.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.fabg21.mysport.team.domain.Calendar} entity.
 */
public class CalendarDTO implements Serializable {

    private Long id;


    private Long seasonId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CalendarDTO calendarDTO = (CalendarDTO) o;
        if (calendarDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), calendarDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CalendarDTO{" +
            "id=" + getId() +
            ", season=" + getSeasonId() +
            "}";
    }
}
