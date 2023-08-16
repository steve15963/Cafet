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
    <button className="Orderclose" onClick={closeModalWithNo}>
        X
    </button>
        </div>
</div>

    
  );
};
export default ModalBasic;
