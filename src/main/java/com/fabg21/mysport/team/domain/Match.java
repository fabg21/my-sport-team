package com.fabg21.mysport.team.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A Match.
 */
@Entity
@Table(name = "match")
public class Match implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "type", nullable = false)
    private String type;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "appointment_hour")
    private Instant appointmentHour;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "place")
    private String place;

    @Column(name = "result")
    private Integer result;

    @Column(name = "score_for")
    private Integer scoreFor;

    @Column(name = "score_against")
    private Integer scoreAgainst;

    @ManyToOne
    @JsonIgnoreProperties("matches")
    private OpposingTeam opponent;

    @ManyToOne
    @JsonIgnoreProperties("matches")
    private Calendar calendar;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Match type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public Match date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Instant getAppointmentHour() {
        return appointmentHour;
    }

    public Match appointmentHour(Instant appointmentHour) {
        this.appointmentHour = appointmentHour;
        return this;
    }

    public void setAppointmentHour(Instant appointmentHour) {
        this.appointmentHour = appointmentHour;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Match startTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public String getPlace() {
        return place;
    }

    public Match place(String place) {
        this.place = place;
        return this;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getResult() {
        return result;
    }

    public Match result(Integer result) {
        this.result = result;
        return this;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getScoreFor() {
        return scoreFor;
    }

    public Match scoreFor(Integer scoreFor) {
        this.scoreFor = scoreFor;
        return this;
    }

    public void setScoreFor(Integer scoreFor) {
        this.scoreFor = scoreFor;
    }

    public Integer getScoreAgainst() {
        return scoreAgainst;
    }

    public Match scoreAgainst(Integer scoreAgainst) {
        this.scoreAgainst = scoreAgainst;
        return this;
    }

    public void setScoreAgainst(Integer scoreAgainst) {
        this.scoreAgainst = scoreAgainst;
    }

    public OpposingTeam getOpponent() {
        return opponent;
    }

    public Match opponent(OpposingTeam opposingTeam) {
        this.opponent = opposingTeam;
        return this;
    }

    public void setOpponent(OpposingTeam opposingTeam) {
        this.opponent = opposingTeam;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Match calendar(Calendar calendar) {
        this.calendar = calendar;
        return this;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Match)) {
            return false;
        }
        return id != null && id.equals(((Match) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Match{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", date='" + getDate() + "'" +
            ", appointmentHour='" + getAppointmentHour() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", place='" + getPlace() + "'" +
            ", result=" + getResult() +
            ", scoreFor=" + getScoreFor() +
            ", scoreAgainst=" + getScoreAgainst() +
            "}";
    }
}
