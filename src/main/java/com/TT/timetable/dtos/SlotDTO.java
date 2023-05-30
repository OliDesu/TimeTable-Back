package com.TT.timetable.dtos;

public class SlotDTO {
    private Long id;
    private String startTime;
    private String endTime;
    private String activity;

    public SlotDTO(Long id, String startTime, String endTime, String activity) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activity = activity;
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
