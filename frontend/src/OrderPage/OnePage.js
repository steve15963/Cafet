import React, {useState } from "react";
import OrderPage from "./OrderPage";
import Cart from "./Cart.js"
import "./OnePage.css"

const OnePage = () => {


    const [dataFromChild, setDataFromChild]=useState([])

    // const handleDeleteItem = (index) =>{
    //     const updatedItems = items.filter((_,i) => i !== index );
    //     setDataFromChild(updatedItems);
    // }

    // const handleReset = () =>{
    //     setDataFromChild(0);
    // }

    const handleDataFromChild = (data) => {
        setDataFromChild(data);
        console.log("최상위"+data);
        console.log("최상위데이터"+data)
    };


  return (
    <div>
        <div className="Ordercontainer">
            <div className="Orderone">
                <OrderPage onDataFromChild= {handleDataFromChild}></OrderPage>
            </div>
            <div className="Ordertwo">
            <Cart data={dataFromChild}></Cart>
            </div>
        </div>

    </div>

    
  );
};
export default OnePage;
