export class Course {
  public courseId: number;
  public courseTitle: string;
  public description: string;
  public courseFee: number;
  public duration: number;
  public teacherId: string;
  public thumbnail: string;
  public thumbnailPath: string;
  public zoomLink: string;
  public recordList: string[];

  constructor(
    courseId: number,
    courseTitle: string,
    description: string,
    courseFee: number,
    duration: number,
    teacherId: string,
    thumbnail: string,
    thumbnailPath: string,
    zoomLink: string,
    recordList: string[]
  ) {
    this.courseId = courseId;
    this.courseTitle = courseTitle;
    this.description = description;
    this.courseFee = courseFee;
    this.duration = duration;
    this.teacherId = teacherId;
    this.thumbnail = thumbnail;
    this.thumbnailPath = thumbnailPath;
    this.zoomLink = zoomLink;
    this.recordList = recordList;
  }

  // Getter and Setter for courseId
  getcourseId(): number {
    return this.courseId;
  }
  setcourseId(value: number) {
    this.courseId = value;
  }

  // Getter and Setter for courseTitle
  getcourseTitle(): string {
    return this.courseTitle;
  }
  setcourseTitle(value: string) {
    this.courseTitle = value;
  }

  // Getter and Setter for description
  getdescription(): string {
    return this.description;
  }
  setdescription(value: string) {
    this.description = value;
  }

  // Getter and Setter for courseFee
  getcourseFee(): number {
    return this.courseFee;
  }
  setcourseFee(value: number) {
    this.courseFee = value;
  }

  // Getter and Setter for duration
  getduration(): number {
    return this.duration;
  }
  setduration(value: number) {
    this.duration = value;
  }

  // Getter and Setter for teacherId
  getteacherId(): string {
    return this.teacherId;
  }
  setteacherId(value: string) {
    this.teacherId = value;
  }

  // Getter and Setter for thumbnail
  getthumbnail(): string {
    return this.thumbnail;
  }
  setthumbnail(value: string) {
    this.thumbnail = value;
  }

  // Getter and Setter for thumbnailPath
  getthumbnailPath(): string {
    return this.thumbnailPath;
  }
  setthumbnailPath(value: string) {
    this.thumbnailPath = value;
  }

  // Getter and Setter for zoomLink
  getzoomLink(): string {
    return this.zoomLink;
  }
  setzoomLink(value: string) {
    this.zoomLink = value;
  }

  // Getter and Setter for recordList
  getrecordList(): string[] {
    return this.recordList;
  }
  setrecordList(value: string[]) {
    this.recordList = value;
  }
}
export interface Course {
    id: number;
    title: string;
    description: string;
    fee: number;
    duration: number;
    teacherId: string;
    thumbnail: string;
    resources: string[];
  }