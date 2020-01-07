import {NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  MatButtonModule, MatCardModule, MatDialogModule, MatInputModule, MatTableModule,
  MatToolbarModule, MatMenuModule, MatIconModule, MatProgressSpinnerModule,
  MatCheckboxModule, MatDividerModule, MatListModule, MatTabsModule, MatGridListModule, MatSnackBarModule,
  MatSlideToggleModule
} from '@angular/material';

@NgModule({
  imports: [ CommonModule, MatToolbarModule, MatButtonModule, MatCardModule, MatInputModule, MatDialogModule,
    MatTableModule, MatMenuModule, MatIconModule, MatProgressSpinnerModule, MatTabsModule, MatGridListModule,
    MatSnackBarModule, MatCheckboxModule, MatSlideToggleModule
  ],
  exports: [
    CommonModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatDialogModule,
    MatTableModule,
    MatMenuModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatCheckboxModule,
    MatDividerModule,
    MatListModule,
    MatTabsModule,
    MatGridListModule,
    MatSnackBarModule,
    MatSlideToggleModule
  ],
})
export class CustomMaterialModule { }
