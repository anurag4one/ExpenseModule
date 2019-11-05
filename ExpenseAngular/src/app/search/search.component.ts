import { Component, OnInit } from '@angular/core';
import { Expense } from '../expensemodel/expense';
import { ExpenseService } from '../expense/expense.service';
//import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  expense:Expense;
  id:number;
  submitted:boolean=true;

  constructor(private service: ExpenseService) { }

  ngOnInit() {
    this.expense = new Expense();
  }

  searchExpense() {
    return this.service.findExpense(this.id).subscribe(data => this.expense = data);
   }
}