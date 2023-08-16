import React from "react";
import "./Cart.css"
import { useState } from "react";
import SockJS from "sockjs-client";
import Stomp from "stompjs";

const Cart = (props, {onDelete}) => {

  const [money]=useState("");

  // const history = useHistory();



  const reset= ()=>{
    window.location.reload()
  };

  var sock = new SockJS("https://i9a105.p.ssafy.io/order");
  let client = Stomp.over(sock);

  const setMessage = () => {
    // console.log(sock);
    client.send(
      "/app/message",
      {},
      JSON.stringify({
        shopId: "1",
        tableId: "1",
        content: {props},
      })
    );
  };

  return (
    <div className="two">
    <div className="cart">
      <div className="cartItem">
      
      
        {/* <div>{props}</div> */}

        
        {props.data.map((propGroup)=>(
            // <div className="no_dot" key={index}>
            <div  className="CartBox">
            <div className="CartBoxNotEight">
             <div>
                {props.data.length<=8 && <img src={propGroup[4]} alt=""/>}
              </div>
              <div>
                {props.data.length<=8 && <div>{propGroup[0]}</div>}
                {props.data.length<=8 && <div>{propGroup[3]} : ₩ {propGroup[1]}원</div>}
                {props.data.length<=8 && <div className="bold">수량 : {propGroup[2]}개</div>}
                <button>삭제</button>
              </div>
            </div>
            <div className="CartBoxEight">
              {props.data.length>8 && <div>{propGroup[0]}</div>}
              {props.data.length>8 && <div>{propGroup[3]} : ₩ {propGroup[1]}원</div>}
              {props.data.length>8 && <div>수량 : {propGroup[2]}개</div>}
              </div>
          </div>
        ))}

      </div>
      <div className="buttons">
        
        <span>
          총 결제 금액 <span className="totalPrice">{money} ₩ </span>
        </span>
        <span className="timer">현재까지 담은 품목!</span>
        <button className="allCancelButton" onClick={reset}>
          전체취소
        </button>
      </div>
      <button className="orderButton" onClick={setMessage}>
        결제하기
      </button>

    </div>
    </div>

    
  );
};
export default Cart;