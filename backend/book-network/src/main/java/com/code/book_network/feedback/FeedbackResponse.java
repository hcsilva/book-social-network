package com.code.book_network.feedback;

public class FeedbackResponse {

    private Double note;
    private String comment;
    private boolean ownFeedback;

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

    public boolean isOwnFeedback() {
        return ownFeedback;
    }

    public void setOwnFeedback(boolean ownFeedback) {
        this.ownFeedback = ownFeedback;
    }
}
