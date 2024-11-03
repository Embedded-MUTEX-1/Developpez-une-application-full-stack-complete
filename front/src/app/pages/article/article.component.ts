import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ArticleDetails } from 'src/app/core/models/article-details.model';
import { ArticleService } from 'src/app/core/services/article.service';
import { CommentService } from 'src/app/core/services/comment.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit {

  commentData = {
    userId: 0,
    comment: ""
  }

  articleDetails!: ArticleDetails;

  constructor(
    private articleService: ArticleService,
    private commentService: CommentService,
    private route: ActivatedRoute
  ) {}
  
  ngOnInit(): void {
    this.retreiveArticle();
  }
  
  submitComment() {
    this.commentService.addComment(this.commentData)
  }

  retreiveArticle() {
    this.articleService.getArticle(this.route.snapshot.params['id']).subscribe({
      next: (articleDetails) => this.articleDetails = articleDetails,
      error: () => alert("Get Article Error")
    })
  }
}
