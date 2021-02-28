import { Moment } from 'moment';
import { IOrganization } from 'app/shared/model/organization.model';
import { Color } from 'app/shared/model/enumerations/color.model';

export interface IPerson {
  id?: number;
  name?: string;
  nickname?: string;
  size?: number;
  dateOfBirth?: Moment;
  hairColor?: Color;
  shoeSize?: number;
  description?: string;
  photoContentType?: string;
  photo?: any;
  belongsTos?: IOrganization[];
}

export class Person implements IPerson {
  constructor(
    public id?: number,
    public name?: string,
    public nickname?: string,
    public size?: number,
    public dateOfBirth?: Moment,
    public hairColor?: Color,
    public shoeSize?: number,
    public description?: string,
    public photoContentType?: string,
    public photo?: any,
    public belongsTos?: IOrganization[]
  ) {}
}
