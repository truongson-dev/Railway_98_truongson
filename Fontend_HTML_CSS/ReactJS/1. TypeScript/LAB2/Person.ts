class Person {
  // Khai báo thuộc tính
  private id: number;
  private name: string;
  private address: string;

  constructor(id: number, name: string, address: string) {
    this.id = id;
    this.name = name;
    this.address = address;
  }
  // có thể tạo thêm method(hàm) trong class
  public showInfo(): void {
    console.log(
      `Thông tin Person: id= ${this.id}, name= ${this.name}, address= ${this.address}`,
    );
  }

  // khai báo các hàm getter và setter
  public getId(): number {
    return this.id;
  }
  public setId(id: number): void {
    this.id = id;
  }
  public getName(): string {
    return this.name;
  }
  public setName(name: string): void {
    this.name = name;
  }
  public getAddress(): string {
    return this.address;
  }
  public setAddress(address: string): void {
    this.address = address;
  }
}
// Cách export 1
var myName: string = "Sơn";
export default myName;
// Cách export 2
export var number: number[] = [1, 2, 3, 4, 5];
// Cách export 3
export { Person };
