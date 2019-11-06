import { Component, OnInit } from '@angular/core';
import { Expense } from '../expensemodel/expense';
import { ExpenseService } from '../expense/expense.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modify',
  templateUrl: './modify.component.html',
  styleUrls: ['./modify.component.css']
})
export class ModifyComponent implements OnInit {

  expense:Expense;
  expense1: Expense;
  
  constructor(private service: ExpenseService, private route:Router) {
    this.expense = new Expense();
   }
  ngOnInit() {
    this.expense = new Expense();
  }

  modifyExpense(){
    this.service.modifyExpense(this.expense);
    this.expense = new Expense();
    this.route.navigate(['search']);  
  }
}