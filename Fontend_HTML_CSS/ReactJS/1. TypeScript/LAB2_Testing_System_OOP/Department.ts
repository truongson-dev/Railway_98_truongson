class Department {
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
// Khai báo 1 function để in thông tin các phòng ban.
function printDepartment(department: Department): void {
    console.log(`ID: ${department.getId()}, Name: ${department.getName()}`)
}

export { Department, printDepartment }