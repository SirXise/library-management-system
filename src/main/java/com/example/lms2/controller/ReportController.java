package com.example.lms2.controller;

import com.example.lms2.model.Book;
import com.example.lms2.model.Borrowing;
import com.example.lms2.model.Member;
import com.example.lms2.repository.BookRepository;
import com.example.lms2.repository.BorrowingRepository;
import com.example.lms2.repository.MemberRepository;
import com.example.lms2.service.ReportService;
import com.example.lms2.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookRepository bookRepository;

    // Display all reports
    @GetMapping
    public String viewReports(Model model) {
        model.addAttribute("reports", reportService.getAllReports());
        return "report/list"; // Thymeleaf template for displaying reports
    }

    // Generate overdue report
    @PostMapping("/generate-overdue")
    public String generateOverdueReport() {
        reportService.generateOverdueReport();
        return "redirect:/reports"; // Redirect to reports list after generating
    }

    // View a specific report by ID
    @GetMapping("/view/{id}")
    public String viewReport(@PathVariable Long id, Model model) {
        Report report = reportService.getReportById(id);

        // Fetch overdue borrowings until the report's generation date
        List<Borrowing> overdueBorrowings = reportService.getOverdueBorrowingsUntilEndDate(id);

        // Populate member and book details
        for (Borrowing borrowing : overdueBorrowings) {
            Member member = memberRepository.findById(borrowing.getMemberId()).orElse(null);
            Book book = bookRepository.findById(borrowing.getBookId()).orElse(null);
            borrowing.setMemberName(member != null ? member.getName() : "Unknown");
            borrowing.setBookTitle(book != null ? book.getTitle() : "Unknown");
        }

        model.addAttribute("report", report);
        model.addAttribute("overdueBorrowings", overdueBorrowings);

        return "report/view";
    }
//    @GetMapping("/view/{id}")
//    public String viewReport(@PathVariable Long id, Model model) {
//        Report report = reportService.getReportById(id);
//        if (report != null) {
//            model.addAttribute("report", report);
//            model.addAttribute("overdueBorrowings", reportService.getOverdueBorrowingsUntilEndDate(id)); // Add overdue borrowings
//            return "report/view";  // Return the Thymeleaf template to display the report details
//        }
//        return "redirect:/reports";  // Redirect to the reports list if the report is not found
//    }
}
