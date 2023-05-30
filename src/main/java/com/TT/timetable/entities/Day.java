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
    private Date date;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
    private List<Slot> slots;

    public Day(Long id, Date date, List<Slot> slots) {
        this.id = id;
        this.date = date;
        this.slots = slots;
    }

    public Day() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
