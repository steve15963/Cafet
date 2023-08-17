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
      <div onClick={showModal}>
        <img className="Orderimg" src={item.menuFile.url} alt=""></img>
          <br></br>
          <div className="OrderFont">{item.menuType}</div>
          <div>
            {item.getMenuPriceSizeDtoList.map((menuPriceSize) => (
              <div>
                <span>
                  {menuPriceSize.menuSize} : {menuPriceSize.menuPrice}
                </span>
              </div>
              ))}
        </div>
      </div>
      {modalOpen && <div className="OrderModalBackground"> </div>}
      {modalOpen && <ModalBasic setModalOpen={setModalOpen} data={item} onDataToParent ={handleChildData}/>}          
    </div>
    
  );
};
export default Item;