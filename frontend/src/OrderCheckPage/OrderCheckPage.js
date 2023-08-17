import React, {useState, useEffect} from "react";
// import Header from '../Header/Header.js'
import OrderCheckBody from "./OrderCheckBody";
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';

import { useParams } from "react-router-dom";

const OrderCheckPage = () => {
  const { shopId } = useParams();
  const [message, setMessage] = useState([])

  console.log(shopId)

  const getMessage = (msg) =>{
    setMessage((current) => [...current,({"msg":msg})])
  }

  const handleRemoveMenu = (index) =>{

    const updatedMenuList = message.filter((item, i) => i !== index);

    setMessage(updatedMenuList)
  }

  // var sock = new SockJS('https://i9a105.p.ssafy.io/order')
  var sock = new SockJS('http://localhost:8080/order')
  let client = Stomp.over(sock);

  useEffect(() => {
    client.connect({}, () =>{
      // 받고
        client.subscribe('/topic/message/'+ shopId, function(frame){
          addMessage(frame.body)
          // addMessage(JSON.parse(frame.body).content)
          // props.getMessage(JSON.parse(frame.body).content,false)
        })
    })
      // eslint-disable-next-line react-hooks/exhaustive-deps
}, [])

const addMessage = (content) => {
  // if(uuid === id){
  //   // props.getMessage(content, true)
  // }else{
    getMessage(content)
  // }
}



  return (
    <div className="App">
      <div>shop : {shopId}번(이름)</div> {/* room number */}
      <p>주문 확인 페이지입니다.</p>
      {/* <Header className="header_class"/> */}
      <OrderCheckBody message = {message} onRemoveMenu={handleRemoveMenu}/>
    </div>
  );
};
export default OrderCheckPage;
