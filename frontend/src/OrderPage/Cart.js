import React from "react";
import "./Cart.css"
import { useState } from "react";
import SockJS from "sockjs-client";
import Stomp from "stompjs";

const Cart = (props) => {

  let [money]=useState(0);

  // const history = useHistory();

  const reset= ()=>{
    window.location.reload()
  };

   var sock = new SockJS("https://i9a105.p.ssafy.io/order");
  //var sock = new SockJS("http://localhost:8080/order")
  let client = Stomp.over(sock);

  const setMessage = (p) => {

    // console.log(sock);
    client.send(
      "/app/message",
      {},
      JSON.stringify({
        shopId: p.props.data1,
        tableId: p.props.data2,
        content: p.props.data,
      })
    );
  };

  props.data.forEach(element => (

    // console.log(element[1]);
    // setMoney(element[1])
    money += element[1]*element[2]
  ));

  return (
    <div className="Ordertwo">
    <div className="Ordercart">
      <div className="OrdercartItem">
      
      
        {/* <div>{props}</div> */}

        
        {props.data.map((propGroup)=>(
            // <div className="no_dot" key={index}>
            
            <div className="OrderCartBox">
            <div className="OrderCartBoxNotEight">
              
             <div>
                {props.data.length<=8 && <img src={propGroup[4]} alt=""/>}
              </div>
              <div>
                {props.data.length<=8 && <div>{propGroup[0]}</div>}
                {props.data.length<=8 && <div>{propGroup[3]} : ₩ {propGroup[1]}원</div>}
                {props.data.length<=8 && <div className="Orderbold">수량 : {propGroup[2]}개</div>}
                {/* <button>삭제</button> */}
              </div>
            </div>
            <div className="OrderCartBoxEight">
              {props.data.length>8 && <div>{propGroup[0]}</div>}
              {props.data.length>8 && <div>{propGroup[3]} : ₩ {propGroup[1]}원</div>}
              {props.data.length>8 && <div>수량 : {propGroup[2]}개</div>}
              </div>
          </div>
        ))}

      </div>
      <div className="Orderbuttons">
        
        <span>
          총 결제 금액 <span className="OrdertotalPrice">{money} ₩ </span>
        </span>
        <span className="Ordertimer">현재까지 담은 품목!</span>
        <button className="OrderallCancelButton" onClick={reset}>
          전체취소
        </button>
      </div>
      <button className="OrderorderButton" onClick={()=>setMessage({props})}>
        결제하기
      </button>

    </div>
    </div>

    
  );
};
export default Cart;
