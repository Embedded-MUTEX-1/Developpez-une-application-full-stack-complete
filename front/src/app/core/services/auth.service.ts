import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Auth } from '../models/auth.model';
import { AuthResponse } from '../models/auth-response.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private authPath = environment.apiUrl + 'auth';

  constructor(private httpClient: HttpClient) { }

  public login(auth: Auth): Observable<AuthResponse> {
    return this.httpClient.post<AuthResponse>(this.authPath, auth);
  }
}