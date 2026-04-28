//  Viết 1 chương trình tính toán
// Phép cộng 2 số a và b
function sum(a: number, b: number): number {
  return a + b;
}
// Phép trừ 2 số a và b
function minus(a: number, b: number): number {
  return a - b;
}
// Phép nhân 2 số a và b
function multiply(a: number, b: number): number {
  return a * b;
}
// Phép chia 2 số a và b
function divide(a: number, b: number) {
  if (b === 0) {
    throw new Error("Không thể chia cho 0");
  }
  return a / b;
}
//Demo bình thường
console.log(`Kết quả của sum(5, 10) là: ${sum(5, 10)}`); // Kết quả của sum(5, 10) là: 15
console.log(`Kết quả của minus(5, 10) là: ${minus(5, 10)}`); // Kết quả của minus(5, 10) là: -5
console.log(`Kết quả của multiply(5, 10) là: ${multiply(5, 10)}`); // Kết quả của multiply(5, 10) là: 50
console.log(`Kết quả của divide(5, 10) là: ${divide(5, 10)}`); // Kết quả của divide(5, 10) là: 0.5
console.log(`------------------------------`);
function calculate(a: number, b: number, f) {
  let result = f(a, b);
  return result;
}
//Demo sử dụng hàm calculate
console.log(`Kết quả của calculate(5, 10, sum) là: ${calculate(5, 10, sum)}`); // Kết quả của calculate(5, 10, sum) là: 15
console.log(
  `Kết quả của calculate(5, 10, minus) là: ${calculate(5, 10, minus)}`,
); // Kết quả của calculate(5, 10, minus) là: -5
console.log(
  `Kết quả của calculate(5, 10, multiply) là: ${calculate(5, 10, multiply)}`,
); // Kết quả của calculate(5, 10, multiply) là: 50
console.log(
  `Kết quả của calculate(5, 10, divide) là: ${calculate(5, 10, divide)}`,
); // Kết quả của calculate(5, 10, divide) là: 0.5
