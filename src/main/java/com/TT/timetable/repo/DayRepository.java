package com.TT.timetable.repo;

import com.TT.timetable.entities.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {
    Day findByDate(LocalDate date);
@Query("SELECT d.date from Day d ")
List<LocalDate> findAllByDate();
}