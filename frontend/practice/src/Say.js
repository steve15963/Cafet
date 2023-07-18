import React, { useState } from "react";

const Say = () => {
  const [message, setMessage] = useState("");
  const onClickEnter = () => setMessage("이랏샤이마세");
  const onClickLeave = () => setMessage("NAGA");

  const [color, setColor] = useState("black");

  return (
    <div>
      <button onClick={onClickEnter}>입실</button>
      <button onClick={onClickLeave}>퇴실</button>
      <h1 style={{ color }}>{message}</h1>
      <button style={{ color: "red" }} onClick={() => setColor("red")}>
        빨간색
      </button>
      <button style={{ color: "green" }} onClick={() => setColor("green")}>
        초록색
      </button>
      <button style={{ color: "blue" }} onClick={() => setColor("blue")}>
        파란색
      </button>
    </div>
  );
};
export default Say;
