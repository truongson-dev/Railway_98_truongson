import "./App.css";
import Hello from "./Hello";
import React from "react";
function App() {
  // return <div className="App">Hello World</div>;
  // createElement(tên thẻ, thuộc tính, nội dung)

  //<div>
  // <h1>Hello World</h1>
  // </div>;

  // return React.createElement("div",null,React.createElement("h1", null, "Hello World"));\
  // => JSX ----học theo cách viết HTML trong JavaScript--
  // Babel sẽ chuyển JSX thành JavaScript thuần túy
  // <React.Fragment>: một component đặc biệt cho phép bạn nhóm một danh sách con mà không cần thêm phần tử mới vào DOM
  // <> </> : viết tắt của <React.Fragment></React.Fragment>
  // Cách 2: tạo đối tượng CSS trong React
  // let cssDiv = {
  //   color: "red",
  //   backgroundColor: "yellow",
  // };

  // Khai báo hàm sử lý sự kiện clickhere
  // Arrow function
  let handleClickHere = () => {
    alert("Hello World");
  };

  return (
    <>
      <div className="App classDiv" /* style={cssDiv} */>
        <h1>Hello World</h1>

        <button onClick={handleClickHere}>Click here</button>
      </div>
    </>
  );
}

export default App;
