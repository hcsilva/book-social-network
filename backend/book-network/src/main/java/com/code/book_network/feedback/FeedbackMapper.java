package com.code.book_network.feedback;

public class FeedbackMapper {

    public Feedback toFeedback(FeedbackRequest request) {
        Feedback feedback = new Feedback();
        feedback.setNote(request.note());

    }
}
