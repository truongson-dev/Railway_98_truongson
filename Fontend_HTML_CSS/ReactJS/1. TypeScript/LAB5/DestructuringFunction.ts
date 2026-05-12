//-------Destructuring ==> Phá vỡ cấu trúc-------
let person = {
  name: "Sơn",
  age: 20,
  city: "Đà Nẵng",
};

// Lấy ra các thông tin name, age, address từ đối tượng person sau đó lưu vào các biến riêng biệt
// let v_name = person.name;
// let v_age = person.age;
// let v_city = person.city;

// -------------------Destructuring Object------------------
let { name: v_name, age: v_age, city: v_city } = person;

console.log(v_name); // Sơn
console.log(v_age); // 20
console.log(v_city); // Đà Nẵng
//-------Spread...-------
var worker = {
  ...person,
  job: "Developer",
  rank: 1,
};

console.log(
  `Worker: ${worker.name}, ${worker.age}, ${worker.city}, ${worker.job}, ${worker.rank}`,
);
