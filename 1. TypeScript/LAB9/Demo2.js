"use strict";
// Rest parameters: cho phép chúng ta truyền một số lượng tham số không xác định vào một hàm dưới dạng một mảng
function hello(...studentNames) {
    // studentNames là một mảng chứa tất cả các tham số được truyền vào
    console.log("Hello, " + studentNames);
}
hello("Alice", "Bob", "Charlie");
hello("David", "Eve");
hello("Frank");
