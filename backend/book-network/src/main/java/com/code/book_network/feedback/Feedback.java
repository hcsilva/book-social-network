package com.code.book_network.feedback;

import com.code.book_network.book.Book;
import com.code.book_network.common.BaseEntity;
import com.code.book_network.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Feedback extends BaseEntity {

    private Double note;
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Feedback() {
    }

    public Feedback(Double note, String comment, Book book, User user) {
        this.note = note;
        this.comment = comment;
        this.book = book;
        this.user = user;
    }

    public Feedback(Integer id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, Integer createdBy, Integer lastModifiedBy, Double note, String comment, Book book, User user) {
        super(id, createdDate, lastModifiedDate, createdBy, lastModifiedBy);
        this.note = note;
        this.comment = comment;
        this.book = book;
        this.user = user;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
