package com.code.book_network.book;

public class BorrowedBookResponse {

    private Integer id;
    private String title;
    private String authorName;
    private String isbn;
    private double rate;
    private boolean returned;
    private boolean returnApproved;

    public BorrowedBookResponse() {
    }

    public BorrowedBookResponse(Integer id, String title, String authorName, String isbn, double rate, boolean returned, boolean returnApproved) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
        this.rate = rate;
        this.returned = returned;
        this.returnApproved = returnApproved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
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
}
