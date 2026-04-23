import { Person } from "./Person.js";
import myName from "./Person.js";

var Person1 = new Person(1, "Sơn", "Đà Nẵng");
// Person1.id = 1;
// Person1.name = "Sơn";
// Person1.address = "Đà Nẵng";
// console.log(Person1);

var Person2 = new Person(2, "Hải", "Hồ Chí Minh");
// Person2.id = 2;
// Person2.name = "Hải";
// Person2.address = "Hồ Chí Minh";
// console.log(Person2);

// Template string: `abc ${tên biến}`
// console.log(
//   `Thông tin Person 1: id= ${Person1.id}, name= ${Person1.name}, address= ${Person1.address}`,
// );
// console.log(
//   `Thông tin Person 2: id= ${Person2.id}, name= ${Person2.name}, address= ${Person2.address}`,
// );
// Person1.showInfo();
// Person2.showInfo();

// Tạo các đối tượng Student

// student1
// import { Student } from "./Student.js";
// var student1 = new Student(3, "An", "Hà Nội", "VTI01", 85);

// student2
// var student2 = new Student(4, "Bình", "Đà Nẵng", "VTI02", 90);
// Hiển thị thông tin của student1 và student2
// student1.showInfo_Student();
// student2.showInfo_Student();

console.log(`Tên của tôi là: ${myName}`);
