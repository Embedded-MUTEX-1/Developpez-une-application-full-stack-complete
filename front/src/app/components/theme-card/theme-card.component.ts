import { Component, Input, OnInit } from '@angular/core';
import { Theme } from 'src/app/core/models/theme.model';
import { SessionService } from 'src/app/core/services/session.service';
import { ThemeService } from 'src/app/core/services/theme.service';

@Component({
  selector: 'app-theme-card',
  templateUrl: './theme-card.component.html',
  styleUrls: ['./theme-card.component.scss']
})
export class ThemeCardComponent implements OnInit {
  
  @Input() theme!: Theme
  @Input() mode!: boolean
  
  constructor(private themeService: ThemeService, private sessionService: SessionService) { }
  
  ngOnInit(): void {
    
  }
  
  action() {
    if(this.mode) {
      this.themeService.subscribe(this.theme.id, this.sessionService.getUserId()).subscribe({
        complete: () => alert('Subscribe successful'),
        error: () => alert('Subscribe error')
      })
    } else {
      this.themeService.unsubscribe(this.theme.id, this.sessionService.getUserId()).subscribe({
        complete: () => alert('Unsubscribe successful'),
        error: () => alert('Unsubscribe error')
      })
    }
      
  }
}
