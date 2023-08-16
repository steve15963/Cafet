import React, {useState } from "react";
import ModalBasic from "./ModalBasic";
import "./Item.css"



const Item = ({item, onDataFromChild}) => {

    const [modalOpen, setModalOpen] = useState(false);
    const showModal = ()=>{
      setModalOpen(true);
    }

      const [receivedData, setReceivedData] = useState([])


    const handleChildData=(dataFromChild)=>{
        console.log(dataFromChild)
        setReceivedData(dataFromChild)

        console.log(receivedData)
        onDataFromChild(dataFromChild)
      }

  return (
    <div>
                <img className="Orderimg" src={item.menuFile.url} alt=""></img>
                <br></br>
                <span>{item.menuType}</span>
                <div>
                  {item.getMenuPriceSizeDtoList.map((menuPriceSize) => (
                    <div>
                      <span>
                        {menuPriceSize.menuSize} : {menuPriceSize.menuPrice}
                      </span>
                    </div>
                  ))}
                  {/* <button
                    className="button2"
                    // variant="primary"
                    onClick={()=>{handleChildClick(menu)}}
                  > */}
                    <button
                    className="Orderbutton2"
                    // variant="primary"
                    onClick={showModal}
                  >
                    담기</button>
                    {modalOpen && <div className="OrderModalBackground"> </div>}
                  {modalOpen && <ModalBasic setModalOpen={setModalOpen} data={item} onDataToParent ={handleChildData}/>}

            
          
                </div>


    </div>

    
  );
};
export default Item;