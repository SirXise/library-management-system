package com.example.lms2.controller;

import com.example.lms2.model.Borrowing;
import com.example.lms2.service.BookService;
import com.example.lms2.service.BorrowingService;
import com.example.lms2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private BookService bookService;

    // Display all borrowings
    @GetMapping
    public String getAllBorrowings(Model model) {
        model.addAttribute("borrowings", borrowingService.getAllBorrowings());
        return "borrowing/list"; // Thymeleaf template for displaying borrowings
    }

    // Show form to add a new borrowing
    @GetMapping("/new")
    public String showAddBorrowingForm(Model model) {
        model.addAttribute("borrowing", new Borrowing());
        model.addAttribute("members", memberService.getAllMembers());
        model.addAttribute("books", bookService.getAllBooks());
        return "borrowing/add"; // Thymeleaf template for adding a borrowing
    }

    // Add a new borrowing
    @PostMapping("/add")
    public String addBorrowing(@ModelAttribute Borrowing borrowing) {
        borrowingService.addBorrowing(borrowing);
        return "redirect:/borrowings"; // Redirect to borrowing list after adding
    }

    // Show form to edit an existing borrowing
    @GetMapping("/edit/{id}")
    public String showEditBorrowingForm(@PathVariable Long id, Model model) {
        Borrowing borrowing = borrowingService.getBorrowingById(id);
        if (borrowing != null) {
            model.addAttribute("borrowing", borrowing);
            model.addAttribute("members", memberService.getAllMembers());
            model.addAttribute("books", bookService.getAllBooks());
            return "borrowing/edit"; // Thymeleaf template for editing a borrowing
        }
        return "redirect:/borrowings"; // Redirect if borrowing not found
    }

    // Update an existing borrowing
    @PostMapping("/update")
    public String updateBorrowing(@ModelAttribute Borrowing borrowing) {
        System.out.println("Updated Borrowing: " + borrowing);  // Debug the object
        borrowingService.updateBorrowing(borrowing);
        return "redirect:/borrowings";
    }

    // Delete a borrowing
    @GetMapping("/delete/{id}")
    public String deleteBorrowing(@PathVariable Long id) {
        borrowingService.deleteBorrowing(id);
        return "redirect:/borrowings"; // Redirect to borrowing list after deleting
    }
}
