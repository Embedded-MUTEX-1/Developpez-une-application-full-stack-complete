import { HttpEventType, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse, HttpResponseBase, HttpStatusCode } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { SessionService } from '../services/session.service';
import { tap } from "rxjs";
import { Router } from "@angular/router";

@Injectable({ providedIn: 'root' })
export class AuthInterceptor implements HttpInterceptor {
  
  constructor(private sessionService: SessionService, private router: Router) {}

  public intercept(request: HttpRequest<any>, next: HttpHandler) {
    if (this.sessionService.getToken()) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${this.sessionService.getToken()}`,
        },
      });
      return next.handle(request).pipe(tap(event => {
        if (event.type === HttpEventType.Response && 
            (event.status == HttpStatusCode.Unauthorized ||
              event.status == HttpStatusCode.Forbidden)) 
        {
          this.sessionService.deleteSession();
          this.router.navigateByUrl("/");
        }
      }));
    }
    return next.handle(request);
  }
}