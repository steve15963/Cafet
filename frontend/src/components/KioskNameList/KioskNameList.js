import React, { useState } from "react";
import "./KioskNameList.scoped.css";
import useKioskList from "../../hooks/useKioskList";
import { Modal } from "@mui/material";

const KioskNameList = () => {
  const { nameList } = useKioskList();
  const [isModalOpen, setIsModalOpen] = useState(false);

  if (nameList.length === 0) {
    setIsModalOpen(true);
  }

  return (
    <div>
      <h2>Name List</h2>
      <ul>
        {nameList.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>
      {isModalOpen && <Modal onClose={() => setIsModalOpen(false)} />}
    </div>
  );
};

export default KioskNameList;
