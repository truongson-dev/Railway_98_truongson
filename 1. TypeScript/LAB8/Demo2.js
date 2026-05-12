"use strict";
// Hàm Call API check Email có tồn tại trên hệ thống chưa?
async function callAPICheckEmail() {
    console.log("------ Step1: call API Check Email! ------");
    //   Đoạn code call Api để check Email
    var data = false;
    return data;
}
// Hàm Call API check Username có tồn tại trên hệ thống chưa?
async function callAPICheckUsername() {
    console.log("------ Step2: call API Check Username!------");
    //   Đoạn code call Api để check Username
    var data = false;
    return data;
}
// Hàm Call API tạo mới Account.
async function callAPICreateAccount() {
    console.log("------ Step3: call API Create Account!------");
    //   Đoạn code call Api để tạo mới Account
    var status = "Success";
    //   "error"; "Success"
    if (status == "error") {
        return false;
    }
    else {
        return true;
    }
}
// Viết hàm tổng hợp để tạo mới Account.
// Step1: Check Email tồn tại
// Step2: Check Username tồn tại
// Step3: Tạo mới 1 Account
// Bất cứ bước nào gặp lỗi sẽ dừng chương trình.
async function create_New_Account() {
    // call API check Email.
    let resultCheckEmail = await callAPICheckEmail();
    if (resultCheckEmail) {
        console.log("This Email is Exists!");
        return;
    }
    else {
        console.log("This Email is not Exists, Check Email OK!");
    }
    // call API check Username.
    let resultCheckUsername = await callAPICheckUsername();
    if (resultCheckUsername) {
        console.log("This Username is Exists!");
    }
    else {
        console.log("This Username is not Exists, Check Username OK!");
    }
    // call API tạo mới Account.
    let resultCreateAccount = await callAPICreateAccount();
    if (resultCreateAccount) {
        console.log("Create Account success!");
        return;
    }
    else {
        console.log("An error has occurred!!");
    }
}
// Gọi hàm tạo mới các đối tượng.
create_New_Account();
