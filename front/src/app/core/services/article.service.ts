import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ArticleDetails } from '../models/article-details.model';
import { Article } from '../models/article.model';
import { PostArticle } from '../models/post-article.model';
import { environment } from '../../../environments/environment'
import { HttpMessage } from '../models/http-message.model';

@Injectable({
  providedIn: 'root',
})
export class ArticleService {
  private articlePath = environment.apiUrl + 'articles';

  constructor(private http: HttpClient) {}

  getAllArticles() {
    return this.http.get<Article[]>(this.articlePath);
  }

  getArticle(id: Number) {
    return this.http.get<ArticleDetails[]>(`${this.articlePath}/${id}`);
  }

  crateArticle(newArticle: PostArticle) {
    return this.http.post<HttpMessage>(this.articlePath, newArticle);
  }
}