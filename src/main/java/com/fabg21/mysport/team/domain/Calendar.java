package com.fabg21.mysport.team.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Calendar.
 */
@Entity
@Table(name = "calendar")
public class Calendar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @OneToMany(mappedBy = "calendar")
    private Set<Match> matchs = new HashSet<>();

    @OneToOne

    @MapsId
    @JoinColumn(name = "id")
    private Season season;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Match> getMatchs() {
        return matchs;
    }

    public Calendar matchs(Set<Match> matches) {
        this.matchs = matches;
        return this;
    }

    public Calendar addMatchs(Match match) {
        this.matchs.add(match);
        match.setCalendar(this);
        return this;
    }

    public Calendar removeMatchs(Match match) {
        this.matchs.remove(match);
        match.setCalendar(null);
        return this;
    }

    public void setMatchs(Set<Match> matches) {
        this.matchs = matches;
    }

    public Season getSeason() {
        return season;
    }

    public Calendar season(Season season) {
        this.season = season;
        return this;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Calendar)) {
            return false;
        }
        return id != null && id.equals(((Calendar) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Calendar{" +
            "id=" + getId() +
            "}";
    }
}
