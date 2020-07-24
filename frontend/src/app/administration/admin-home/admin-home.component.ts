import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { Job } from '../../model/job';
import { JobService } from '../../service/job.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  jobs: Observable<Job[]>;

  constructor(private jobService: JobService,
    private router: Router) { }

    ngOnInit() {
      this.reloadData();
    }
  
    reloadData() {
      this.jobs = this.jobService.getJobsList();
    }
  
    deleteJob(id: number) {
      this.jobService.deleteJob(id)
        .subscribe(
          data => {
            console.log(data);
            this.reloadData();
          },
          error => console.log(error));
    }
  
    jobDetails(id: number){      
      this.router.navigate(['/admin/adminDetail', id]);
    }

    newjob(){      
      this.router.navigate(['/admin']);
    }

}
