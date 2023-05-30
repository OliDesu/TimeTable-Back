package com.TT.timetable.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Slot")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  startTime ;
    private String endTime;
    private String activity;
    @ManyToOne
    private Day dayId;

    public Day getDayId() {
        return dayId;
    }

    public void setDayId(Day dayId) {
        this.dayId = dayId;
    }

    public Slot(Long id, String startTime, String endTime, String activity) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activity = activity;
    }

    public Slot() {

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

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
