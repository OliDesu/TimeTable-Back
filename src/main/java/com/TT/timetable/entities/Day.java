package com.TT.timetable.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "days")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dayDate;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "day_id")
    private List<Slot> slots;

    public Day(Long id, Date dayDate, List<Slot> slots) {
        this.id = id;
        this.dayDate = dayDate;
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", dayDate=" + dayDate +
                ", slots=" + slots +
                '}';
    }

    public Day() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDayDate() {
        return dayDate;
    }

    public void setDayDate(Date date) {
        this.dayDate = date;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
