import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ArticleService } from './core/services/article.service';
import { ArticlesComponent } from './pages/articles/articles.component';
import { ThemesComponent } from './pages/themes/themes.component';
import { ArticleComponent } from './pages/article/article.component';
import { NewArticleComponent } from './pages/new-article/new-article.component';
import { AccountComponent } from './pages/account/account.component';
import { AuthGuard } from './core/guards/auth.guard';
import { NotFoundComponent } from './pages/not-found/not-found.component';

// consider a guard combined with canLoad / canActivate route option
// to manage unauthenticated user to access private routes
const routes: Routes = [
  { path: '',            component: HomeComponent },
  { path: 'login',       component: LoginComponent },
  { path: 'register',    component: RegisterComponent },
  { path: 'articles',    component: ArticlesComponent, canActivate: [AuthGuard] },
  { path: 'themes',      component: ThemesComponent, canActivate: [AuthGuard] },
  { path: 'article/:id', component: ArticleComponent, canActivate: [AuthGuard] },
  { path: 'new-article', component: NewArticleComponent, canActivate: [AuthGuard] },
  { path: 'account',     component: AccountComponent, canActivate: [AuthGuard] },
  { path: '**',          component: NotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
