class Possition {
  id: number;
  name: string;
  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
  }
  getId(): number {
    return this.id;
  }
  getName(): string {
    return this.name;
  }
  setId(id: number): void {
    this.id = id;
  }
  setName(name: string): void {
    this.name = name;
  }
}
// Hàm in thông tin Position, viết bên ngoài class
function printPosition(position: Possition): void {
  console.log(`ID: ${position.getId()}, Name: ${position.getName()}`);
}

export { Possition, printPosition };
