import { IOrganization } from 'app/shared/model/organization.model';

export interface ILocation {
  id?: number;
  name?: string;
  latitude?: number;
  longitude?: number;
  organizations?: IOrganization[];
}

export class Location implements ILocation {
  constructor(
    public id?: number,
    public name?: string,
    public latitude?: number,
    public longitude?: number,
    public organizations?: IOrganization[]
  ) {}
}
