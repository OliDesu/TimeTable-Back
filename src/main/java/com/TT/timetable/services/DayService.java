package com.TT.timetable.services;

import com.TT.timetable.dtos.DayDTO;
import com.TT.timetable.dtos.SlotDTO;
import com.TT.timetable.entities.Day;
import com.TT.timetable.entities.Slot;
import com.TT.timetable.repo.DayRepository;
import com.TT.timetable.repo.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class DayService {
    private final DayRepository dayRepository;
    private final SlotRepository slotRepository;

    @Autowired
    public DayService(DayRepository dayRepository, SlotRepository slotRepository) {
        this.dayRepository = dayRepository;
        this.slotRepository = slotRepository;
    }

    public Day getCurrentDay() {
        Optional<Day> optionalDay = this.dayRepository.findDayByDate();
        if (optionalDay.isPresent()) {
            return optionalDay.get();
        } else {
            throw new RuntimeException("No day found for the current date.");
        }
    }

    @Transactional
    public void saveDay(DayDTO dayDTO) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dayDate = formatter.parse(formatter.format(dayDTO.getDayDate()));

        Day existingDay = this.getDayByDate(dayDate);

        if (existingDay != null) {
            // Update existing day
            existingDay.setSlots(dayDTO.getSlots().stream()
                    .map(this::convertToSlotEntity)
                    .toList());
        } else {
            // Create new day
            Day newDay = new Day();
            newDay.setDayDate(dayDate);
            newDay.setSlots(dayDTO.getSlots().stream()
                    .map(this::convertToSlotEntity)
                    .toList());
            this.dayRepository.save(newDay);
        }
    }

    private Slot convertToSlotEntity(SlotDTO slotDTO) {
        Slot slot = new Slot();
        slot.setId((long) slotDTO.getId());
        slot.setStartTime(slotDTO.getStartTime());
        slot.setEndTime(slotDTO.getEndTime());
        slot.setActivity(slotDTO.getActivity());
        return slot;
    }

    public Day getDayByDate(Date dayDate) {
        return this.dayRepository.getDayByDate(dayDate);
    }
}