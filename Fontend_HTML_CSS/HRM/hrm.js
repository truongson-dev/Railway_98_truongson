console.log("HRM");
// Khai báo mảng global để lưu trữ danh sách tài khoản
var listAccount = [];
var listDepartment = [];
var listPossition = [];
// Khai báo 2 biến curentPage va curentSize để lưu trữ thông tin phân trang
var curentPage = 1; // Trang hiện tại, mặc định là trang 1
var curentSize = 5; // Số lượng bản ghi trên mỗi trang, mặc định là 5
// Khai báo biến để sort dữ liệu
var sortField = "id"; // Mặc định sort theo id
var isAsc = true; // Mặc định sort theo thứ tự tăng dần (asc)
// Load dữ liệu API Account
getListAccount();
getListDepartment();
getListPosition();
//
function getListAccount(params) {
  // Xây dựng đương link url
  let v_url = "";
  if (isAsc == true) {
    v_url = `http://localhost:8080/api/v1/accounts?size=${curentSize}&page=${curentPage}&sort=${sortField},asc`;
  } else {
    v_url = `http://localhost:8080/api/v1/accounts?size=${curentSize}&page=${curentPage}&sort=${sortField},desc`;
  }

  var v_search = $("#Search_ID").val();
  if (v_search) {
    v_url = v_url + `&search=${v_search}`;
  }
  //
  $.ajax({
    type: "GET",
    // url: "http://localhost:8080/api/v1/accounts?size=" + curentSize + "&page=" + curentPage,
    url: v_url,
    // data: "data",
    dataType: "json",
    success: function (response) {
      //
      console.log("Response API: ", response);
      // gán dữ liệu vào listAccount
      listAccount = response.content;
      // Hiển thị dữ liệu ở bảng kết quả
      showListAccount();

      // Hiển thị thông tin phân trang
      var totalPages = response.totalPages; // Tổng số trang
      pagingTable(totalPages);
      //
    },
  });
}
// hàm hiển thị thông tin phân trang
function pagingTable(totalPages) {
  $("#pagination_Id").empty();
  // Hiển thị nút Previous
  if (curentPage > 1) {
    $("#pagination_Id").append(`
    <li class="page-item"><a class="page-link" href="#" onclick="handlePrevious()">Previous</a></li>
    `);
  }

  // Hiển thị các nút bấm 1 2 3 ...
  for (let index = 1; index <= totalPages; index++) {
    if (index == curentPage) {
      $("#pagination_Id").append(`
        <li class="active"><a href="#" onclick="handleChangePage(${index})">${index}</a></li>
      `);
    } else {
      $("#pagination_Id").append(`
        <li><a href="#" onclick="handleChangePage(${index})">${index}</a></li>
      `);
    }
  }
  // Hiển thị nút next
  if (curentPage < totalPages) {
    $("#pagination_Id").append(`
    <li class="page-item"><a class="page-link" href="#" onclick="handleNext()">Next</a></li> 
    `);
  }
}
//

function handleChangePage(pageParam) {
  if (pageParam == curentPage) {
    return;
  } else {
    curentPage = pageParam;
    getListAccount();
  }
}

function handlePrevious() {
  curentPage = curentPage - 1;
  getListAccount();
}
function handleNext() {
  curentPage = curentPage + 1;
  getListAccount();
}

// Hàm xử lý sort dữ liệu
function changeSort(fieldParam) {
  if (sortField == fieldParam) {
    isAsc = !isAsc;
  } else {
    sortField = fieldParam;
    isAsc = true;
  }

  getListAccount();
}
// Hàm xử lý sự kiện khi người dùng nhấn nút Search
function handleSearch() {
  getListAccount();
}
//
function getListDepartment(params) {
  // Lấy dữ liệu API Department
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/v1/departments",
    // data: "data",
    dataType: "json",
    success: function (response) {
      // console.log("Response API Department: ", response);
      listDepartment = response;
      // Hiên thị dữ liệu ở dropdownlist Department
      for (let index = 0; index < listDepartment.length; index++) {
        $("#Department_ID").append(`
           <option value="${listDepartment[index].id}">${listDepartment[index].name}</option>
          `);
      }
    },
  });
}

