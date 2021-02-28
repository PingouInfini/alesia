import { ILocation } from 'app/shared/model/location.model';
import { IPerson } from 'app/shared/model/person.model';

export interface IOrganization {
  id?: number;
  name?: string;
  description?: string;
  address?: string;
  pieceJointeContentType?: string;
  pieceJointe?: any;
  isLocatedOns?: ILocation[];
  people?: IPerson[];
}

export class Organization implements IOrganization {
  constructor(
    public id?: number,
    public name?: string,
    public description?: string,
    public address?: string,
    public pieceJointeContentType?: string,
    public pieceJointe?: any,
    public isLocatedOns?: ILocation[],
    public people?: IPerson[]
  ) {}
}
