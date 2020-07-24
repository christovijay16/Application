import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Job } from '../../model/job';
import { JobService } from '../../service/job.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  job: Job = new Job();
  submitted = false;

  constructor(private jobService: JobService,
    private router: Router) { }

  ngOnInit(): void {
  }

  newJob(): void {
    this.submitted = false;
    this.job = new Job();
  }

  save() {
    this.jobService.createJob(this.job)
      .subscribe(data => console.log(data), error => console.log(error));
      this.job = new Job();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/admin/adminHome']);
  }

}
