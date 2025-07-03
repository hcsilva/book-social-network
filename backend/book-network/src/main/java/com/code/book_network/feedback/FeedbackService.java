package com.code.book_network.feedback;

import com.code.book_network.book.Book;
import com.code.book_network.book.BookRepository;
import com.code.book_network.exception.OperationNotPermittedException;
import com.code.book_network.user.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FeedbackService {

    private final BookRepository bookRepository;
    private final FeedbackMapper feedbackMapper;

    public FeedbackService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Integer save(FeedbackRequest request, Authentication connectedUser) {
        Book book = bookRepository.findById(request.bookId()).orElseThrow(() -> new EntityNotFoundException("No book found with this ID::" + request.bookId()));
        User user = (User) connectedUser.getPrincipal();

        if (book.isArchived() || !book.isShareable()) {
            throw new OperationNotPermittedException("You cannot give a feedback for an archived or not shared book");
        }

        if (Objects.equals(book.getOwner().getId(), user.getId())) {
            throw new OperationNotPermittedException("You cannot give a feedback to your own book");
        }

        Feedback feedback = feedbackMapper.toFeedback(request);
        return null;
    }
}
