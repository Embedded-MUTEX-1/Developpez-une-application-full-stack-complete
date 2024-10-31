import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PostComment } from '../models/post-comment.model';
import { environment } from '../../../environments/environment'
import { HttpMessage } from '../models/http-message.model';

@Injectable({
  providedIn: 'root',
})
export class CommentService {
  private commentPath = environment.apiUrl + 'comments';

  constructor(private http: HttpClient) {}

  addComment(newComment: PostComment) {
    return this.http.post<HttpMessage>(this.commentPath, newComment);
  }
}