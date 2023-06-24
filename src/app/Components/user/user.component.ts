import { Component } from '@angular/core';
import { RoleService } from 'src/app/Services/role.service';
import { UserService } from 'src/app/Services/user.service';
import { Role } from 'src/app/models/role';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  userList : User[] = [];
  roleList : Role[] = [];
  // this variable is get data from model
  userToModify : User = new User();
  // this variable determines wither we are in changing or creating new user
  creatingMode : boolean = true;

  constructor(private userService : UserService,private roleService : RoleService){
    this.getAllUsers();
    this.getAllRoles();
  }

  //Get All Users
  getAllUsers(){
    this.userService.getAll().subscribe((response : User[])=>{
      this.userList = response;
    });
  }
  //Get All Roles
  getAllRoles(){
    this.roleService.getAll().subscribe((response)=>{
      this.roleList = response;
    })
  }
  //Update User
  modifyUser(){
    this.userService.Update(this.userToModify).subscribe(()=>{
      alert("User Updated Successfully");
      window.location.reload();
    })
  }
  //Create new User
  CreateUser(){
      const newUser = {
        userName : this.userToModify.userName,
        lastName : this.userToModify.lastName,
        role : {
          id : this.userToModify.role.id,
        }
      };
      this.userService.Create(newUser).subscribe(()=>{
        alert("User Added Successfully");
        window.location.reload();
      });
  }
  //Delete User
  deleteUser(userId : string){
    if(confirm("Are you sure you want to delete this user !!!")){
      this.userService.Delete(userId).subscribe(()=>{
        alert("User Deleted Successfully");
        window.location.reload();
      });
    }
  }
  // function to verify the event
  openModel(user : User = new User()){
    if(user.id == ""){
      this.userToModify = new User();
    }else{
      this.creatingMode = false
      this.userToModify = user;
    }
  }
}
