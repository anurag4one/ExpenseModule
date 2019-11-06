import { Injectable } from '@angular/core';
import { Expense } from '../expensemodel/expense';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ExpenseService {
   
  private baseUrl = 'http://localhost:8182/expense';
  constructor(public http: HttpClient) { }

  saveExpense(exp: Expense):Observable<Expense>{
    return this.http.post<Expense>(`${this.baseUrl}`+'/add', exp);
  }

  findExpense(expCode: number):Observable<Expense>{
    return this.http.get<Expense>(this.baseUrl+"/"+expCode);
  }

  listExpenses(){
  return this.http.get<Expense[]>("localhost:8182/expense/");
  }
  
  modifyExpense(exp: Expense){
    return this.http.put<String>("localhost:8182/expense/update/",exp);
  }

  deleteExpense(expCode: number){
    return this.http.delete<boolean>("localhost:8182/expense/delete/"+expCode);
  }
}