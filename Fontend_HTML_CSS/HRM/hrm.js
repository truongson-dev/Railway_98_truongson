console.log("HRM");
// Khai báo mảng global để lưu trữ danh sách tài khoản
var listAccount = [];

// Tự động load dữ liệu khi trang web sẵn sàng
getListAccount();
getListDepartment();
getListPosition();

// Load dữ liệu API Account
function getListAccount() {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/v1/accounts",
    // data: "data",
    dataType: "json",
    success: function (response) {
      //
      console.log("Response API: ", response);
      // Gán dữ liệu vào listAccount
      listAccount = response;
      // Hiển thị dữ liệu ở bảng kết quả
      showListAccount();
    },
  });
}
//
function getListDepartment() {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/v1/departments",
    // data: "data",
    dataType: "json",
    success: function (response) {
      //
      console.log("Response API Department: ", response);
      // Gán dữ liệu vào listDepartment
      listDepartment = response;
      // Hiển thị dữ liệu ở bảng kết quả
      for (let index = 0; index < listDepartment.length; index++) {
        $("#Department_ID").append(
          `<option value="${listDepartment[index].id}">${listDepartment[index].name}</option>`,
        );
      }
    },
  });
}
//
function getListPosition(params) {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/v1/possitions",
    // data: "data",
    dataType: "json",
    success: function (response) {
      console.log("Response Position: ", response);
      listPosition = response;
      // id: 1
      // name: "Dev"
      for (let index = 0; index < listPosition.length; index++) {
        $("#Position_ID").append(
          `<option value="${listPosition[index].id}">${listPosition[index].name}</option>`,
        );
      }
    },
  });
}

// Xử lý sự kiện click cho nút Reset
$("#reset_btn").click(function (e) {
  //   console.log("Reset button clicked");
  $("#ID_ID").val("");
  $("#Email_ID").val("");
  $("#Username_ID").val("");
  $("#Fullname_ID").val("");
  $("#Department_ID").val(0);
  $("#Position_ID").val(0);
  $("#Cretate_Date_ID").val("");
});

// Xử lý sự kiện click cho nút save
//   1. Xử lý bắt sự kiện khi người dùng nhấn nút Save
$("#save_btn").click(function (e) {
  // 2. Lấy dữ liệu người dùng nhập
  var v_ID_ID = $("#ID_ID").val();
  var v_Email_ID = $("#Email_ID").val();
  var v_Username_ID = $("#Username_ID").val();
  var v_Fullname_ID = $("#Fullname_ID").val();
  var v_Department_ID = $("#Department_ID").val();
  var v_Position_ID = $("#Position_ID").val();
  var v_Cretate_Date_ID = $("#Cretate_Date_ID").val();

  // console.log("ID_ID: " + v_ID_ID);
  // console.log("Email_ID: " + v_Email_ID);
  // console.log("Username_ID: " + v_Username_ID);
  // console.log("Fullname_ID: " + v_Fullname_ID);
  // console.log("Department_ID: " + v_Department_ID);
  // console.log("Position_ID: " + v_Position_ID);
  // console.log("Cretate_Date_ID: " + v_Cretate_Date_ID);

  // 3. Lưu trữ dữ liệu(FE)
  // Tạo đối tượng account
  var account_new = {
    email: v_Email_ID,
    username: v_Username_ID,
    fullname: v_Fullname_ID,
    departmentId: v_Department_ID, //Bán hàng  ==> 11
    positionId: v_Position_ID, //Scrum_Master  ==> 4
  };

  // Call API để tạo mới Account
  $.ajax({
    type: "POST",
    url: "http://localhost:8080/api/v1/accounts",
    data: JSON.stringify(account_new),
    contentType: "application/json; charset=UTF-8",
    success: function (response) {
      // response = "Create successfully!"
      getListAccount(); // Hiển thị lại danh Account
    },
  });

  // console.log(account);

  // Lưu trữ account vào mảng listAccount
  listAccount.push(account);
  //

  // 4. Hiển thị dữ liệu ở bảng kết quả
  showListAccount();
});

// Hàm hiển thị dữ liệu ở bảng kết quả
function showListAccount() {
  $("#Result_TB").empty();
  // listAccount là mảng chứa danh sách tài khoản
  for (let index = 0; index < listAccount.length; index++) {
    $("#Result_TB").append(`<tr>
      <td>${listAccount[index].id}</td>
      <td>${listAccount[index].email}</td>
      <td>${listAccount[index].username}</td>
      <td>${listAccount[index].fullname}</td>
      <td>${listAccount[index].department}</td>
      <td>${listAccount[index].position}</td>
      <td>${listAccount[index].createDate}</td>
      <td>
        <button type="button" class="btn btn-warning" onclick="handleEdit(${index})">Edit</button>
      </td>
      <td>
        <button type="button" class="btn btn-danger" onclick="handleDelete(${index})">Delete</button>
      </td>
    </tr>`);
  }
}

