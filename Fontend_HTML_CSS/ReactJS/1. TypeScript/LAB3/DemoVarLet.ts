// var let đều sử dụng để khai báo biến trong TypeScript,
// Khi sử dụng từ khóa var để khai báo biến, bạn có thể khai báo lại biến đó trong cùng một phạm vi mà không gây ra lỗi.
// Điều này có thể dẫn đến những vấn đề không mong muốn, đặc biệt khi bạn vô tình khai báo lại một biến đã tồn tại.
// Trong khi đó, từ khóa let không cho phép bạn khai báo lại một biến trong cùng một phạm vi, giúp tránh được những lỗi do việc khai báo lại

// var myName = "Sơn";
let myName = "Sơn";
console.log("1. " + myName); // Output: Sơn

// Redeclare variable ==> Khai báo lại biến
// let myName = "Trương Thanh Sơn";

// console.log("2. " + myName); // Output: Trương Thanh Sơn
