import React, { Component } from "react";

class ComponentTopChild extends Component {
  render() {
    let { DataAppToTopChild } = this.props;
    return <div>{DataAppToTopChild}</div>;
  }
}

export default ComponentTopChild;
