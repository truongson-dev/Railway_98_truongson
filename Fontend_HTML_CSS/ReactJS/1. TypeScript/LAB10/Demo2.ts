console.log("========== ARRAY METHODS DEMO ==========\n");

// ==================== 1. push() / pop() ====================
console.log("1. push() / pop() - Thêm / xóa cuối mảng");
let arr1 = [1, 2, 3];
console.log(`Original: [${arr1}]`);
arr1.push(4, 5);
console.log(`After push(4, 5): [${arr1}]`);
let removed = arr1.pop();
console.log(`After pop(), removed: ${removed}, remaining: [${arr1}]`);
console.log();

// ==================== 2. shift() / unshift() ====================
console.log("2. shift() / unshift() - Xóa / thêm đầu mảng");
let arr2 = [1, 2, 3];
console.log(`Original: [${arr2}]`);
arr2.unshift(0);
console.log(`After unshift(0): [${arr2}]`);
let firstRemoved = arr2.shift();
console.log(`After shift(), removed: ${firstRemoved}, remaining: [${arr2}]`);
console.log();

// ==================== 3. map() ====================
console.log("3. map() - Biến đổi từng phần tử");

// VD1: Nhân mỗi phần tử với 2
console.log("VD1: Nhân mỗi phần tử với 2");
let numberArray = [1, 6, 5, 3, 9];
let numberArray_New_Map = numberArray.map((number) => {
  return number + 5;
});
console.log(`Original: [${numberArray}]`);
console.log(`After map(x => x + 5): [${numberArray_New_Map}]`);

// VD2: Sử dụng cả value và index
console.log("\nVD2: Sử dụng cả value và index");
const names = ["Nam", "Lan", "Tùng"];
const greetings = names.map((name, index) => `Hello ${index + 1}: ${name}`);
console.log(`Original: [${names}]`);
console.log(`Greetings:`);
greetings.forEach((g) => console.log(`  ${g}`));

// VD3: Chuyển sang chữ in hoa
console.log("\nVD3: Chuyển sang chữ in hoa");
const lowerNames = ["an", "bình", "châu"];
const upperNames = lowerNames.map((name) => name.toUpperCase());
console.log(`Original: [${lowerNames}]`);
console.log(`After toUpperCase: [${upperNames}]`);
console.log();

// ==================== 4. filter() ====================
console.log("4. filter() - Lọc các phần tử theo điều kiện");
const numbers = [1, 2, 3, 4, 5, 6];
console.log(`Original: [${numbers}]`);

// Lọc ra các số chẵn
const evenNumbers = numbers.filter((number) => {
  return number % 2 === 0;
});
console.log(`Filter even numbers: [${evenNumbers}]`);

// Lọc ra các số > 3
const greaterThan3 = numbers.filter((n) => n > 3);
console.log(`Filter numbers > 3: [${greaterThan3}]`);
console.log();

// ==================== 5. reduce() ====================
console.log("5. reduce() - Tích lũy giá trị");

// VD1: Tính tổng các số
console.log("VD1: Tính tổng các số");
const nums1 = [1, 2, 3, 4, 5];
const total = nums1.reduce((acc, curr) => acc + curr, 0);
console.log(`Array: [${nums1}]`);
console.log(`Sum: ${total}`);

// VD2: Tìm phần tử lớn nhất
console.log("\nVD2: Tìm phần tử lớn nhất");
const nums2 = [10, 4, 8, 2];
const max = nums2.reduce((acc, curr) => (curr > acc ? curr : acc), nums2[0]);
console.log(`Array: [${nums2}]`);
console.log(`Max: ${max}`);

// VD3: Tính tổng giá trị đơn hàng
console.log("\nVD3: Tính tổng giá trị đơn hàng");
const cart = [
  { item: "Book", price: 12 },
  { item: "Pen", price: 5 },
  { item: "Notebook", price: 20 },
];
const totalPrice = cart.reduce((acc, product) => acc + product.price, 0);
console.log("Cart items:");
cart.forEach((item) => console.log(`  ${item.item}: $${item.price}`));
console.log(`Total Price: $${totalPrice}`);
console.log();

// ==================== 6. find() ====================
console.log("6. find() - Tìm phần tử đầu tiên thỏa điều kiện");

// VD1: Tìm phần tử trong mảng số
console.log("VD1: Tìm phần tử > 10");
const nums3 = [5, 8, 12, 4, 7];
const found = nums3.find((num) => num > 10);
console.log(`Array: [${nums3}]`);
console.log(`Found (num > 10): ${found}`);

// VD2: Tìm object trong mảng
console.log("\nVD2: Tìm object trong mảng");
const users = [
  { id: 1, name: "Nam" },
  { id: 2, name: "Lan" },
  { id: 3, name: "Tùng" },
];
const user = users.find((u) => u.id === 2);
console.log(`Found user with id 2:`, user);

// VD3: So sánh với filter()
console.log("\nVD3: So sánh find() vs filter()");
const nums4 = [5, 8, 12, 4, 7];
const resultFind = nums4.find((n) => n > 5);
const resultFilter = nums4.filter((n) => n > 5);
console.log(`Array: [${nums4}]`);
console.log(`find(n > 5): ${resultFind} (phần tử đầu tiên)`);
console.log(`filter(n > 5): [${resultFilter}] (tất cả phần tử)`);
console.log();

// ==================== 7. findIndex() ====================
console.log("7. findIndex() - Tìm index của phần tử");

