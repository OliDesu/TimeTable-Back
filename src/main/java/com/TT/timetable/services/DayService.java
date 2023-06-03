package com.TT.timetable.services;

import com.TT.timetable.dtos.DayDTO;
import com.TT.timetable.entities.Day;

import com.TT.timetable.repo.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/*
@Service
public class DayService {
    private final DayRepository dayRepository;
    private final SlotRepository slotRepository;
@Autowired
    public DayService(DayRepository dayRepository,SlotRepository slotRepository) {
        this.dayRepository = dayRepository;
        this.slotRepository = slotRepository;
    }


    public Day getCurrentDay() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dayDate = formatter.parse
                (formatter.
                format(new Date()
                         ));
        Day d = this.getDayByDate(dayDate);
        Day f = new Day(d.getId(),d.getDayDate(),d.getSlots());
        List<Slot> slots =  this.slotRepository.findSlotsByDayId(f.getId());
        f.setSlots(slots);
        System.out.println("FFFFFFFFFFFFFFF"+f);
        return f;

    }
public Day saveDay(DayDTO dayDTO) throws ParseException {
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date dayDate = formatter.parse(formatter.format(dayDTO.getDayDate()));
    System.out.println("CURRENT DAY"+dayDate);
    Day existingDay = this.getDayByDate(dayDate);

    if (existingDay != null) {
        List<Slot> newSlots = new ArrayList<>();
        dayDTO.getSlots().forEach(slotDTO -> newSlots.add(new Slot((long) slotDTO.getId(), slotDTO.getStartTime(),  slotDTO.getActivity(),existingDay)));
        // Update existing day

        System.out.println("EXISTING");
        existingDay.setSlots(newSlots);
        return this.dayRepository.save(existingDay);

    } else {
        System.out.println();
        // Create new day
        Day newDay = new Day((long) dayDTO.getId(), dayDate, dayDTO.getSlots().stream()
                .map(slotDTO -> new Slot((long) slotDTO.getId(), slotDTO.getStartTime(), slotDTO.getActivity()))
                .toList());
        System.out.println("CREATING");

        Day savedDay = this.dayRepository.save(newDay);
        return savedDay;
    }

}


    public Day getDayByDate(Date dayDate) {
    Day d = this.dayRepository.getDayByDate(dayDate);
    return d;
    }
} */

@Service
public class DayService {
    @Autowired
    private DayRepository dayRepository;

    public Day saveDayWithSlots(DayDTO dayDTO) {

        Day day = new Day((long)dayDTO.getId(),this.convertToLocalDateViaInstant(dayDTO.getDate()),dayDTO.getSlots());
        Day existingDay = this.dayRepository.findByDate(day.getDate());
        if(existingDay != null){
            existingDay.setSlots(day.getSlots());
            return dayRepository.save(existingDay);
        }
        else{
            return dayRepository.save(day);
        }

    }

    public Day getCurrentDay() {
        LocalDate today = LocalDate.now();
        return dayRepository.findByDate(today);
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}