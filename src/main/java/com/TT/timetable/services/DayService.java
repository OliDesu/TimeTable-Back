package com.TT.timetable.services;

import com.TT.timetable.entities.Day;

import com.TT.timetable.repo.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DayService {
    private final DayRepository dayRepository;
@Autowired
    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }


public Day getCurrentDay(){


    return this.dayRepository.findDayByDate();
}
public Day saveDay(Day day){
   Day d =  this.dayRepository.save(day);
   return d;
}





}