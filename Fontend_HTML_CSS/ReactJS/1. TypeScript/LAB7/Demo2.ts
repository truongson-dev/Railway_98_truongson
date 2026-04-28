// Xây dựng 1 hàm có 1 tham số đầu vào, sau khi xử lý xong tăng giá trị của tham số đầu vào lên 5 đơn vị rồi trả về kết quả
// function plus5(y: number): number {
//   return y + 5;
// }
// 10 ==> 15, 20 ==> 25, 30 ==> 35
// console.log(`Kết quả của plus5(10) là: ${plus5(10)}`); // Kết quả của plus5(10) là: 15
// console.log(`Kết quả của plus5(20) là: ${plus5(20)}`); // Kết quả của plus5(20) là: 25
// console.log(`Kết quả của plus5(30) là: ${plus5(30)}`); // Kết quả của plus5(30) là: 35

// function plus10(y: number): number {
//   return y + 10;
// }
// 10 ==> 20, 20 ==> 30, 30 ==> 40
// console.log(`Kết quả của plus10(10) là: ${plus10(10)}`); // Kết quả của plus10(10) là: 20
// ----------------------------------------------------------
// HOF
// x là tham số đầu vào, sử dụng để tăng giá trị
// x = 10
// y = 20
function plus(x: number) {
  //
  return function (y: number): number {
    return y + x;
  };
}
// Demo
// Viết hàm tăng 5 đơn vị
let plus_5 = plus(5);
console.log(`Tăng 5 đơn vị: ${plus_5(10)}`); // Tăng 5 đơn vị: 15
console.log(`Tăng 5 đơn vị: ${plus_5(20)}`);
console.log(`Tăng 5 đơn vị: ${plus_5(30)}`);
console.log(`------------------------------`);
// Viết hàm tăng 10 đơn vị
let plus_10 = plus(10);
console.log(`Tăng 10 đơn vị: ${plus_10(10)}`);
console.log(`Tăng 10 đơn vị: ${plus_10(20)}`);
console.log(`Tăng 10 đơn vị: ${plus_10(30)}`);
