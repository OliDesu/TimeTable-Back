package com.TT.timetable.dtos;

public class SlotDTO {
    private int id;
    private String startTime;
    private int dayId;
    private String activity;

    public SlotDTO() {
    }

    public SlotDTO(int id, String startTime,  int dayId, String activity) {
        this.id = id;
        this.startTime = startTime;
        this.dayId = dayId;
        this.activity = activity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}