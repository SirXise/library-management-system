package com.example.lms2.service;

import com.example.lms2.model.Report;
import com.example.lms2.model.Borrowing;
import com.example.lms2.model.Member;
import com.example.lms2.repository.MemberRepository;
import com.example.lms2.repository.ReportRepository;
import com.example.lms2.repository.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Report generateOverdueReport() {
        // Logic to count overdue borrowings
        int overdueCount = borrowingRepository.findOverdueCount();

        // Create a new report
        Report report = new Report();
        report.setReportType("Overdue Report");
        report.setParameters("Overdue Borrowings");
        report.setGenerationDate(new Date());
        report.setOverdueCount(overdueCount);

        // Save the report to the repository
        return reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // Get a specific report by ID
    public Report getReportById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    // Get the list of overdue borrowings until the endDate of the report
    public List<Borrowing> getOverdueBorrowingsUntilEndDate(Long reportId) {
        Report report = getReportById(reportId);
        if (report != null) {
            Date endDate = report.getGenerationDate();  // Use the report's generationDate as the endDate
            return borrowingRepository.findOverdueBorrowingsUntilEndDate(endDate); // Fetch overdue borrowings until the endDate
        }
        return null;
    }
}
