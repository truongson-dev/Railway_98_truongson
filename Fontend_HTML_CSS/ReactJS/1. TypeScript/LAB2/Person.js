class Person {
    // Khai báo thuộc tính
    id;
    name;
    address;
    constructor(id, name, address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    // có thể tạo thêm method(hàm) trong class
    showInfo() {
        console.log(`Thông tin Person: id= ${this.id}, name= ${this.name}, address= ${this.address}`);
    }
    // khai báo các hàm getter và setter
    getId() {
        return this.id;
    }
    setId(id) {
        this.id = id;
    }
    getName() {
        return this.name;
    }
    setName(name) {
        this.name = name;
    }
    getAddress() {
        return this.address;
    }
    setAddress(address) {
        this.address = address;
    }
}
// Cách export 1
var myName = "Sơn";
export default myName;
// Cách export 2
export var number = [1, 2, 3, 4, 5];
// Cách export 3
export { Person };
