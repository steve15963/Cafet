import React from "react";
import "./KioskNameList.scoped.css";
import useKioskList from "../../hooks/useKioskList";
import { useNavigate } from "react-router-dom";
import Button from "../Button/Button";

const KioskNameList = () => {
  const shopId = localStorage.getItem("shopId");
  const { nameList, loading } = useKioskList(shopId);
  const navigate = useNavigate();

  if (loading || !nameList) {
    return <div>Loading...</div>;
  }

  console.log(nameList);
  
  const handleDeskClick = (deskId, deskNum) => {
    localStorage.setItem("selectedDeskId", deskId);
    localStorage.setItem("selectedDeskNum", deskNum);
    
    navigate(`/kiosk/menu/buy/${shopId}/${deskNum}`);
  };

  const handleEditClick = (deskId) => {
    // Handle edit button click, e.g., navigate to edit page
    console.log(`Edit button clicked for deskId: ${deskId}`);
  };

  const handleDeleteClick = (deskId) => {
    // Handle delete button click, e.g., show a confirmation modal
    console.log(`Delete button clicked for deskId: ${deskId}`);
  };

  if (nameList.length === 0) {
    navigate("/kiosk/first", { replace: true });
  }

  const handleManageClick = () =>{

    navigate(`/kiosk/manage/${shopId}`)

  }

  return (
    <div className="kiosk-list-container">     
    <button className="Orderbutton1" onClick={() => handleManageClick()}> 관리페이지 </button>
    <br/>
      <p className="login-form-title">키오스크 리스트</p>
      <br />
      {nameList.map(item => (
        <div key={item.deskId} className="kiosk-list-item">
          <div
            key={item.deskId}
            className="kiosk-list-item"
            onClick={() => handleDeskClick(item.deskId, item.deskNum)}
          >
            Desk {item.deskId}: (Number {item.deskNum})
          </div>
          <div className="button-container">
            <Button
              type="gray"
              text={"수정"}
              onClick={handleEditClick(item.deskId)}
            />
            <Button
              type="gray"
              text={"삭제"}
              onClick={handleDeleteClick(item.deskId)}
            />
          </div>
        </div>
      ))}
    </div>
  );
};

export default KioskNameList;
