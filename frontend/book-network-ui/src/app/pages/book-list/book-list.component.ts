import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { BookService } from '../../services/services';
import { PageResponseBookResponse } from '../../services/models';
import { BookCardComponent } from '../../modules/book/components/book-card/book-card.component';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule, FormsModule, BookCardComponent],
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss'] // corrigido: styleUrl -> styleUrls
})
export class BookListComponent implements OnInit {
  bookResponse: PageResponseBookResponse = {
    content: [],
    totalElements: 0,
    totalPages: 0,
    number: 0,
    size: 0
  };

  page = 0;
  size = 5;

  constructor(
    private readonly bookService: BookService,
    private readonly router: Router
  ) { }

  ngOnInit(): void {
    this.findAllBooks();
  }

  private findAllBooks(): void {
    this.bookService.findAllBooks({ page: this.page, size: this.size }).subscribe({
      next: (response) => {
        this.bookResponse = response;
      },
      error: (err) => {
        console.error('Erro ao buscar livros:', err);
      }
    });
  }
}
