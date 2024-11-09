import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { environment } from '../../../environments/environment'
import { Register } from '../models/register.model';
import { HttpMessage } from '../models/http-message.model';
import { UpdtadeUser } from '../models/update-user.model';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private userPath = environment.apiUrl + 'users';

  constructor(private http: HttpClient) {}

  register(newUser: Register) {
    return this.http.post<HttpMessage>(`${this.userPath}/register`, newUser);
  }

  getMe(userId: number) {
    return this.http.get<User>(`${this.userPath}/${userId}`);
  }

  updateUser(user: UpdtadeUser) {
    return this.http.put<HttpMessage>(this.userPath, user);
  }
}