import { Component, OnInit } from '@angular/core';
import { Theme } from 'src/app/core/models/theme.model';
import { ThemeService } from 'src/app/core/services/theme.service';

@Component({
  selector: 'app-themes',
  templateUrl: './themes.component.html',
  styleUrls: ['./themes.component.scss']
})
export class ThemesComponent implements OnInit {

  themes!: Theme[];

  constructor(private themeService: ThemeService) { }

  ngOnInit(): void {
    this.themeService.getAllThemes().subscribe({
      next: (themes) => this.themes = themes,
      error: () => alert('Get all theme error')
    })
  }

}
