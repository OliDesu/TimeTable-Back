package com.TT.timetable.dtos;

import java.util.List;

public class DayDTO {
    private long id;
    private String date;
    private List<SlotDTO> slots;

    public DayDTO(long id, String date, List<SlotDTO> slots) {
        this.id = id;
        this.date = date;
        this.slots = slots;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<SlotDTO> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotDTO> slots) {
        this.slots = slots;
    }
}
