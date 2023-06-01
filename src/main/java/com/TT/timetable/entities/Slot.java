package com.TT.timetable.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Slot")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  startTime ;
    private String activity;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name ="day_id")
    private Day day;

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Slot(Long id, String startTime, String activity, Day day) {
        this.id = id;
        this.startTime = startTime;
        this.activity = activity;
        this.day = day;
    }

    public Slot(Long id, String startTime, String activity) {
        this.id = id;
        this.startTime = startTime;
        this.activity = activity;
    }

    public Slot() {

    }

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", activity='" + activity + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
