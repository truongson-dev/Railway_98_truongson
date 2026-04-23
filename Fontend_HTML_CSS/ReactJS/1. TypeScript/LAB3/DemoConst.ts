// let PI = "3.14"; // Error: Cannot assign to 'PI' because it is a constant.
// const
const PI = "3.14";
//
// PI = "3.15"
console.log("PI: " + PI);

console.log("------Const  với  đối tượng------");
// Sử dụng const với đối tượng
const person = {
  name: "Sơn",
  age: 25,
  address: "Đà Nẵng",
};
console.log(`Person: ${person.name} - ${person.age} - ${person.address}`);

// Mặc dù person được khai báo là const, nhưng bạn vẫn có thể thay đổi các thuộc tính của đối tượng đó
person.name = "Hùng";
person.age = 30;
console.log(`Person: ${person.name} - ${person.age} - ${person.address}`);

console.log("--------Const  với  mảng--------");
// Sử dụng const với mảng
const numArray: number[] = [1, 2, 3, 4, 5];
// Chỉ có thể thay đổi phần tử của mảng, không thể gán lại toàn bộ mảng

numArray[0] = 10; // Thay đổi giá trị của phần tử đầu tiên
numArray[1] = 11; // Thay đổi giá trị của phần tử thứ hai
console.log("numArray: " + numArray);
