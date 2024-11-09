import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Theme } from 'src/app/core/models/theme.model';
import { ArticleService } from 'src/app/core/services/article.service';
import { SessionService } from 'src/app/core/services/session.service';
import { ThemeService } from 'src/app/core/services/theme.service';

@Component({
  selector: 'app-new-article',
  templateUrl: './new-article.component.html',
  styleUrls: ['./new-article.component.scss']
})
export class NewArticleComponent implements OnInit {
  
  newArticleData = {
    userId: this.sessionService.getUserId(),
    title: "",
    content: "",
    themeId: 0
  }

  themes!: Theme[];

  constructor(private articleService: ArticleService, private themeService: ThemeService, private sessionService: SessionService, private router: Router) {}
  
  ngOnInit(): void {
    this.themeService.getAllThemes().subscribe({
      next: (themes: Theme[]) => this.themes = themes,
      error: () => alert('Get theme error')
    })
  }
  
  submitForm() {
    this.articleService.createArticle(this.newArticleData).subscribe({
      complete: () => {
        alert("Article created")
        this.router.navigateByUrl("/articles")
      },
      error: () => alert('Create article error')
    })
  }
}
