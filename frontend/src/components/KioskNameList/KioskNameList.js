import React from "react";
import "./KioskNameList.scoped.css";
import useKioskList from "../../hooks/useKioskList";

const KioskNameList = () => {
  const { nameList, loading } = useKioskList();

  if (loading) {
    return <div>Loading...</div>;
  }

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
