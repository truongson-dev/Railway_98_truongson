class Department {
    id;
    name;
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
    getId() {
        return this.id;
    }
    getName() {
        return this.name;
    }
    setId(id) {
        this.id = id;
    }
    setName(name) {
        this.name = name;
    }
}
// Khai báo 1 function để in thông tin các phòng ban.
function printDepartment(department) {
    console.log(`ID: ${department.getId()}, Name: ${department.getName()}`);
}
export { Department, printDepartment };
