package com.TT.timetable.repo;

import com.TT.timetable.entities.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Optional;

@Repository
public interface  DayRepository extends JpaRepository<Day,Long> {
    @Query("SELECT d FROM Day d WHERE DATE(d.dayDate) = CURRENT_DATE ")
    Day findDayByDate();
}
