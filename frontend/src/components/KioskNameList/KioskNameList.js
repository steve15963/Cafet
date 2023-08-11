import React, { useState, useEffect } from "react";
import "./KioskNameList.scoped.css";

const KioskNameList = () => {
  const [nameList, setNameList] = useState([]);

  useEffect(() => {
    async function fetchNameList() {
      try {
        const response = await fetch("서버 API 주소");
        const data = await response.json();
        setNameList(data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    }

    fetchNameList();
  }, []);

  return (
    <div>
      <h2>Name List</h2>
      <ul>
        {nameList.map((item, index) => (
          <li key={index}>{item.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default KioskNameList;
