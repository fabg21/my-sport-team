package com.fabg21.mysport.team.service.mapper;

import com.fabg21.mysport.team.domain.*;
import com.fabg21.mysport.team.service.dto.CalendarDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Calendar} and its DTO {@link CalendarDTO}.
 */
@Mapper(componentModel = "spring", uses = {SeasonMapper.class})
public interface CalendarMapper extends EntityMapper<CalendarDTO, Calendar> {

    @Mapping(source = "season.id", target = "seasonId")
    CalendarDTO toDto(Calendar calendar);

    @Mapping(target = "matchs", ignore = true)
    @Mapping(target = "removeMatchs", ignore = true)
    @Mapping(source = "seasonId", target = "season")
    Calendar toEntity(CalendarDTO calendarDTO);

    default Calendar fromId(Long id) {
        if (id == null) {
            return null;
        }
        Calendar calendar = new Calendar();
        calendar.setId(id);
        return calendar;
    }
}
