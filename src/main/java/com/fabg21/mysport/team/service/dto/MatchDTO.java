package com.fabg21.mysport.team.service.dto;
import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.fabg21.mysport.team.domain.Match} entity.
 */
public class MatchDTO implements Serializable {

    private Long id;

    @NotNull
    private String type;

    @NotNull
    private LocalDate date;

    private Instant appointmentHour;

    private Instant startTime;

    private String place;

    private Integer result;

    private Integer scoreFor;

    private Integer scoreAgainst;


    private Long opponentId;

    private Long calendarId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Instant getAppointmentHour() {
        return appointmentHour;
    }

    public void setAppointmentHour(Instant appointmentHour) {
        this.appointmentHour = appointmentHour;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getScoreFor() {
        return scoreFor;
    }

    public void setScoreFor(Integer scoreFor) {
        this.scoreFor = scoreFor;
    }

    public Integer getScoreAgainst() {
        return scoreAgainst;
    }

    public void setScoreAgainst(Integer scoreAgainst) {
        this.scoreAgainst = scoreAgainst;
    }

    public Long getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(Long opposingTeamId) {
        this.opponentId = opposingTeamId;
    }

    public Long getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Long calendarId) {
        this.calendarId = calendarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MatchDTO matchDTO = (MatchDTO) o;
        if (matchDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), matchDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MatchDTO{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", date='" + getDate() + "'" +
            ", appointmentHour='" + getAppointmentHour() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", place='" + getPlace() + "'" +
            ", result=" + getResult() +
            ", scoreFor=" + getScoreFor() +
            ", scoreAgainst=" + getScoreAgainst() +
            ", opponent=" + getOpponentId() +
            ", calendar=" + getCalendarId() +
            "}";
    }
}
