package com.TT.timetable.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Transactional
@Data
public class Day {
    public Day(LocalDate date, List<Slot> slots) {
        this.date = date;
        this.slots = slots;
    }

    public Day(Long id, LocalDate date) {
        this.id = id;
        this.date = date;
    }
@Column(name = "day_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_day_id",referencedColumnName = "day_id")
    private List<Slot> slots = new ArrayList<>();

    public Day() {
    }

    public Day(Long id, LocalDate date, List<Slot> slots) {
        this.id = id;
        this.date = date;
        this.slots = slots;
    }

    public Day(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Slot> getSlots() {
        return slots;
    }
public void setSlots(List<Slot> slots){
        this.slots.clear();
        if(slots != null)
            this.slots.addAll(slots);
}

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", date=" + date +
                ", slots=" + slots +
                '}';
    }
}