package com.TT.timetable.controller;


import com.TT.timetable.entities.Day;
import com.TT.timetable.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("getTodayDay")
public class DayController {
    private final DayService dayService;
@Autowired
    public DayController(DayService dayService) {
        this.dayService = dayService;
    }
    @GetMapping
    public Day getDay(){
    return dayService.getCurrentDay();
    }

    @PostMapping
    public Day saveDay(@RequestBody Day Day){
    return dayService.saveDay(Day);
    }
}
