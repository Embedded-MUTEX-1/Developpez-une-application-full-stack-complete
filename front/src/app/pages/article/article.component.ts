import { Component, OnInit } from '@angular/core';

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
  
  ngOnInit(): void {

  }
  
  submitComment() {
    
  }
  
}
