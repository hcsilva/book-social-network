package com.code.book_network.history;

import com.code.book_network.book.Book;
import com.code.book_network.common.BaseEntity;
import com.code.book_network.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class BookTransactionHistory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private boolean returned;
    private boolean returnApproved;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public boolean isReturnApproved() {
        return returnApproved;
    }

    public void setReturnApproved(boolean returnApproved) {
        this.returnApproved = returnApproved;
    }

    public BookTransactionHistory(User user, Book book, boolean returned, boolean returnApproved) {
        this.user = user;
        this.book = book;
        this.returned = returned;
        this.returnApproved = returnApproved;
    }

    public BookTransactionHistory(Integer id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, Integer createdBy, Integer lastModifiedBy, User user, Book book, boolean returned, boolean returnApproved) {
        super(id, createdDate, lastModifiedDate, createdBy, lastModifiedBy);
        this.user = user;
        this.book = book;
        this.returned = returned;
        this.returnApproved = returnApproved;
    }

    public BookTransactionHistory() {
    }
}
