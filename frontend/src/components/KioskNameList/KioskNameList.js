import React from "react";
import "./KioskNameList.scoped.css";
import useKioskList from "../../hooks/useKioskList";
import { useNavigate } from "react-router-dom";
import Button from "../Button/Button";
import handleDeleteTable from "../../utils/handleDeleteTable";
// import handleModifyTable from "../../utils/handleModifyTable";

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

  // const onEditClick = async (shopId, deskNum) => {
  //   try {
  //     //eslint-disable-next-line
  //     const response = await handleModifyTable(shopId, deskNum);
  //     console.log("Login success : ");
  //     alert("테이블 이름이 수정되었습니다.");
  //     window.location.reload();
  //   } catch (error) {
  //     console.error("Login failed:");
  //     alert("테이블 이름 수정에 실패하셨습니다.");
  //   }
  // };

  const onDeleteClick = async (shopId, deskNum) => {
    try {
      //eslint-disable-next-line
      const response = await handleDeleteTable(shopId, deskNum);
      console.log("Table delete success : ");
      alert("테이블이 삭제되었습니다.");
      window.location.reload();
    } catch (error) {
      console.error("Table delete failed:");
      alert("테이블 삭제에 실패하셨습니다.");
    }
  };

  if (nameList.length === 0) {
    navigate("/kiosk/first", { replace: true });
  }

  const handleManageClick = () => {
    navigate(`/kiosk/manage/${shopId}`);
  };

  return (
    <div className="kiosk-list-container">
      <button className="Orderbutton1" onClick={() => handleManageClick()}>
        {" "}
        관리페이지{" "}
      </button>
      <br />
      <p className="login-form-title">키오스크 리스트</p>
      <br />
      {nameList.map((item) => (
        <div key={item.deskId} className="kiosk-list-container">
          <div className="kiosk-item-wrapper">
            <div
              className="kiosk-list-item"
              key={item.deskId}
              onClick={() => handleDeskClick()}
            >
              Desk {item.deskId}: (Number {item.deskNum})
            </div>
            {/* <div className="button-container">
              <Button
                type="kiosk"
                text={"수정"}
                onClick={() => onEditClick(shopId, item.deskNum)}
              />
            </div> */}
            <Button
              type="kiosk"
              text={"삭제"}
              onClick={() => onDeleteClick(shopId, item.deskNum)}
            />
          </div>
        </div>
      ))}
    </div>
  );
};

export default KioskNameList;
