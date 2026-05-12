// rcc
import React, { Component } from "react";
import ComponentTopChild from "./ComponentTopChild.js";

class ComponentsTop extends Component {
  // click_number = 0;
  // Khai báo trong hàm contructor của class component
  // Hàm đầu tiên được gọi khi class component được khởi tạo
  // constructor(props) {
  //   super(props);
  //   // Khai baos state để lưu trữ số lần người dùng click vào button
  //   this.state = {
  //     click_number: 0,
  //     // a: "daonq",
  //     // b: 40,
  //   };
  // }

  constructor(props) {
    super(props);
    this.state = {
      input: "", // Khai báo state để lưu trữ giá trị của input
    };
  }

  // Khai báo hàm xử lý sự kiện onChange của input

  handleChange = (event) => {
    // console.log("Change!!");
    // console.log("Value: ", event);
    let value = event.target.value; // Lấy giá trị của input từ event
    this.setState({
      input: value, // Cập nhật giá trị của input vào state
    });
  };

  dataTop = "Data from ComponentsTop";

  handleClick = () => {
    // console.log("Click!!");
    // this.click_number++;
    // console.log("Click number: ", this.click_number);
    // this.render();
    // this.state.click_number = this.state.click_number + 1;
    // this.setState({
    //   click_number: this.state.click_number + 1,
    // });
    // this.props.getDataFromTop(this.dataTop);
    alert("input: " + this.state.input);
  };
  // render(): hiển thị các thành phần của component ra giao diện người dùng
  render() {
    // Nhận lại dữ liệu từ App.js thông qua props
    // this.props  Lấy được tất cả các props được truyền từ component cha
    // let data1 = this.props.data1; // Lấy được giá trị của prop_data1 được truyền từ component cha App.js
    // let data2 = this.props.data2;
    // let headingTop = this.props.headingTop;
    // Destructuring: Cú pháp phân rã, giúp lấy ra các giá trị từ một đối tượng hoặc mảng một cách dễ dàng hơn
    let { data1, data2, headingTop, data3, DataAppToTopChild } = this.props; // Lấy được giá trị của prop_data1, prop_data2 và prop_headingTop được truyền từ component cha App.js

    // console.log("data1: ", data1);
    // console.log("data2: ", data2);
    // console.log("data3: ", data3);
    return (
      <>
        <div className="row">
          <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <div className="panel panel-primary">
              <div className="panel-heading">
                <h3 className="panel-title">{headingTop}</h3>
              </div>
              <div className="panel-body">
                <div className="row">
                  <div className="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                    {/* <input type="text" className="form-control" value={this.state.click_number} /> */}
                    <input type="text" className="form-control" onChange={this.handleChange} value={this.state.input} />
                  </div>

                  <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                    <button type="button" className="btn btn-danger" onClick={this.handleClick}>
                      Sent Data
                    </button>
                  </div>

                  <ComponentTopChild DataAppToTopChild={DataAppToTopChild} />
                </div>
              </div>
            </div>
          </div>
        </div>
      </>
    );
  }
  //
}

export default ComponentsTop;
