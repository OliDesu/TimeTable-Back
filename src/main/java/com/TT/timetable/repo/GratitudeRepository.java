package com.TT.timetable.repo;

import com.TT.timetable.entities.Gratitude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GratitudeRepository extends JpaRepository<Gratitude, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Gratitude g WHERE g.dayId IS NULL")
    void deleteByFkDayIdIsNull();

}
