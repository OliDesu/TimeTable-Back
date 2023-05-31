package com.TT.timetable.controller;

import com.TT.timetable.dtos.DayDTO;
import com.TT.timetable.entities.Day;
import com.TT.timetable.entities.Slot;
import com.TT.timetable.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day")
public class DayController {
    private final DayService dayService;

    @Autowired
    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @GetMapping("/get")
    public ResponseEntity<Day> getDay() {
        Day currentDay = dayService.getCurrentDay();
        return new ResponseEntity<>(currentDay, HttpStatus.OK);
    }

    @PostMapping("/set")
    public ResponseEntity<Day> saveDay(@RequestBody DayDTO dayDTO) {
        System.out.println("LAZBEAIZEAOIEAZEIUAZH");
        Day day1 = new Day((long)dayDTO.getId(),dayDTO.getDayDate(),dayDTO.getSlots().stream().map(slotDTO -> {
             return new Slot((long) slotDTO.getId(), slotDTO.getStartTime(), slotDTO.getEndTime(),slotDTO.getActivity());
        }).toList());
        Day savedDay = dayService.saveDay(day1);
        return new ResponseEntity<>(savedDay, HttpStatus.CREATED);
    }
}