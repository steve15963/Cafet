import React from "react";
import { useNavigate } from "react-router-dom";
// import { useParams } from "react-router-dom";


const KioskManage = () => {
    // const { shopId } = useParams();

    const navigate = useNavigate();

    const handleOrderCheckClick = () =>{
        navigate(`check`)
    }

    const handlePostMenuClick = () =>{
        navigate(`post`)
    }


  return (
    <div>
    <h1>관리자 페이지</h1>
    <br></br>
    <br></br>
    <button className="Orderbutton1" onClick={() => handleOrderCheckClick()}> 주문받기 </button>

    <br></br>
    <br></br>
    <br></br>
    <br></br>

    <button className="Orderbutton1" onClick={() => handlePostMenuClick()}> 메뉴 추가하기 </button>

    </div>
    
  );
};
export default KioskManage;