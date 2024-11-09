import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ArticleDetails } from 'src/app/core/models/article-details.model';
import { ArticleService } from 'src/app/core/services/article.service';
import { CommentService } from 'src/app/core/services/comment.service';
import { SessionService } from 'src/app/core/services/session.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit {

  commentData = {
    userId: 0,
    articleId: 0,
    comment: ""
  }

  articleDetails!: ArticleDetails;

  constructor(
    private articleService: ArticleService,
    private commentService: CommentService,
    private route: ActivatedRoute,
    private sessionService: SessionService
  ) {}
  
  ngOnInit(): void {
    this.retreiveArticle();
  }
  
  submitComment() {
    this.commentData.articleId = this.articleDetails.id;
    this.commentData.userId = this.sessionService.getUserId();

    this.commentService.addComment(this.commentData).subscribe({
      complete: () => { 
        alert("Comment added");
        this.retreiveArticle();
      },
      error: () => alert("Add comment Error")
    })
  }

  retreiveArticle() {
    this.articleService.getArticle(this.route.snapshot.params['id']).subscribe({
      next: (articleDetails) => this.articleDetails = articleDetails,
      error: () => alert("Get Article Error")
    })
  }
}
