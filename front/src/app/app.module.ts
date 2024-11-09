import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { NavHeaderComponent } from './components/nav-header/nav-header.component';
import { HeaderComponent } from './components/header/header.component';
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './pages/register/register.component';
import { ArticlesComponent } from './pages/articles/articles.component';
import { ArticleCardComponent } from './components/article-card/article-card.component';
import { ThemesComponent } from './pages/themes/themes.component';
import { ThemeCardComponent } from './components/theme-card/theme-card.component';
import { ArticleComponent } from './pages/article/article.component';
import { CommentComponent } from './components/comment/comment.component';
import { NewArticleComponent } from './pages/new-article/new-article.component';
import { AccountComponent } from './pages/account/account.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AuthInterceptor } from './core/interceptors/auth.interceptor';
import { NotFoundComponent } from './pages/not-found/not-found.component';

@NgModule({
  declarations: [AppComponent, HomeComponent, LoginComponent, NavHeaderComponent, HeaderComponent, RegisterComponent, ArticlesComponent, ArticleCardComponent, ThemesComponent, ThemeCardComponent, ArticleComponent, CommentComponent, NewArticleComponent, AccountComponent, NotFoundComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