function getListPosition(params) {
  // Lấy dữ liệu API Position
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/v1/possitions",
    // data: "data",
    dataType: "json",
    success: function (response) {
      // console.log("Response API Position: ", response);
      listPossition = response;
      // Hiên thị dữ liệu ở dropdownlist Department
      for (let index = 0; index < listPossition.length; index++) {
        $("#Position_ID").append(`
           <option value="${listPossition[index].id}">${listPossition[index].name}</option>
          `);
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
  // var v_ID_ID = $("#ID_ID").val();
  var v_Email_ID = $("#Email_ID").val();
  var v_Username_ID = $("#Username_ID").val();
  var v_Fullname_ID = $("#Fullname_ID").val();
  var v_Department_ID = $("#Department_ID").val();
  var v_Position_ID = $("#Position_ID").val();
  // var v_Cretate_Date_ID = $("#Cretate_Date_ID").val();

  // console.log("ID_ID: " + v_ID_ID);
  // console.log("Email_ID: " + v_Email_ID);
  // console.log("Username_ID: " + v_Username_ID);
  // console.log("Fullname_ID: " + v_Fullname_ID);
  // console.log("Department_ID: " + v_Department_ID);
  // console.log("Position_ID: " + v_Position_ID);
  // console.log("Cretate_Date_ID: " + v_Cretate_Date_ID);

  // 3. Lưu trữ dữ liệu(FE)
  // Tạo đối tượng account
  //   {
  //     "email": "daonq123_test8",
  //     "username": "daonq123_test8",
  //     "fullname": "daonq123_test8",
  //     "departmentId": "2",
  //     "positionId": "2"
  // }

  var account = {
    // Id: v_ID_ID,
    email: v_Email_ID,
    username: v_Username_ID,
    fullname: v_Fullname_ID,
    departmentId: v_Department_ID,
    positionId: v_Position_ID,
    // Cretate_Date: v_Cretate_Date_ID,
  };

  // Call API để lưu trữ dữ liệu account vào server Backend
  $.ajax({
    type: "POST",
    url: "http://localhost:8080/api/v1/accounts",
    data: JSON.stringify(account), // Chuyển đổi đối tượng account thành chuỗi JSON để gửi lên server
    contentType: "application/json; charset=UTF-8",
    success: function (response) {
      getListAccount();
    },
  });
  // console.log(account);

  // Lưu trữ account vào mảng listAccount
  // listAccount.push(account);
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
  var account_delete_id = listAccount[indexParam].id;
  var resultConfirm = confirm("Bạn có chắc chắn muốn xóa tài khoản này không?");
  if (resultConfirm == true) {
    // listAccount.splice(indexParam, 1);
    $.ajax({
      type: "DELETE",
      url: "http://localhost:8080/api/v1/accounts/" + account_delete_id,
      // data: "data",
      // dataType: "dataType",
      success: function (response) {
        showListAccount();
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
  // account_edit.department tên phòng ban, nhưng dropdownlist Department_ID lại lưu trữ id của phòng ban, nên cần phải tìm id của phòng ban dựa vào tên phòng ban
  // listDepartment
  var v_DepId;
  for (let index = 0; index < listDepartment.length; index++) {
    if (listDepartment[index].name == account_edit.department) {
      v_DepId = listDepartment[index].id;
    }
  }
  $("#Department_ID").val(v_DepId);
  var v_PosId;
  for (let index = 0; index < listPossition.length; index++) {
    if (listPossition[index].name == account_edit.position) {
      v_PosId = listPossition[index].id;
    }
  }
  $("#Position_ID").val(v_PosId);
  $("#Cretate_Date_ID").val(account_edit.createDate);

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
  //
  // {
  //   "fullname": "DAONQ123",
  //   "departmentId": "2",
  //   "positionId": "2"
  // }
  var account_update = {
    fullname: v_Fullname_ID_Update,
    departmentId: v_Department_ID_Update,
    positionId: v_Position_ID_Update,
  };
  // Update API để lưu trữ dữ liệu account vào server Backend
  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/api/v1/accounts/" + v_ID_ID,
    data: JSON.stringify(account_update), // Chuyển đổi đối tượng account thành chuỗi JSON để gửi lên server
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

  // showListAccount();
});