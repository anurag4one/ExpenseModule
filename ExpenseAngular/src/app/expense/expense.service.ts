import { Injectable } from '@angular/core';
import { Expense } from '../expensemodel/expense';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ExpenseService {
   
  constructor(public http: HttpClient) { }

  saveExpense(exp: Expense){
    return this.http.post<Expense>("localhost:8182/expense/add", exp);
  }

  findExpense(expCode: number):Observable<Expense>{
    return this.http.get<Expense>("localhost:8182/expense/expenseCode/"+expCode);
  }

  listExpenses(){
  return this.http.get<Expense[]>("localhost:8182/expense/");
  }
  
  modifyExpense(expCode: number, expType: String, expDescription: String){
    return this.http.put<String>("localhost:8182/expense/update/",expCode);
  }

  deleteExpense(expCode: number){
    return this.http.delete<boolean>("localhost:8182/expense/delete/"+expCode);
  }

}