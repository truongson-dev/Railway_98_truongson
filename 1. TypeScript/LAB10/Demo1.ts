let str = "          Hello world!       ";

console.log("========== String Methods Demo ==========\n");

// 1. trim() - Xoá khoảng trắng đầu/cuối
console.log("1. trim() - Xoá khoảng trắng đầu/cuối");
console.log(`Original: "${str}"`);
console.log(`After trim: "${str.trim()}"`);
console.log();

// 2. toLowerCase() / toUpperCase() - Chuyển chữ thường/hoa
console.log("2. toLowerCase() / toUpperCase()");
let str2 = "Hello World";
console.log(`Original: "${str2}"`);
console.log(`toLowerCase: "${str2.toLowerCase()}"`);
console.log(`toUpperCase: "${str2.toUpperCase()}"`);
console.log();

// 3. includes(sub) - Kiểm tra chuỗi con
console.log("3. includes(sub) - Kiểm tra chuỗi con");
let str3 = "Hello World";
console.log(`String: "${str3}"`);
console.log(`includes("World"): ${str3.includes("World")}`); // true
console.log(`includes("world"): ${str3.includes("world")}`); // false (case-sensitive)
console.log(`includes("Hello"): ${str3.includes("Hello")}`); // true
console.log();

// 4. startsWith() / endsWith() - Bắt đầu/kết thúc bằng chuỗi con
console.log("4. startsWith() / endsWith()");
let str4 = "Hello World";
console.log(`String: "${str4}"`);
console.log(`startsWith("Hello"): ${str4.startsWith("Hello")}`); // true
console.log(`startsWith("World"): ${str4.startsWith("World")}`); // false
console.log(`endsWith("World"): ${str4.endsWith("World")}`); // true
console.log(`endsWith("Hello"): ${str4.endsWith("Hello")}`); // false
console.log();

// 5. replace(old, new) - Thay thế chuỗi
console.log("5. replace(old, new) - Thay thế chuỗi");
let str5 = "Hello World, Hello Everyone";
console.log(`Original: "${str5}"`);
console.log(`replace("Hello", "Hi"): "${str5.replace("Hello", "Hi")}"`);
console.log(`replaceAll("Hello", "Hi"): "${str5.replaceAll("Hello", "Hi")}"`);
console.log();

// BONUS: Ví dụ kết hợp nhiều phương thức
console.log("========== BONUS: Kết hợp các phương thức ==========");
let email = "  JOHN.DOE@EXAMPLE.COM  ";
console.log(`Original email: "${email}"`);
console.log(`After processing: "${email.trim().toLowerCase()}"`);
console.log();
