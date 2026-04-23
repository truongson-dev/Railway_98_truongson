import { Person } from "./Person.js";

class Student extends Person {
  private classVTI: string;
  private testScore: number;

  constructor(
    id: number,
    name: string,
    address: string,
    classVTI: string,
    core: number,
  ) {
    super(id, name, address);
    this.classVTI = classVTI;
    this.testScore = core;
  }

  //   CTRL + SHIFT + P

  /**
   * Getter classVTI
   * @return {string}
   */
  public getClassVTI(): string {
    return this.classVTI;
  }

  /**
   * Getter testScore
   * @return {number}
   */
  public getTestScore(): number {
    return this.testScore;
  }

  /**
   * Setter classVTI
   * @param {string} value
   */
  public setClassVTI(value: string) {
    this.classVTI = value;
  }

  /**
   * Setter testScore
   * @param {number} value
   */

  public setTestScore(value: number) {
    this.testScore = value;
  }
  //   Viết hàm hiển thị thông tin của Student, bao gồm cả thông tin của Person
  public showInfo_Student(): void {
    // Gọi hàm showInfo() của Person để hiển thị thông tin cơ bản
    super.showInfo();
    // Hiển thị thêm thông tin của Student
    console.log(
      `Thông tin Student: classVTI=${this.classVTI}, testScore=${this.testScore}`,
    );
  }
}

export { Student };
