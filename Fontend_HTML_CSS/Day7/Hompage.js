// function showMessage() {
//   console.log("Trương Thanh Sơn");
//   console.log("Trương Thanh Sơn");
//   console.log("Trương Thanh Sơn");
//   console.log("Trương Thanh Sơn");
// }
// In thông tin ra màn hình console
console.log("Trương Thanh Sơn");
console.log("VTI");

// Khai báo biến trong Javascript
var myName = "Trương Thanh Sơn"; //string
var myAge = 20; //number
var salary = 1500.5; //number
var gender = true; //boolean

console.log("My name is: " + myName);
console.log("My age is: " + myAge);
console.log("My salary is: " + salary);

// Kiểu dữ liệu object
var person1 = {
  // Thuộc tính
  id: 1,
  name: "Sơn",
  age: 20,
  salary: 1500.5,
  // Phương thức
  showInfo: function () {
    console.log("ID: " + this.id);
    console.log("Name: " + this.name);
    console.log("Age: " + this.age);
    console.log("Salary: " + this.salary);
  },
};
person1.showInfo();
var person1 = {
  id: 2,
  name: "Sơn2",
  age: 40,
  salary: 2000,
};

console.log("Person 1, name: " + person1.name + ", age " + person1.age);

// Khai báo hàm trong Javascript
var number1 = 10;
var number2 = 20;
var sumRessult = number1 + number2;
console.log("Sum result: " + sumRessult);

function sum(a, b) {
  // Thực hiện phép cộng
  var result = a + b;
  return result;
}

var sumResult2 = sum(100, 260);
console.log("Sum result 2: " + sumResult2);

// Dữ liệu mảng trong Javascript
var numbers = [10, 20, 30, 40, 50];
console.log("Number 1: " + numbers[0]);
console.log("Number 2: " + numbers[1]);
console.log("Number 2: " + numbers[2]);

// Mảng chứa tên các bạn học viên trong lớp
var nameFeVTI = ["ĐạoNQ", "Tùng", "Thắng", "Nam", "Xuân"];
console.log("nameFeVTI_0: ", nameFeVTI[0]); // nameFeVTI_0:  ĐạoNQ
console.log("nameFeVTI_1: ", nameFeVTI[1]); // nameFeVTI_1:  Tùng
console.log("nameFeVTI_2: ", nameFeVTI[2]); // nameFeVTI_2:  Thắng
console.log("nameFeVTI_3: ", nameFeVTI[3]); // nameFeVTI_3:  Nam
console.log("nameFeVTI_4: ", nameFeVTI[4]); // nameFeVTI_4:  Xuân

nameFeVTI.push("Hoàng");
nameFeVTI.push("Sáng");
console.log("nameFeVTI_5: ", nameFeVTI[5]); // nameFeVTI_5:  Hoàng
console.log("nameFeVTI_6: ", nameFeVTI[6]);

// Lấy ra tổng số phần tử
console.log("Tổng số phần tử: ", nameFeVTI.length);

// Xóa phần tử cuối cùng
nameFeVTI.pop();
nameFeVTI.pop();
console.log("Tổng số phần tử: ", nameFeVTI.length);
console.log("nameFeVTI_6: ", nameFeVTI[6]);

// Xóa phần tử tại vị trí bất kỳ
nameFeVTI.splice(1, 1);
console.log("Tổng số phần tử sau khi xóa: ", nameFeVTI.length);
console.log("nameFeVTI_1: ", nameFeVTI[1]);

console.log("---------------------------------");
console.log("-----------------IF--------------");

var a = 100;
if (a > 50) {
  console.log("a lớn hơn 50");
}

var b = 30;
if (b == 30) {
  console.log("b bằng 30");
} else {
  console.log("b không bằng 30");
}

console.log("------switch case-------");

switch (b) {
  case 1:
    console.log("Đây là số 1");
    break;
  case 2:
    console.log("Đây là số 2");
    break;
  case 3:
    console.log("Đây là số 3");
    break;
  case 4:
    console.log("Đây là số 4");
    break;
  default:
    console.log("Đây 1 số nào đó");
    break;
}
// Sử dụng vòng lặp
console.log("------ for -------");

// In các số từ 0 đến
console.log("0");
console.log("1");
console.log("2");
console.log("3");
console.log("4");

for (let index = 0; index < 5; index++) {
  console.log(index);
}

var nameFeVTIAcademy = ["ĐạoNQ", "Tùng", "Thắng", "Nam", "Xuân"];
for (let index = 0; index < nameFeVTIAcademy.length; index++) {
  console.log(nameFeVTIAcademy[index]);
}

console.log("------ forEach -------");
nameFeVTIAcademy.forEach((name) => {
  console.log(name);
});

console.log("------ while -------");
// In các số từ 1 đến 5
// Tạo chỉ số lặp
var i = 1;
while (i <= 5) {
  console.log(i);
  i++; // tăng i lên nếu không sẽ bị lặp vô hạn
}

console.log("------ do while -------");
// In các số từ 1 đến 5
// Tạo chỉ số lặp
var k = 1;
// Test thêm với k =10, vẫn in ra 10
do {
  console.log(k);
  k++; // tăng i lên nếu không sẽ bị lặp vô hạn
} while (k <= 5);

console.log("------ break -------");
for (let index = 0; index < 5; index++) {
  if (index == 3) {
    break;
  }
  console.log(index);
}
// 0 1 2
console.log("------ continue -------");
for (let index = 0; index < 5; index++) {
  if (index == 3) {
    continue;
  }
  console.log(index);
}
// 0 1 2 4

console.log("------ scope -------");
// global scope - phạm vi toàn cục
// Local Scope - phạm vi cục bộ

var x = 100; // Biến toàn cục

console.log("x: " + x); //x: 100

function a_() {
  console.log("x in a funtion: " + x); //x: 100

  var y = 200; // Biến toàn cục
  console.log("y in a funtion" + y); //y: 200
}

function b_() {
  console.log("x in a funtion: " + x); //x: 100
}

a_();
b_();
console.log("--------------EVENT-----------");

// Hàm xử lý sự kiện click vào button
function handleClickMe() {
  // console.log("Bạn đã click vào button: ");
  alert("Bạn đã click vào button: ");
}
function handleOnMouseOver() {
  console.log("Bạn đã hover vào button!");
}

console.log("--------------DOM-----------");
// DOM
// document.getElementById
// document.getElementsByClassName
// document.getElementsByTagName
var h3Content = document.getElementById("h3Id").innerHTML;
console.log("h3Content: " + h3Content);

var h5Content = document.getElementById("h5Class").innerHTML;
console.log("h5Content: " + h5Content);
