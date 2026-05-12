class Possition {
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
// Hàm in thông tin Position, viết bên ngoài class
function printPosition(position) {
    console.log(`ID: ${position.getId()}, Name: ${position.getName()}`);
}
export { Possition, printPosition };
