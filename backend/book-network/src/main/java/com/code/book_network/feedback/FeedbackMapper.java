package com.code.book_network.feedback;

import com.code.book_network.book.Book;

import java.util.Objects;

public class FeedbackMapper {


    public Feedback toFeedback(FeedbackRequest request, Book book) {
        Feedback feedback = new Feedback();
        feedback.setNote(request.note());
        feedback.setBook(book);
        feedback.setComment(request.comment());
        return feedback;
    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback, Integer userId) {
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        feedbackResponse.setNote(feedback.getNote());
        feedbackResponse.setComment(feedback.getComment());
        feedbackResponse.setOwnFeedback(Objects.equals(feedback.getCreatedBy(), userId));

        return feedbackResponse;
    }
}
