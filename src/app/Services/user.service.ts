import { Injectable } from '@angular/core';
import { DataService } from './data.service';
import { HttpClient } from '@angular/common/http';


const  APIUrlUser ="http://localhost:8081/api/user";

@Injectable({
  providedIn: 'root'
})
export class UserService extends DataService{
  constructor(http:HttpClient){
    super(APIUrlUser,http);
  }
}
