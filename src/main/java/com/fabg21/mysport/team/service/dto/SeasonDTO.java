package com.fabg21.mysport.team.service.dto;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the {@link com.fabg21.mysport.team.domain.Season} entity.
 */
public class SeasonDTO implements Serializable {

    private Long id;

    private LocalDate start;

    private LocalDate end;


    private Long teamIdId;

    private Set<PlayerDTO> players = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Long getTeamIdId() {
        return teamIdId;
    }

    public void setTeamIdId(Long teamId) {
        this.teamIdId = teamId;
    }

    public Set<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerDTO> players) {
        this.players = players;
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
            ", start='" + getStart() + "'" +
            ", end='" + getEnd() + "'" +
            ", teamId=" + getTeamIdId() +
            "}";
    }
}
