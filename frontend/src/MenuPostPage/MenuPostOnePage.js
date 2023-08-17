import React, {useState } from "react";
import Cart from "./Cart.js"
import "./OnePage.css"
import { useParams } from "react-router-dom";
import MenuAdminPage from "./MenuAdminPage";
import MenuPostPage from "./MenuPostPage";

const MenuPostOnePage = () => {
    const { shopId } = useParams();
    const { tableId } = useParams();

  return (
    <div>
        <div className="Ordercontainer">
            <div className="Orderone">
                <MenuAdminPage></MenuAdminPage>
                {/* <OrderPage onDataFromChild= {handleDataFromChild}></OrderPage> */}
            </div>
            <div className="Ordertwo">
                <MenuPostPage></MenuPostPage>
            {/* <Cart data={dataFromChild} data1={shopId} data2={tableId}></Cart> */}
            </div>
        </div>

    </div>

    
  );
};
export default MenuPostOnePage;
