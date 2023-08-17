import React, {useState} from "react";
import "./Cart.css"
import "./ModalBasic.css"

const ModalBasic = ({setModalOpen, data, onDataToParent}) => {

    const [size, setSize] = useState("");
    const [price, setPrice]= useState("")

    const [quantity, setQuantity] = useState(1);

    const handleIncrement=()=>{
        setQuantity(quantity+1);
    }

    const handleDecrement=()=>{
        if(quantity > 1){
            setQuantity(quantity - 1);
        }
    };

    const closeModal= (data,s, p, q)=>{
        //데이터 상위에 전달

        console.log(q)

        const newItem = [data.menuType,p.price,q ,s.size,data.menuFile.url];

        onDataToParent(prevItems => [...prevItems, newItem])
        // onDataToParent(data.menuType);

        // console.log(size);

        // console.log(menu.menuType)
    

        setModalOpen(false);
    }

    const closeModalWithNo=()=>{
        setModalOpen(false);
    }

    const handleButtonClick=(menuPriceSize)=>{

        setPrice(menuPriceSize.menuPrice);
        setSize(menuPriceSize.menuSize);

    }

  return (
    <div>
    <div className="Ordermodal">
        <p class="Ordermessage">주문하세요!</p>
        <h1>{data.menuType}</h1>

        <div className="">
                <img className="Orderimg_big" src={data.menuFile.url} alt=""></img>
                <div>
                  {data.getMenuPriceSizeDtoList.map((menuPriceSize) => (
                    <div>
                      <span>
                        <button onClick={()=> handleButtonClick(menuPriceSize)}>{menuPriceSize.menuSize} : {menuPriceSize.menuPrice}</button>
                      </span>
                    </div>
                  ))}
                  <button className="Orderminus" onClick ={handleDecrement}> - </button>
                  <span>  {quantity}  </span>
                <button className="Orderplus" onClick = {handleIncrement}> + </button>
                    <br></br>
                    <button
                    className="Orderbutton2"
                    onClick={()=>closeModal(data,{size},{price},quantity)}
                  >
                    담기</button>
                </div>
    </div>
    <div onClick={closeModalWithNo} class="Orderclose"><svg xmlns="http://www.w3.org/2000/svg" width="20" viewBox="0 0 20 20" height="20"><path fill="#393a37" d="m15.8333 5.34166-1.175-1.175-4.6583 4.65834-4.65833-4.65834-1.175 1.175 4.65833 4.65834-4.65833 4.6583 1.175 1.175 4.65833-4.6583 4.6583 4.6583 1.175-1.175-4.6583-4.6583z"></path></svg></div>
        </div>
</div>

    
  );
};
export default ModalBasic;
