import { Component, EventEmitter, Input, Output } from '@angular/core';
import { BookResponse } from '../../../../services/models';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RatingComponent } from '../rating/rating.component';

@Component({
  selector: 'app-book-card',
  imports: [CommonModule, FormsModule, RatingComponent],
  templateUrl: './book-card.component.html',
  styleUrl: './book-card.component.scss'
})
export class BookCardComponent {

  private _book: BookResponse = {};
  private _bookCover: string | undefined;
  private _manage: boolean = false;

  get book(): BookResponse {
    return this._book;
  }

  @Input()
  set book(value: BookResponse) {
    this._book = value;
  }

  get bookCover(): string | undefined {
    if (this._book.cover) {
      return 'data:image/jpg;base64, ' + this._book.cover;
    }

    return '';
  }

  get manage(): boolean {
    return this._manage;
  }

  @Input()
  set manage(value: boolean) {
    this._manage = value;
  }

  @Output()
  private share: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();
  @Output()
  private archive: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();
  @Output()
  private addToWaitingList: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();
  @Output()
  private borrow: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();
  @Output()
  private edit: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();
  @Output()
  private details: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();

  onShowDetails() {
    this.details.emit(this._book);
  }

  onBorrow() {
    this.borrow.emit(this._book);
  }

  onAddToWaitingList() {
    this.addToWaitingList.emit(this._book);
  }

  onEdit() {
    this.edit.emit(this._book);
  }

  onShare() {
    this.share.emit(this._book);
  }

  onArchive() {
    this.archive.emit(this._book);
  }
}
