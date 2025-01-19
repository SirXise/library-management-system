package com.example.lms2.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private Long bookId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    @Transient
    private String memberName;

    @Transient
    private String bookTitle;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for memberId
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    // Getter and Setter for bookId
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    // Getter and Setter for issueDate
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    // Getter and Setter for dueDate
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    // Getter and Setter for returnDate
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getFormattedIssueDate() {
        return issueDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(issueDate) : "";
    }

    public String getFormattedDueDate() {
        return dueDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(dueDate) : "";
    }

    public String getFormattedReturnDate() {
        return returnDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(returnDate) : "";
    }

    // Getter and Setter for memberName
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    // Getter and Setter for bookTitle
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
}