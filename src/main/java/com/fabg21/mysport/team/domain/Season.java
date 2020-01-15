package com.fabg21.mysport.team.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A Season.
 */
@Entity
@Table(name = "season")
public class Season implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "start")
    private LocalDate start;

    @Column(name = "jhi_end")
    private LocalDate end;

    @Column(name = "current")
    private Boolean current;

    @ManyToOne
    @JsonIgnoreProperties("seasons")
    private Team teamId;

    @ManyToMany
    @JoinTable(name = "season_players",
               joinColumns = @JoinColumn(name = "season_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "players_id", referencedColumnName = "id"))
    private Set<Player> players = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public Season start(LocalDate start) {
        this.start = start;
        return this;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public Season end(LocalDate end) {
        this.end = end;
        return this;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Boolean isCurrent() {
        return current;
    }

    public Season current(Boolean current) {
        this.current = current;
        return this;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public Team getTeamId() {
        return teamId;
    }

    public Season teamId(Team team) {
        this.teamId = team;
        return this;
    }

    public void setTeamId(Team team) {
        this.teamId = team;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public Season players(Set<Player> players) {
        this.players = players;
        return this;
    }

    public Season addPlayers(Player player) {
        this.players.add(player);
        player.getSeasons().add(this);
        return this;
    }

    public Season removePlayers(Player player) {
        this.players.remove(player);
        player.getSeasons().remove(this);
        return this;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Season)) {
            return false;
        }
        return id != null && id.equals(((Season) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Season{" +
            "id=" + getId() +
            ", start='" + getStart() + "'" +
            ", end='" + getEnd() + "'" +
            ", current='" + isCurrent() + "'" +
            "}";
    }
}
