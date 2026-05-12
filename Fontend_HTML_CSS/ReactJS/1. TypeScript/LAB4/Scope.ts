//-------------Global scope (Phạm vi toàn cục)-------------
let myName = "Sơn";
let myAge = 20;

console.log(`Global scope: ${myName}, ${myAge}`);
//-------------Function Scope (Phạm vi hàm)-------------
function abc() {
  console.log(`Inside function abc: ${myName}, ${myAge}`);

  let myCity = "Hà Nội"; // Local scope (chỉ dùng được trong hàm abc)
  console.log(`Inside function abc: ${myCity}`);
}
abc();

//
// console.log(`Outside function abc: ${myCity}`); // Lỗi: myCity is not defined

//--------Lexical Scope (Phạm vi từ vựng)-------
function x() {
  //
  console.log("hello");
  var x = 10;
  console.log(x);
  //console.log(y)

  // Hàm trong hàm
  function x1() {
    //
    console.log("hello x1");
    console.log(x);

    var y = 20;
    function x2() {
      console.log("hello x2");
      console.log(x);
      console.log(y);
    }
  }
}
//-------------Block Scope (Phạm vi khối)-------------
if (true) {
  let message = "Xin chào Sơn!";
  console.log(message); // OK
}

// console.log(message); // Lỗi: message is not defined

for (let i = 0; i < 3; i++) {
  console.log("i trong vòng lặp:", i); // OK
}

// console.log(i); // Lỗi: i is not defined
