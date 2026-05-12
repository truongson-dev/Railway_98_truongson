"use strict";
//---------Cách 1: Khai báo hàm với từ khóa function-------
// function sum(a: number, b: number): number {
//   return a + b;
// }
//---------Cách 2: Sử dụng 1 biến tham chiếu tới 1 hàm-------
// (let v_sum) = function (a: number, b: number) {
//   return a + b;
// };
//---------Cách 3: Sử dụng arrow function (hàm mũi tên)-------
let v_sum_arrow = (a, b) => {
    return a + b;
};
// Nếu chỉ có 1 biểu thức duy nhất trong thân hàm, ta có thể viết gọn hơn như sau:
// let v_sum_arrow = (a: number, b: number) => return a + b;
//---------Sử dụng hàm sum---------------
// let vresult = v_sum(5, 10);
// let v_result = v_sum(5, 10);
let v_result = v_sum_arrow(5, 10);
console.log(`Kết quả của sum(5, 10) là: ${v_result}`); // Kết quả của sum(5, 10) là: 15
