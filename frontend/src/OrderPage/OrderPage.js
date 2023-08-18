import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
// import SockJS from "sockjs-client";
// import Stomp from "stompjs";
// import { v4 as uuid } from "uuid";

import { useParams } from "react-router-dom";
import axios from "axios";
import "./OrderPage.css";

import Item from "./Item.js"
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';


const OrderPage = ({onDataFromChild}) => {
  const { shopId, tableId } = useParams();
  const [menuList, setMenuList] = useState([]);
  const navigate = useNavigate();
  
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

  const handleAnimalClick = () => {
    // localStorage.setItem("selectedDeskId", deskId);
    // localStorage.setItem("selectedDeskNum", deskNum);
    
    navigate(`/kiosk/animal`);
  };
  
  const [currentPage, setCurrentPage] = useState(1);

  const itemsPerPage = 8;
  const totalPages = Math.ceil(menuList.length/itemsPerPage);

  const handlePageChange = (newPage) => {
    setCurrentPage(newPage)
  }

  const startIndex = (currentPage - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;
  const imagesToDisplay = menuList.slice(startIndex, endIndex) 

  return (
    <div>
      <p></p>
      <button className="Orderbutton1" onClick={handleAnimalClick}> 애견 정보 </button>

      <br></br>
      <div className="Ordertitle">
      </div>
      <br></br>
      <br></br>
      <Slider>
      {/* <div>{receivedData}</div> */}
      <div className>
        <div className>
          {imagesToDisplay &&
            imagesToDisplay.map((item) => (
              <div className="OrderorderItem1">
              <Item item={item} onDataFromChild= {handleChildData}/>
              </div>
            ))}
        </div>
        <div>
          {Array.from({length : totalPages}, (_,index)=>(
            <button 
            style={{backgroundColor:currentPage === index+1 ? '	#FF0000' : ''}}
            className="OrderNextButton" key={index} onClick={()=> handlePageChange(index +1)}>
              {index+1}
            </button>
          ))}
        </div>
      </div>
      </Slider>
      <br></br>
    </div>
  );
};
export default OrderPage;
