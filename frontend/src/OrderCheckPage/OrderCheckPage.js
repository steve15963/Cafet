import React, {useState, useEffect} from "react";
// import Header from '../Header/Header.js'
import OrderCheckBody from "./OrderCheckBody";
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
import {v4 as uuid} from 'uuid';

import { useParams } from "react-router-dom";

const OrderCheckPage = () => {
  const { shopId } = useParams();
  const [message, setMessage] = useState([])

  const getMessage = (msg, id, from) =>{
    setMessage((current) => [...current,({shopId : shopId, msg:msg, id:id, from:from})])
  }

  const [id] = useState(uuid())


  var sock = new SockJS('http://localhost:8080/chatting')
  let client = Stomp.over(sock);

  useEffect(() => {
    client.connect({}, () =>{
      // 받고
        client.subscribe('/topic/message/'+ shopId, function(frame){
          addMessage(JSON.parse(frame.body).content, JSON.parse(frame.body).uuid)
          // props.getMessage(JSON.parse(frame.body).content,false)
        })
    })
      // eslint-disable-next-line react-hooks/exhaustive-deps
}, [])

const addMessage = (content, uuid) => {
  if(uuid === id){
    // props.getMessage(content, true)
  }else{
    getMessage(content,uuid, false)
  }
}

  return (
    <div className="App">
      <p>주문 확인 페이지입니다.</p>
      <div>{shopId}</div> {/* room number */}
      {/* <Header className="header_class"/> */}
      <OrderCheckBody message = {message}/>
    </div>
  );
};
export default OrderCheckPage;
