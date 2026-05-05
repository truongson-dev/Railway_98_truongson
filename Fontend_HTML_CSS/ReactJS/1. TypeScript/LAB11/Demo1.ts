import { numbers } from "./../LAB2/Person";
let numbers = [1, 2, 3, 4, 5];
// map(): Sử dụng để tạo ra một mảnh mới bằng cách áp dụng một hàm cho mỗi phần tử của mảng gốc.

// Sử dụng forEach() để tạo một mảng mới
let number_news: number[] = [];
numbers.forEach((numbers) => {
  let number_new = numbers + 3;
  number_news.push(number_new);
});
console.log("number_news: ", number_news);

// Sử dụng map() để làm điều tương tự
let number_news_map = numbers.map((numbers) => {
  let number_new = numbers + 3;
  return number_new;
});
console.log("number_news_map: ", number_news_map);