// Hàm xử lý sự kiện khi người dùng nhấn nút Delete
function handleDelete(indexParam) {
  // console.log("Delete button indexParam: " + indexParam);
  // Xóa phần tử tại vị trí indexParam trong mảng listAccount
  var resultConfirm = confirm("Bạn có chắc chắn muốn xóa tài khoản này không?");
  if (resultConfirm == true) {
    // listAccount.splice(indexParam, 1);
    $.ajax({
      type: "DELETE",
      url: "http://localhost:8080/api/v1/accounts/" + listAccount[indexParam].id,
      success: function (response) {
        getListAccount();
      },
    });
  } else {
    alert("Bạn đã hủy xóa tài khoản này!");
  }
}

// Hàm xử lý sự kiện khi người dùng nhấn nút Edit
function handleEdit(indexParam) {
  // console.log("Edit button indexParam: " + indexParam);
  var account_edit = listAccount[indexParam];
  $("#ID_ID").val(account_edit.id);
  $("#Email_ID").val(account_edit.email);
  $("#Username_ID").val(account_edit.username);
  $("#Fullname_ID").val(account_edit.fullname);
  // account_edit.department tên phòng ban, nhưng dropdown listDepartment ID lại lưu trữ ID của phòng ban, nên cần tìm id của phòng ban tương ứng với tên phòng ban
  var v_DepId;
  for (let index = 0; index < listDepartment.length; index++) {
    if (listDepartment[index].name == account_edit.department) {
      v_DepId = listDepartment[index].id;
    }
  }
  $("#Department_ID").val(v_DepId);
  var v_PosId;
  for (let index = 0; index < listPosition.length; index++) {
    if (listPosition[index].name == account_edit.position) {
      v_PosId = listPosition[index].id;
    }
  }
  $("#Position_ID").val(v_PosId);
  $("#Cretate_Date_ID").val(account_edit.cretate_Date);

  // var indexAccountEdit = indexParam;
}

// Xử lý sự kiện click cho nút update
$("#update_btn").click(function (e) {
  // 2. Lấy dữ liệu người dùng nhập
  var v_ID_ID = $("#ID_ID").val();
  var v_Email_ID_Update = $("#Email_ID").val();
  var v_Username_ID_Update = $("#Username_ID").val();
  var v_Fullname_ID_Update = $("#Fullname_ID").val();
  var v_Department_ID_Update = $("#Department_ID").val();
  var v_Position_ID_Update = $("#Position_ID").val();
  var v_Cretate_Date_ID_Update = $("#Cretate_Date_ID").val();

  // {
  // "fullname": "Nguyễn Đạo",
  //  "departmentId": 11,
  //  "positionId": 4
  // // }

  var account_update = {
    fullname: v_Fullname_ID_Update,
    departmentId: v_Department_ID_Update,
    positionId: v_Position_ID_Update,
  };

  // Update API để lưu trữ dữ liệu account vào server

  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/api/v1/accounts/" + v_ID_ID,
    data: JSON.stringify(account_update),
    contentType: "application/json; charset=UTF-8",
    success: function (response) {
      getListAccount();
    },
  });

  // console.log("ID_ID: " + v_ID_ID);
  // console.log("Email_ID: " + v_Email_ID);
  // console.log("Username_ID: " + v_Username_ID);
  // console.log("Fullname_ID: " + v_Fullname_ID);
  // console.log("Department_ID: " + v_Department_ID);
  // console.log("Position_ID: " + v_Position_ID);
  // console.log("Cretate_Date_ID: " + v_Cretate_Date_ID);
  // listAccount
  // Tìm Account mà đang cần Update
  // var indexAccountEdit;
  // for (let index = 0; index < listAccount.length; index++) {
  //   if (listAccount[index].Id == v_ID_ID) {
  //     indexAccountEdit = index;
  //   }
  // }
  // // Cập nhật lại thông tin cho Account cần Update
  // listAccount[indexAccountEdit].Email = v_Email_ID_Update;
  // listAccount[indexAccountEdit].Username = v_Username_ID_Update;
  // listAccount[indexAccountEdit].Fullname = v_Fullname_ID_Update;
  // listAccount[indexAccountEdit].Department = v_Department_ID_Update;
  // listAccount[indexAccountEdit].Position = v_Position_ID_Update;
  // listAccount[indexAccountEdit].Cretate_Date = v_Cretate_Date_ID_Update;

  showListAccount();
});
