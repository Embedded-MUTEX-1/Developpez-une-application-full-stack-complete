import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/core/models/article.model';
import { ArticleService } from 'src/app/core/services/article.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.scss']
})
export class ArticlesComponent implements OnInit {
  
  articles!: Article[]
  
  constructor(private articleService: ArticleService, private router: Router) { }
  
  ngOnInit(): void {
    this.articleService.getAllArticles().subscribe({
      next: (articles) => this.articles = articles,
      error: () => alert("Get All article error")
    })
  }

  create() {
    this.router.navigateByUrl('new-article')
  }
}
