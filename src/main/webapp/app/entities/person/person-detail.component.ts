import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';
import { DomSanitizer } from '@angular/platform-browser';

import { IPerson } from 'app/shared/model/person.model';

@Component({
  selector: 'jhi-person-detail',
  templateUrl: './person-detail.component.html',
})
export class PersonDetailComponent implements OnInit {
  person: IPerson | null = null;
  imgSource: any;

  constructor(protected dataUtils: JhiDataUtils, protected sanitizer: DomSanitizer, protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ person }) => (this.person = person));
    if (this.person && this.person.photo) {
      this.imgSource = this.sanitizer.bypassSecurityTrustResourceUrl(`data:image/png;base64, ${this.person.photo}`);
    }
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType = '', base64String: string): void {
    this.dataUtils.openFile(contentType, base64String);
  }

  previousState(): void {
    window.history.back();
  }
}
