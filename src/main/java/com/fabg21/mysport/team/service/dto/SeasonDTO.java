package com.fabg21.mysport.team.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.fabg21.mysport.team.domain.Season} entity.
 */
public class SeasonDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate debut;

    @NotNull
    private LocalDate fin;


    private Long teamIdId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public Long getTeamIdId() {
        return teamIdId;
    }

    public void setTeamIdId(Long teamId) {
        this.teamIdId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SeasonDTO seasonDTO = (SeasonDTO) o;
        if (seasonDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), seasonDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SeasonDTO{" +
            "id=" + getId() +
            ", debut='" + getDebut() + "'" +
            ", fin='" + getFin() + "'" +
            ", teamId=" + getTeamIdId() +
            "}";
    }
}
