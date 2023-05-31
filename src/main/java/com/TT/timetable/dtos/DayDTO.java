package com.TT.timetable.dtos;

import java.util.Date;
import java.util.List;

public class DayDTO {
    private int id;
    private Date dayDate;
    private List<SlotDTO> slots;

    public DayDTO() {
    }

    public DayDTO(int id, Date dayDate, List<SlotDTO> slots) {
        this.id = id;
        this.dayDate = dayDate;
        this.slots = slots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDayDate() {
        return dayDate;
    }

    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    public List<SlotDTO> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotDTO> slots) {
        this.slots = slots;
    }
}