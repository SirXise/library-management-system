package com.example.lms2.service;

import com.example.lms2.model.Book;
import com.example.lms2.model.Borrowing;
import com.example.lms2.model.Member;
import com.example.lms2.repository.BorrowingRepository;
import com.example.lms2.repository.MemberRepository;
import com.example.lms2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingService {
    @Autowired
    private BorrowingRepository borrowingRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BookRepository bookRepository;

    // Constructor-based Dependency Injection
    public BorrowingService(BorrowingRepository borrowingRepository, MemberRepository memberRepository, BookRepository bookRepository) {
        this.borrowingRepository = borrowingRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public List<Borrowing> getAllBorrowings() {
        List<Borrowing> borrowings = borrowingRepository.findAll();

        // Map member names and book titles
        return borrowings.stream().map(borrowing -> {
            Member member = memberRepository.findById(borrowing.getMemberId()).orElse(null);
            Book book = bookRepository.findById(borrowing.getBookId()).orElse(null);

            borrowing.setMemberName(member != null ? member.getName() : "Unknown Member");
            borrowing.setBookTitle(book != null ? book.getTitle() : "Unknown Book");

            return borrowing;
        }).collect(Collectors.toList());
    }

    public Borrowing getBorrowingById(Long id) {
        return borrowingRepository.findById(id).orElse(null);
    }

    public Borrowing addBorrowing(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public Borrowing updateBorrowing(Borrowing borrowing) {
        System.out.println("Saving Borrowing: " + borrowing);  // Debug the object
        return borrowingRepository.save(borrowing);
    }

    public void deleteBorrowing(Long id) {
        borrowingRepository.deleteById(id);
    }
}
