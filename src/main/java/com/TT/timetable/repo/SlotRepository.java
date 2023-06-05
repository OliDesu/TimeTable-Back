package com.TT.timetable.repo;

import com.TT.timetable.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Slot s WHERE s.dayId IS NULL")
    void deleteByFkDayIdIsNull();

}
