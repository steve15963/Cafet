import React, { useEffect, useState } from "react";

// import SockJS from "sockjs-client";
// import Stomp from "stompjs";
// import { v4 as uuid } from "uuid";

import { useParams } from "react-router-dom";
import axios from "axios";
import "./OrderPage.css";

import Item from "./Item.js"

const OrderPage = ({onDataFromChild}) => {
  const { shopId, tableId } = useParams();
  const [menuList, setMenuList] = useState([]);

  


  // const [receivedData, setReceivedData] = useState([])
  const handleChildData=(dataFromChild)=>{
    console.log(" "+dataFromChild)
    // setReceivedData(dataFromChild)
    // console.log(receivedData)
    onDataFromChild(dataFromChild)
  }


  useEffect(() => {
    getMenuList();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  

  const getMenuList = async () => {
    const resp = await (
      await axios.get("https://i9a105.p.ssafy.io/api/menu/show/" + shopId)
    ).data;
    setMenuList(resp);
    // console.log(resp)
  };



  return (
    <div>
      <p></p>
      <button className="Orderbutton1"> 애견 정보 </button>

      <br></br>
      <div className="Ordertitle">
        shop : {shopId}, table : {tableId}
      </div>
      <br></br>
      <br></br>
      {/* <div>{receivedData}</div> */}

      <div className>
        <div className>
          {menuList &&
            menuList.map((item) => (
              <div className="OrderorderItem1">
              <Item item={item} onDataFromChild= {handleChildData}/>
              </div>
            ))}
        </div>
      </div>
      <br></br>
    </div>
  );
};
export default OrderPage;
