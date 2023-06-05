package com.TT.timetable.services;

import com.TT.timetable.dtos.DayDTO;
import com.TT.timetable.entities.Day;
import com.TT.timetable.repo.DayRepository;
import com.TT.timetable.repo.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DayService {
    @Autowired
    private DayRepository dayRepository;
    @Autowired
    private SlotRepository slotRepository;

    public Day saveDayWithSlots(DayDTO dayDTO) {

        Day day = new Day(this.convertToLocalDateViaInstant(dayDTO.getDate()),dayDTO.getSlots());

        Day existingDay = this.dayRepository.findByDate(day.getDate());
        if(existingDay != null){
            existingDay.setSlots(day.getSlots());
            this.dayRepository.save(existingDay);
            this.slotRepository.deleteByFkDayIdIsNull();
            return null;
        }
        else{
            return dayRepository.save(day);
        }

    }

    public Day getCurrentDay() {
        LocalDate today = LocalDate.now();
        return this.dayRepository.findByDate(today);

    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public Day getSpecificDay(Date date) {
        LocalDate newDate = this.convertToLocalDateViaInstant(date);
        return this.dayRepository.findByDate(newDate);

    }

    public List<Date> getFilledDays() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        List<LocalDate> transitLocalDate = this.dayRepository.findAllByDate();
        List<Date> dates = new ArrayList<>();

        transitLocalDate.forEach(a -> {
            Date date = Date.from(a.atStartOfDay(defaultZoneId).toInstant());
            dates.add(date);
        });
return dates;
    }
}