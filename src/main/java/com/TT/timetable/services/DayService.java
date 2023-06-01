package com.TT.timetable.services;

import com.TT.timetable.dtos.DayDTO;
import com.TT.timetable.entities.Day;

import com.TT.timetable.entities.Slot;
import com.TT.timetable.repo.DayRepository;
import com.TT.timetable.repo.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
        /*
        existingDay.setSlots(dayDTO.getSlots().stream()
                .map(slotDTO -> new Slot((long) slotDTO.getId(), slotDTO.getStartTime(),  slotDTO.getActivity()))
                .toList());

        for (Slot slot : existingDay.getSlots()) {
            existingDay.setSlots();
        } */
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
}