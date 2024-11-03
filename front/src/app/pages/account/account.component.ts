import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/core/services/user.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  userData = {
    id: 0,
    email: "",
    username: ""
  }
  constructor(private userService: UserService) {}
  
  ngOnInit(): void {
    
  }
  
  submitForm() {
    this.userService.updateUser(this.userData).subscribe({
      complete: () => {
        alert("User updated");
        this.displayUserData();
      },
      error: () => alert("Update error")
    })
  }

  displayUserData() {
    this.userService.getMe()
  }
}

