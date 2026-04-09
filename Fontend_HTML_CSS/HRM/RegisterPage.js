$("#btn_register_id").click(function (e) {
  console.log("Register button clicked");
  var n_Email_id = $("#Email_id").val();
  var n_Username_id = $("#Username_id").val();
  var n_Password_id = $("#Password_id").val();
  var n_Re_Password = $("#Re_Password_Id").val();
  var n_Fullname_id = $("#Fullname_id").val();
  var depid = "1";
  var posid = "1";
  //   Kiểm tra dữ liệu
  //   console.log("Email: ", n_Email_id);
  //   console.log("Username: ", n_Username_id);
  //   console.log("Password: ", n_Password_id);
  //   console.log("Re_Password: ", n_Re_Password);
  //   console.log("Fullname: ", n_Fullname_id);

  // Validate dữ liệu
  if (!n_Fullname_id || n_Fullname_id.length < 6 || n_Fullname_id.length > 50) {
    // show thông báo
    alert("Fullname name must be from 6 to 50 characters!");
    return false;
  }

  if (!n_Email_id || n_Email_id.length < 6 || n_Email_id.length > 50) {
    // show thông báo
    alert("Email name must be from 6 to 50 characters!");
    return false;
  }

  if (!n_Username_id || n_Username_id.length < 6 || n_Username_id.length > 50) {
    // show thông báo
    alert("Username name must be from 6 to 50 characters!");
    return false;
  }

  if (n_Password_id != n_Re_Password) {
    alert("Mật khẩu không trùng khớp");
    return false;
  }
  //   {
  //     "email": "dao.nq254_1@gmail.com",
  //     "username": "daonq1",
  //     "fullname": "daonq1",
  //     "departmentId": "1",
  //     "positionId": "1",
  //     "password": "abcxyz"
  // }

  var account_register = {
    email: n_Email_id,
    username: n_Username_id,
    fullname: n_Fullname_id,
    departmentId: depid,
    positionId: posid,
    password: n_Password_id,
  };

  // Call API
  $.ajax({
    type: "POST",
    url: "http://localhost:8080/api/v1/accountsRegister",
    data: JSON.stringify(account_register), // Chuyển đổi đối tượng account thành chuỗi JSON để gửi lên server
    contentType: "application/json; charset=UTF-8",
    // beforeSend: function (xhr) {
    //   xhr.setRequestHeader("Authorization", "Basic " + btoa("Username1:123456"));
    // },
    success: function (response) {
      alert("Đăng ký thành công!");
      window.location.replace("Login.html");
    },
  });
});
