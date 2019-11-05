import { Component, OnInit } from '@angular/core';
import { Expense } from '../expensemodel/expense';
import { ExpenseService } from '../expense/expense.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

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
  deleteExpense() {
    var ans = confirm("Are You Sure You want To delete?");
    if (ans)
      this.service.deleteExpense(this.id);
  }
}