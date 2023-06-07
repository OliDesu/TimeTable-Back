package com.TT.timetable.controller;

import com.TT.timetable.dtos.DayDTO;
import com.TT.timetable.entities.Day;
import com.TT.timetable.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/day")

public class DayController {

    @Autowired
    private DayService dayService;

    @PostMapping("/set")
    public Day saveDayWithSlots(@RequestBody DayDTO day) {
        return dayService.saveDayWithSlots(day);
    }

    @GetMapping("/get")
    public Day getCurrentDay() {
        return dayService.getCurrentDay();
    }


    @GetMapping("/getSpecificDay")
    public Day getSpecificDay(@RequestBody DayDTO date) {

        return dayService.getSpecificDay(date.getDate());
    }

    @GetMapping("/getFilledDays")
    public List<Date> getFilledDays() {
        return dayService.getFilledDays();
    }
}