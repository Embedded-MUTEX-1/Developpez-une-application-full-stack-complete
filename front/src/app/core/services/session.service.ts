import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SessionService {
  
  private userId: number | undefined = 0;
  private token: string | null;

  constructor() {
    const id = localStorage.getItem('userId');
    if (id != null) this.userId = parseInt(id)

    this.token = localStorage.getItem('token');
  }

  setUserId(userId: number) {
    localStorage.setItem('userId', userId.toString())
    this.userId = userId;
  }

  getUserId() {
    return this.userId!;
  }

  setToken(token: string) {
    localStorage.setItem('token', token)
    this.token = token;
  }

  getToken() {
    return this.token;
  }

  deleteSession() {
    localStorage.removeItem('token');
    this.token = null;

    localStorage.removeItem('userId')
    this.userId = 0;
  }
}