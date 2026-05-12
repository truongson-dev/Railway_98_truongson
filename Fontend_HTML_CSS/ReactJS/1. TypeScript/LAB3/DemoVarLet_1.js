"use strict";
console.log("My age is " + myAge);
var myAge = 25;
// Output: My age is undefined
// Explanation: In JavaScript, variable declarations using 'var' are hoisted to the top of their scope. However, the assignment of the value (25 in this case) is not hoisted. Therefore, when the console.log statement is executed, 'myAge' is declared but not yet assigned a value, resulting in 'undefined'.
