
// Khai báo list chứa Account
var listAccount = [];

// Khởi tạo dữ liệu khi trang web được load
$(document).ready(function () {
    initData();
});

function initData() {
    // Lấy dữ liệu từ LocalStorage
    var jsonListAccount = localStorage.getItem("listAccount");
    if (jsonListAccount) {
        listAccount = JSON.parse(jsonListAccount);
    } else {
        listAccount = [];
    }
    showListAccount();
}

// Lưu trữ dữ liệu vào LocalStorage
function saveToLocalStorage() {
    localStorage.setItem("listAccount", JSON.stringify(listAccount));
}

// Hàm hiển thị thông tin kết quả
function showListAccount() {
    $("#Result_TB").empty();
    for (let index = 0; index < listAccount.length; index++) {
        $("#Result_TB").append(`
              <tr>
                  <td>${listAccount[index].Id}</td>
                  <td>${listAccount[index].Email}</td>
                  <td>${listAccount[index].Username}</td>
                  <td>${listAccount[index].Fullname}</td>
                  <td>${listAccount[index].Department}</td>
                  <td>${listAccount[index].Position}</td>
                  <td>${listAccount[index].Cretate_Date}</td>
                  <td>
                    <button type="button" class="btn btn-warning" onclick="handleEdit(${index})">Edit</button>
                  </td>
                  <td>
                    <button type="button" class="btn btn-danger" onclick="handleDelete(${index})">Delete</button>
                  </td>
              </tr>
  `);
    }
}

// Xử lý sự kiện khi người dùng nhấn nút Reset
$("#reset_btn").click(function () {
    resetForm();
});

function resetForm() {
    // Bỏ disable cho các nút nhập liệu
    $("#ID_ID").removeAttr("disabled");
    $("#Email_ID").removeAttr("disabled");
    $("#Username_ID").removeAttr("disabled");

    // Reset các ô nhập liệu
    $("#ID_ID").val("");
    $("#Email_ID").val("");
    $("#Username_ID").val("");
    $("#Fullname_ID").val("");
    $("#Department_ID").val("");
    $("#Position_ID").val("");
    $("#Cretate_Date_ID").val("");
}

// Xử lý sự kiện khi nhấn nút Save
$("#save_btn").click(function () {
    // 1. Lấy dữ liệu người dùng nhập liệu
    var v_ID_ID = $("#ID_ID").val();
    var v_Email_ID = $("#Email_ID").val();
    var v_Username_ID = $("#Username_ID").val();
    var v_Fullname_ID = $("#Fullname_ID").val();
    var v_Department_ID = $("#Department_ID").val();
    var v_Position_ID = $("#Position_ID").val();
    var v_Cretate_Date_ID = $("#Cretate_Date_ID").val();

    // Kiểm tra dữ liệu (Validation)
    if (!v_ID_ID || !v_Email_ID || !v_Username_ID) {
        alert("Vui lòng nhập đầy đủ thông tin ID, Email và Username!");
        return;
    }

    // 2. Đưa các dữ liệu này tạo thành Object
    var account = {
        Id: v_ID_ID,
        Email: v_Email_ID,
        Username: v_Username_ID,
        Fullname: v_Fullname_ID,
        Department: v_Department_ID,
        Position: v_Position_ID,
        Cretate_Date: v_Cretate_Date_ID,
    };

    // 3. Lưu trữ dữ liệu
    listAccount.push(account);
    saveToLocalStorage();

    // 4. Hiển thị dữ liệu ở bảng kết quả
    showListAccount();
    resetForm();
    alert("Thêm mới thành công!");
});

// Xử lý Delete Account
function handleDelete(indexParam) {
    var resultConfirmDelete = confirm("Bạn có chắc chắn muốn xóa Account này?");
    if (resultConfirmDelete) {
        listAccount.splice(indexParam, 1);
        saveToLocalStorage();
        showListAccount();
    }
}

// Xử lý edit Account
function handleEdit(indexParam) {
    // Disable các ô nhập liệu không cho phép người dùng cập nhật dữ liệu
    $("#ID_ID").attr("disabled", "disabled");
    $("#Email_ID").attr("disabled", "disabled");
    $("#Username_ID").attr("disabled", "disabled");

    // Lấy ra Account cần edit
    var account_edit = listAccount[indexParam];

    $("#ID_ID").val(account_edit.Id);
    $("#Email_ID").val(account_edit.Email);
    $("#Username_ID").val(account_edit.Username);
    $("#Fullname_ID").val(account_edit.Fullname);
    $("#Department_ID").val(account_edit.Department);
    $("#Position_ID").val(account_edit.Position);
    $("#Cretate_Date_ID").val(account_edit.Cretate_Date);
}

// Xử lý cho nút Update
$("#update_btn").click(function (e) {
    // Lấy lại dữ liệu người dùng vừa chỉnh sửa
    var v_ID_ID = $("#ID_ID").val();
    var v_Email_ID_Update = $("#Email_ID").val();
    var v_Username_ID_Update = $("#Username_ID").val();
    var v_Fullname_ID_Update = $("#Fullname_ID").val();
    var v_Department_ID_Update = $("#Department_ID").val();
    var v_Position_ID_Update = $("#Position_ID").val();
    var v_Cretate_Date_ID_Update = $("#Cretate_Date_ID").val();

    // Tìm vị trí của Account cần Update
    var indexAccountUpdate;
    for (let index = 0; index < listAccount.length; index++) {
        if (listAccount[index].Id == v_ID_ID) {
            indexAccountUpdate = index;
        }
    }

    // Cập nhật lại dữ liệu
    listAccount[indexAccountUpdate].Email = v_Email_ID_Update;
    listAccount[indexAccountUpdate].Username = v_Username_ID_Update;
    listAccount[indexAccountUpdate].Fullname = v_Fullname_ID_Update;
    listAccount[indexAccountUpdate].Department = v_Department_ID_Update;
    listAccount[indexAccountUpdate].Position = v_Position_ID_Update;
    listAccount[indexAccountUpdate].Cretate_Date = v_Cretate_Date_ID_Update;

    // Lưu trữ và hiển thị lại dữ liệu
    saveToLocalStorage();
    showListAccount();
    resetForm();
    alert("Cập nhật thành công!");
});
