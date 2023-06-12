package com.TT.timetable.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;
@Entity
@Transactional
@Data
public class Gratitude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @Column(name = "fk_day_id")
    private Long dayId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public Gratitude(Long id, String content, Long dayId) {
        this.id = id;
        this.content = content;
        this.dayId = dayId;
    }

    public Gratitude() {
    }
}



