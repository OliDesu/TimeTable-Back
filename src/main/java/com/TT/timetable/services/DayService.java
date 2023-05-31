package com.TT.timetable.services;

import com.TT.timetable.dtos.DayDTO;
import com.TT.timetable.entities.Day;

import com.TT.timetable.entities.Slot;
import com.TT.timetable.repo.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


@Service
public class DayService {
    private final DayRepository dayRepository;
@Autowired
    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }


    public Day getCurrentDay() {
        Optional<Day> optionalDay = this.dayRepository.findDayByDate();
        if (optionalDay.isPresent()) {
            return optionalDay.get();
        } else {
            // Handle the case where no day is found for the current date
            // You can choose to throw an exception or return null, depending on your application's requirements.
            throw new RuntimeException("No day found for the current date.");
        }
    }
public Day saveDay(DayDTO dayDTO) throws ParseException {
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date dayDate = formatter.parse(formatter.format(dayDTO.getDayDate()));

    Day existingDay = this.getDayByDate(dayDate);

    if (existingDay != null) {
        // Update existing day
        existingDay.setSlots(dayDTO.getSlots().stream()
                .map(slotDTO -> new Slot((long) slotDTO.getId(), slotDTO.getStartTime(), slotDTO.getEndTime(), slotDTO.getActivity()))
                .toList());
        System.out.println("LE JOUR UPDATED "+ existingDay.toString());
        Day updatedDay = this.dayRepository.save(existingDay);
        return updatedDay;
    } else {
        System.out.println();
        // Create new day
        Day newDay = new Day((long) dayDTO.getId(), dayDate, dayDTO.getSlots().stream()
                .map(slotDTO -> new Slot((long) slotDTO.getId(), slotDTO.getStartTime(), slotDTO.getEndTime(), slotDTO.getActivity()))
                .toList());

        Day savedDay = this.dayRepository.save(newDay);
        return savedDay;
    }

}


    public Day getDayByDate(Date dayDate) {
    Day d = this.dayRepository.getDayByDate(dayDate);
    return d;
    }
}