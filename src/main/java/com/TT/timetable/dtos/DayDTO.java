package com.TT.timetable.dtos;

import com.TT.timetable.entities.Slot;

import java.util.Date;
import java.util.List;

public class DayDTO {
    private int id;
    private Date date;
    private List<Slot> slots;

    public DayDTO() {
    }

    public DayDTO(int id, Date date, List<Slot> slots) {
        this.id = id;
        this.date = date;
        this.slots = slots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "DayDTO{" +
                "id=" + id +
                ", date=" + date +
                ", slots=" + slots +
                '}';
    }
}