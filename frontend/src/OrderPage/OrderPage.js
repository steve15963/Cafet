import React, { useEffect, useState } from "react";

import SockJS from "sockjs-client";
import Stomp from "stompjs";
import { v4 as uuid } from "uuid";

import { useParams } from "react-router-dom";
import axios from "axios";
import "./OrderPage.scoped.css";

const OrderPage = () => {
  const { shopId, tableId } = useParams();
  const [menuList, setMenuList] = useState([]);
  const [menuId] = useState("");
  const [menuType] = useState("");
  const [menuPrice] = useState("");

  const [id] = useState(uuid());

  var sock = new SockJS("https://i9a105.p.ssafy.io/chatting");
  let client = Stomp.over(sock);

  const setMessage = () => {
    // console.log(sock);
    client.send(
      "/app/message",
      {},
      JSON.stringify({
        shopId: shopId,
        tableId: tableId,
        content: "카라멜 마끼아또",
        uuid: id,
      })
    );
  };

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
    <div className="Center">
      <p></p>
      <button className="button1"> 애견 정보 </button>

      <br></br>
      <div>
        shop : {shopId}, table : {tableId}
      </div>
      <br></br>
      <br></br>

      <div>{menuId}</div>
      <div>{menuType}</div>
      <div>{menuPrice}</div>

      <div>
        <div>
          {menuList &&
            menuList.map((menu) => (
              <div>
                <div>
                  <img src={menu.menuFile.url} alt=""></img>
                </div>
                <div>{menu.menuType}</div>
                <div>
                  {menu.getMenuPriceSizeDtoList.map((menuPriceSize) => (
                    <div>
                      <div>
                        {menuPriceSize.menuSize} : {menuPriceSize.menuPrice}{" "}
                      </div>
                    </div>
                  ))}
                  <button
                    className="button2"
                    variant="primary"
                    onClick={setMessage}
                  >
                    {" "}
                    담기{" "}
                  </button>
                  <br></br>
                  <br></br>
                </div>
              </div>
            ))}
        </div>
      </div>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      {/* 
        <div className="product_container">
            <div className="product">
                <div className="product_img_div">
                <img src="https://picturepractice.s3.ap-northeast-2.amazonaws.com/Kiosk/starbucks.jpg" alt=""></img>
                </div>
                <h5 className="product_title">아메리카노</h5>
                <div className="product_mon">5500원</div>
                <button className="button2"> 담기 </button>
            </div>
            <div className="product">
                <div className="product_img_div">
                <img src="https://picturepractice.s3.ap-northeast-2.amazonaws.com/Kiosk/latte.png" alt=""></img>
                </div>
                <h5 className="product_title">카페라떼</h5>
                <div className="product_mon">6000원</div>
                <button className="button2"> 담기 </button>
            </div>
            <div className="product">
            <div className="product_img_div">
            <img src="https://picturepractice.s3.ap-northeast-2.amazonaws.com/Kiosk/caramel.png" alt=""></img>
            </div>
            <h5 className="product_title">카라멜 마끼아또</h5>
            <div className="product_mon">6500원</div>
            <button className="button2" variant="primary" onClick={setMessage}> 담기 </button>
            </div>
        </div> */}
    </div>
  );
};
export default OrderPage;
