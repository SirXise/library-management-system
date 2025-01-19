package com.example.lms2.repository;

import com.example.lms2.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    @Query("SELECT b FROM Borrowing b WHERE b.dueDate < :endDate AND (b.returnDate IS NULL OR b.returnDate > :endDate)")
    List<Borrowing> findOverdueBorrowingsUntilEndDate(@Param("endDate") Date endDate);

    @Query("SELECT COUNT(b) FROM Borrowing b WHERE b.dueDate < CURRENT_DATE AND (b.returnDate IS NULL OR b.returnDate > CURRENT_DATE)")
    int findOverdueCount();
}