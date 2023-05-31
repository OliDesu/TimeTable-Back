package com.TT.timetable.controller;

import com.TT.timetable.dtos.DayDTO;
import com.TT.timetable.entities.Day;
import com.TT.timetable.entities.Slot;
import com.TT.timetable.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        System.out.println(currentDay);
        return new ResponseEntity<>(currentDay, HttpStatus.OK);
    }

    @PostMapping("/set")
    public ResponseEntity<DayDTO> saveDay(@RequestBody DayDTO dayDTO) throws ParseException {
        this.dayService.saveDay(dayDTO);
       return new ResponseEntity<>(dayDTO,HttpStatus.OK);
    }
}