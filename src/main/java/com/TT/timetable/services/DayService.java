package com.TT.timetable.services;

import com.TT.timetable.dtos.DayDTO;
import com.TT.timetable.entities.Day;
import com.TT.timetable.entities.Slot;
import com.TT.timetable.repo.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

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
public Day saveDay(DayDTO dayDTO){
   Day d =  this.dayRepository.save(this.dayDTOToDay(dayDTO));
   return d;
}


private Day dayDTOToDay(DayDTO dayDTO){
    return new Day(dayDTO.getId(),new Date(dayDTO.getDate()),dayDTO.getSlots().stream().map(slotDTO ->{
        Slot slot = new Slot();
        slot.setId(slotDTO.getId());
        slot.setActivity(slotDTO.getActivity());
        slot.setEndTime(slotDTO.getEndTime());
        slot.setStartTime(slotDTO.getStartTime());
        return slot;
    } ).toList());
}


}