import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Job } from '../../model/job';
import { JobService } from '../../service/job.service';

@Component({
  selector: 'app-admin-detail',
  templateUrl: './admin-detail.component.html',
  styleUrls: ['./admin-detail.component.css']
})
export class AdminDetailComponent implements OnInit {

  id: number;
  job: Job = new Job();
  submitted = false;

  constructor(private route: ActivatedRoute,
    private jobService: JobService,
    private router: Router) { }

    ngOnInit() {
      this.job = new Job();
  
      this.id = this.route.snapshot.params['id'];
      
      this.jobService.getJob(this.id)
        .subscribe(data => {
          console.log(data)
          this.job = data;
        }, error => console.log(error));
    }

    updateJob() {
      this.jobService.updateJob(this.id, this.job)
        .subscribe(data => console.log(data), error => console.log(error));
      this.job= new Job();
      this.gotoList();
    }
  
    onSubmit() {
      this.updateJob();    
    }
  
    gotoList() {
      this.router.navigate(['/admin/adminHome']);
    }
  

}
