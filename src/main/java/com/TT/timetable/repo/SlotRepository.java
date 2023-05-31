package com.TT.timetable.repo;

import com.TT.timetable.entities.Day;
import com.TT.timetable.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SlotRepository  extends JpaRepository<Slot,Long> {
    @Modifying
    @Query("update Slot s set s.activity = ?1 where s.id = ?2")
    void updateInfoDay(String activity, Long id );
}
