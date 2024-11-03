import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/core/models/article.model';

@Component({
  selector: 'app-article-card',
  templateUrl: './article-card.component.html',
  styleUrls: ['./article-card.component.scss']
})
export class ArticleCardComponent implements OnInit {
  
  @Input() article!: Article;
  
  constructor(private router: Router) { }
  
  ngOnInit(): void {
  }
  
  showDetails() {
    this.router.navigateByUrl(`article/${this.article.id}`);
  }
}
