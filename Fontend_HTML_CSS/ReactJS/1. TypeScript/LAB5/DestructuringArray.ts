let name_Array: string[] = ["Sơn", "Thủy", "Lâm"];

// --------------------Destructuring Array------------------
let v_name1 = name_Array[0];
let v_name2 = name_Array[1];
let v_name3 = name_Array[2];

// Cách viết ngắn gọn hơn
let [v_name4, v_name5, v_name6] = name_Array;
console.log(`0: ${v_name1}`); // Sơn
console.log(`1: ${v_name2}`); // Thủy
console.log(`2: ${v_name3}`); // Lâm
