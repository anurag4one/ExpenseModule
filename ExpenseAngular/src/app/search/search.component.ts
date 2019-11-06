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

  expense: Expense;

  constructor(private service: ExpenseService) {
    this.expense = new Expense();
  }

  ngOnInit() {}

  searchExpense() {
    this.service.findExpense(this.expense.expenseCode).subscribe(data => {
      this.expense = data
    });
  }
}