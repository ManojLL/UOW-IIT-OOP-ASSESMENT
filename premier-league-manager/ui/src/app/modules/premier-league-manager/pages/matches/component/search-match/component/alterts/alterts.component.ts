import {Component, Inject, Input, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-alterts',
  templateUrl: './alterts.component.html',
  styleUrls: ['./alterts.component.css']
})
export class AltertsComponent implements OnInit {
  // @Input() error: string;

  constructor(@Inject(MAT_DIALOG_DATA) public data: string) {
  }

  ngOnInit(): void {
  }

}
