import React from "react";
import "./KioskNameList.scoped.css";
import useKioskList from "../../hooks/useKioskList";
import { useNavigate } from "react-router-dom";

const KioskNameList = () => {
  const shopId = localStorage.getItem("shopId");
  const { nameList, loading } = useKioskList(shopId);
  const navigate = useNavigate();

  if (loading || !nameList) {
    return <div>Loading...</div>;
  }

  if (nameList.length === 0) {
    navigate("/kiosk/first", { replace: true });
  }

  return (
    <div>
      <h2>Name List</h2>
      <ul>
        {nameList.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>
    </div>
  );
};

export default KioskNameList;
