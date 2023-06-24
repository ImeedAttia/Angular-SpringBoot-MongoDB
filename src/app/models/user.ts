import { Role } from "./role";

export class User {

  id : string;
  userName : string;
  lastName : string;
  role : Role;

  constructor(){
    this.id = "";
    this.userName = "";
    this.lastName = "";
    this.role = new Role();
  }
}
