package com.example.lms2.controller;

import com.example.lms2.model.Book;
import com.example.lms2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // Display all books
    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book/list"; // Thymeleaf template for displaying books
    }

    // Show form to add a new book
    @GetMapping("/new")
    public String showCreateBookForm(Model model) {
        model.addAttribute("book", new Book()); // Add empty Book object to bind form fields
        return "book/add";  // Ensure this template exists in src/main/resources/templates/book/add.html
    }

    // Add a new book
    @PostMapping
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books"; // Redirect to book list after adding
    }

    // Show form to edit an existing book
    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book); // Load the book to edit
        return "book/edit"; // Ensure this template exists in src/main/resources/templates/book/edit.html
    }

    // Update an existing book
    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return "redirect:/books"; // Redirect to book list after updating
    }

    // Delete a book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books"; // Redirect to book list after deleting
    }
}