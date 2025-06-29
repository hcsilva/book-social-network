package com.code.book_network.book;

import com.code.book_network.history.BookTransactionHistory;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book toBook(BookRequest request) {
        Book book = new Book();
        book.setId(request.id());
        book.setTitle(request.title());
        book.setAuthorName(request.authorName());
        book.setSynopsis(request.synopsis());
        book.setArchived(false);
        book.setShareable(request.shareable());

        return book;
    }

    public BookResponse toBookResponse(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setTitle(book.getTitle());
        bookResponse.setAuthorName(book.getAuthorName());
        bookResponse.setIsbn(book.getIsbn());
        bookResponse.setSynopsis(book.getSynopsis());
        bookResponse.setRate(book.getRate());
        bookResponse.setArchived(book.isArchived());
        bookResponse.setShareable(book.isShareable());
        bookResponse.setOwner(book.getOwner().fullName());
        //bookResponse.setCover();

        return bookResponse;
    }

    public BorrowedBookResponse toBorrowedBookResponse(BookTransactionHistory bookTransactionHistory) {
        BorrowedBookResponse borrowedBookResponse = new BorrowedBookResponse();
        borrowedBookResponse.setId(bookTransactionHistory.getBook().getId());
        borrowedBookResponse.setTitle(bookTransactionHistory.getBook().getTitle());
        borrowedBookResponse.setAuthorName(bookTransactionHistory.getBook().getAuthorName());
        borrowedBookResponse.setIsbn(bookTransactionHistory.getBook().getIsbn());
        borrowedBookResponse.setRate(bookTransactionHistory.getBook().getRate());
        borrowedBookResponse.setReturned(bookTransactionHistory.isReturned());
        borrowedBookResponse.setReturnApproved(bookTransactionHistory.isReturnApproved());

        return borrowedBookResponse;
    }
}
