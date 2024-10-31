import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Theme } from '../models/theme.model';
import { environment } from '../../../environments/environment'
import { HttpMessage } from '../models/http-message.model';

@Injectable({
  providedIn: 'root',
})
export class ThemeService {
  private themePath = environment.apiUrl + 'themes';

  constructor(private http: HttpClient) {}

  getAllThemes() {
    return this.http.get<Theme>(this.themePath);
  }

  subscribe(themeId: Number, userId: Number) {
    return this.http.patch<HttpMessage>(`${this.themePath}/${themeId}/subscribe/${userId}`, null);
  }

  unsubscribe(themeId: Number, userId: Number) {
    return this.http.patch<HttpMessage>(`${this.themePath}/${themeId}/unsubscribe/${userId}`, null);
  }
}