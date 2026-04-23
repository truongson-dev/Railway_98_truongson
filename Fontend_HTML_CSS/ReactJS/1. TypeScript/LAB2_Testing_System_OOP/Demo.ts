// Chương trình bắt đầu chạy từ class này (Giống như Main trong java)
// Import dữ liệu từ các class khác để sử dụng.
import { Account, printInforAccount } from "./Account.js";
import { Department, printDepartment } from "./Department.js";
import { Possition, printPosition } from "./Possition.js";

// Khai báo các phòng ban trên hệ thống
let dep1 = new Department(1, "Sale");  // Tạo mới 1 đối tượng Department.
let dep2 = new Department(2, "Kỹ thuật");
let dep3 = new Department(3, "Phó giám đốc");
let dep4 = new Department(4, "Tài chính");
let dep5 = new Department(5, "Bảo vệ");
console.log('--- Thông tin phòng ban trên hệ thống: ---')
printDepartment(dep1); // Thực hiện in thông tin của đối tượng vừa tạo.
printDepartment(dep2);
printDepartment(dep3);
printDepartment(dep4);
printDepartment(dep5);

// Khai báo các Possition trên hệ thống
let pos1 = new Possition(1, "Dev");  // Tạo mới 1 đối tượng Department.
let pos2 = new Possition(2, "Test");
let pos3 = new Possition(3, "Scrum_Master");
let pos4 = new Possition(4, "PM");
console.log('--- Thông tin Position trên hệ thống: ---')
printPosition(pos1); // Thực hiện in thông tin của đối tượng vừa tạo.
printPosition(pos2);
printPosition(pos3);
printPosition(pos4);

// Khai báo các Account trên hệ thống
let date: Date = new Date("2021-07-01"); // khai báo đổi tượng kiểu date để sử dụng
let acc1 = new Account(1, "daonq1@viettel.com.vn", "daonq1", "daonq1", dep1, pos1, date);
let acc2 = new Account(1, "daonq2@viettel.com.vn", "daonq2", "daonq2", dep1, pos3, date);
let acc3 = new Account(1, "daonq3@viettel.com.vn", "daonq3", "daonq3", dep2, pos2, date);
let acc4 = new Account(1, "daonq4@viettel.com.vn", "daonq4", "daonq4", dep4, pos4, date);
// Gọi hàm in thông tin Account để sử dụng.
printInforAccount(acc1);
printInforAccount(acc2);
printInforAccount(acc3);
printInforAccount(acc4);
