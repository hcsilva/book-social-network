package com.code.book_network.book;

import com.code.book_network.common.BaseEntity;
import com.code.book_network.feedback.Feedback;
import com.code.book_network.history.BookTransactionHistory;
import com.code.book_network.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Book extends BaseEntity {

    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String bookCover;
    private boolean archived;
    private boolean shareable;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "book")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;

    public Book(String title, String authorName, String isbn, String synopsis, String bookCover, boolean archived, boolean shareable, User owner, List<Feedback> feedbacks, List<BookTransactionHistory> histories) {
        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
        this.synopsis = synopsis;
        this.bookCover = bookCover;
        this.archived = archived;
        this.shareable = shareable;
        this.owner = owner;
        this.feedbacks = feedbacks;
        this.histories = histories;
    }

    public Book(Integer id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, Integer createdBy, Integer lastModifiedBy, String title, String authorName, String isbn, String synopsis, String bookCover, boolean archived, boolean shareable, User owner, List<Feedback> feedbacks, List<BookTransactionHistory> histories) {
        super(id, createdDate, lastModifiedDate, createdBy, lastModifiedBy);
        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
        this.synopsis = synopsis;
        this.bookCover = bookCover;
        this.archived = archived;
        this.shareable = shareable;
        this.owner = owner;
        this.feedbacks = feedbacks;
        this.histories = histories;
    }

    public Book() {

    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<BookTransactionHistory> getHistories() {
        return histories;
    }

    public void setHistories(List<BookTransactionHistory> histories) {
        this.histories = histories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isShareable() {
        return shareable;
    }

    public void setShareable(boolean shareable) {
        this.shareable = shareable;
    }
}
