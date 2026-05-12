// rsf
import React from "react";

function ComponentsBottom(props) {
  //
  // let headingBottom = props.headingBottom
  // let data1 = props.data1
  // let data2 = props.data2
  // let data3 = props.data3

  let { headingBottom, data1, data2, data3, dataApp } = props;
  //
  return (
    <div className="row">
      <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
        <div className="panel panel-warning">
          <div className="panel-heading">{headingBottom}</div>
          <div className="panel-body">
            <div>
              <textarea
                name=""
                id="input"
                className="form-control"
                rows="3"
                required="required"
                value={dataApp}
              ></textarea>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ComponentsBottom;
