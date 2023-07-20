import React from "react";

import Nav from "react-bootstrap/Nav";

const rectangleStyle = {
  border: "solid",
  borderWidth: "0 0 1px 0",
};

const AdminSideBar = () => {
  return (
    <Nav defaultActiveKey="/home" className="flex-column">
      <div style={rectangleStyle}>
        <Nav.Link href="/home">유저 관리</Nav.Link>
      </div>
      <div style={rectangleStyle}>
        <Nav.Link href="/home">업주 관리</Nav.Link>
      </div>
      <div style={rectangleStyle}>
        <Nav.Link href="/home">등록 요청 관리</Nav.Link>
      </div>
    </Nav>
  );
};

export default AdminSideBar;