// VD1: Tìm index trong mảng số
console.log("VD1: Tìm index trong mảng số");
const nums5 = [3, 10, 18, 20];
const index = nums5.findIndex((num) => num > 15);
console.log(`Array: [${nums5}]`);
console.log(`findIndex(num > 15): ${index} (phần tử 18 ở index 2)`);

// VD2: Tìm index trong mảng object
console.log("\nVD2: Tìm index trong mảng object");
const users2 = [
  { id: 1, name: "Nam" },
  { id: 2, name: "Lan" },
  { id: 3, name: "Tùng" },
];
const userIndex = users2.findIndex((user) => user.name === "Lan");
console.log(`findIndex(name === 'Lan'): ${userIndex} (Lan ở index 1)`);
console.log();

// ==================== 8. includes() ====================
console.log("8. includes() - Kiểm tra có tồn tại phần tử");

// VD1: Tìm phần tử trong mảng
console.log("VD1: Tìm phần tử trong mảng");
const fruits = ["apple", "banana", "mango"];
console.log(`Array: [${fruits}]`);
console.log(`includes('banana'): ${fruits.includes("banana")}`);
console.log(`includes('grape'): ${fruits.includes("grape")}`);

// VD2: Sử dụng với chuỗi
console.log("\nVD2: Sử dụng với chuỗi");
const message = "Hello Đạo, chúc bạn một ngày tốt lành!";
console.log(`Message: "${message}"`);
console.log(`includes('Đạo'): ${message.includes("Đạo")}`);
console.log(`includes('ngày tốt'): ${message.includes("ngày tốt")}`);

// VD3: Sử dụng fromIndex
console.log("\nVD3: Sử dụng fromIndex");
const nums6 = [1, 2, 3, 4, 2];
console.log(`Array: [${nums6}]`);
console.log(`includes(2): ${nums6.includes(2)}`);
console.log(`includes(2, 3): ${nums6.includes(2, 3)} (tìm từ index 3)`);
console.log(`includes(2, 5): ${nums6.includes(2, 5)} (tìm từ index 5)`);
console.log();

// ==================== 9. sort() / reverse() ====================
console.log("9. sort() / reverse() - Sắp xếp / đảo ngược");

// sort()
console.log("sort() - Sắp xếp");
let arr3 = [3, 1, 4, 1, 5, 9];
console.log(`Original: [${arr3}]`);
arr3.sort();
console.log(`After sort(): [${arr3}]`);

// sort() số
console.log("\nsort() với số (cần comparator)");
let arr4 = [3, 1, 4, 1, 5, 9];
arr4.sort((a, b) => a - b);
console.log(`sort((a, b) => a - b): [${arr4}]`);
arr4.sort((a, b) => b - a);
console.log(`sort((a, b) => b - a) - giảm dần: [${arr4}]`);

// reverse()
console.log("\nreverse() - Đảo ngược");
let arr5 = [1, 2, 3, 4, 5];
console.log(`Original: [${arr5}]`);
arr5.reverse();
console.log(`After reverse(): [${arr5}]`);
console.log();

// ==================== 10. flat() ====================
console.log("10. flat() - Làm phẳng mảng lồng nhau");

// VD1: Mảng 2 chiều
console.log("VD1: Mảng 2 chiều");
const arr6 = [1, 2, [3, 4], [5, 6]];
console.log(`Original: [${JSON.stringify(arr6)}]`);
const flattened1 = arr6.flat();
console.log(`After flat(): [${JSON.stringify(flattened1)}]`);

// VD2: Mảng 3 chiều
console.log("\nVD2: Mảng 3 chiều");
const arr7 = [1, [2, [3, 4]], [5, 6]];
console.log(`Original: [${JSON.stringify(arr7)}]`);
const flattened2 = arr7.flat(2);
console.log(`After flat(2): [${JSON.stringify(flattened2)}]`);

// VD3: Làm phẳng hoàn toàn
console.log("\nVD3: Làm phẳng hoàn toàn");
const arr8 = [1, [2, [3, [4, 5]]]];
console.log(`Original: [${JSON.stringify(arr8)}]`);
const fullyFlattened = arr8.flat(Infinity);
console.log(`After flat(Infinity): [${JSON.stringify(fullyFlattened)}]`);
console.log();

// ==================== 11. Kết hợp nhiều phương thức ====================
console.log("11. Kết hợp nhiều phương thức");

const products = [
  { name: "Laptop", price: 1000, category: "Electronics" },
  { name: "Book", price: 20, category: "Books" },
  { name: "Mouse", price: 30, category: "Electronics" },
  { name: "Notebook", price: 5, category: "Books" },
  { name: "Monitor", price: 300, category: "Electronics" },
];

// Lọc ra sản phẩm Electronics, lấy tên và giảm 10%
const discountedElectronics = products
  .filter((p) => p.category === "Electronics")
  .map((p) => ({
    name: p.name,
    originalPrice: p.price,
    discountedPrice: p.price * 0.9,
  }));

console.log("Giảm giá 10% cho Electronics:");
discountedElectronics.forEach((item) => {
  console.log(
    `  ${item.name}: $${item.originalPrice} → $${item.discountedPrice.toFixed(2)}`,
  );
});

// Tính tổng giá sau giảm
const totalDiscount = discountedElectronics.reduce(
  (sum, item) => sum + item.discountedPrice,
  0,
);
console.log(`Total after discount: $${totalDiscount.toFixed(2)}`);
console.log();

console.log("========== END DEMO ==========");
