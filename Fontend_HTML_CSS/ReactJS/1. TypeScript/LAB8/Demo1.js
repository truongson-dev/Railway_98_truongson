"use strict";
// Demo Promise trong TypeScript
// Mô phỏng chương trình tạo mới Account
// Check Email đã tồn tại hay chưa, nếu tồn tại thì trả về lỗi
// Check Username đã tồn tại hay chưa, nếu tồn tại thì trả về lỗi
// Tạo Account
// Viết hàm checkEmail
function callAPICheckEmail() {
    console.log("Call API check email...");
    let promise_CheckEmail = new Promise(function (resolve, reject) {
        //   url: 'http://localhost:8080/api/v1/accounts/checkEmailExits',
        // 			type: 'GET',
        // 			data: JSON.stringify(account), // body
        // 			contentType: "application/json", // type of body (json, xml, text)
        // 			// dataType: 'json', // datatype return
        // 			beforeSend: function(xhr) {
        // 				xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
        // 			},
        let checkEmail = false;
        if (checkEmail) {
            reject("Email đã tồn tại, vui lòng chọn email khác!");
        }
        else {
            resolve("Email hợp lệ, có thể sử dụng để tạo mới Account!");
        }
    });
    return promise_CheckEmail;
}
function callAPICheckUsername() {
    console.log("Call API check Username...");
    //   url: 'http://localhost:8080/api/v1/accounts/checkEmailExits',
    // 			type: 'GET',
    // 			data: JSON.stringify(account), // body
    // 			contentType: "application/json", // type of body (json, xml, text)
    // 			// dataType: 'json', // datatype return
    // 			beforeSend: function(xhr) {
    // 				xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
    // 			},
    let promise_CheckUsername = new Promise(function (resolve, reject) {
        //   url: 'http://localhost:8080/api/v1/accounts/checkEmailExits',
        // 			type: 'GET',
        // 			data: JSON.stringify(account), // body
        // 			contentType: "application/json", // type of body (json, xml, text)
        // 			// dataType: 'json', // datatype return
        // 			beforeSend: function(xhr) {
        // 				xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
        // 			},
        let checkUsername = false;
        if (checkUsername) {
            reject("Uesrname đã tồn tại, vui lòng chọn Uesrname khác!");
        }
        else {
            resolve("Uesrname hợp lệ, có thể sử dụng để tạo mới Account!");
        }
    });
    return promise_CheckUsername;
}
function callAPICreateNewAccount() {
    console.log("Call API createNewAccount...");
    let promise_createAccount = new Promise(function (resolve, reject) {
        //   url: 'http://localhost:8080/api/v1/accounts',
        // 			type: 'GET',
        // 			data: JSON.stringify(account), // body
        // 			contentType: "application/json", // type of body (json, xml, text)
        // 			// dataType: 'json', // datatype return
        // 			beforeSend: function(xhr) {
        // 				xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD")));
        // 			},
        let createNewAccount = false;
        if (createNewAccount) {
            reject("tạo mới Account thất bại, vui lòng thử lại!");
        }
        else {
            resolve("Tạo mới Account thành công");
        }
    });
    return promise_createAccount;
}
// Kết quả không chính xác
// callAPICheckEmail();
// callAPICheckUsername();
// callAPICreateNewAccount();
callAPICheckEmail()
    .then(function (msg) {
    return callAPICheckUsername();
})
    .then(function (msg) {
    return callAPICreateNewAccount();
})
    .then(function (msg) {
    console.log(msg);
})
    .catch(function (err) {
    console.log(err);
});
