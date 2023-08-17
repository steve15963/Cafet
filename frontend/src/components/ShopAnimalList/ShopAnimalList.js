import { useState, useEffect } from "react";

import './ShopAnimalList.scoped.css'
import ShopAnimalListItem from "../ShopAnimalListItem/ShopAnimalListItem";

import axios from "axios";

const ShopAnimalList = ({ shopId }) => {

  const [animalList, setAnimalList] = useState([]);

  useEffect(() => {
    axios
      .get(`https://i9a105.p.ssafy.io/api/shop/${shopId}`)
      .then(function (response) {
        console.log(response.data)
        setAnimalList(response.data.shopPetList);
      })
      .catch(function (error) {
        console.log(error);
      });
  }, [shopId]);
  
  return (
    <div>
      {
        animalList.map((el) => 
          <ShopAnimalListItem
          key={el.shopPetId} 
          shopId={shopId} 
          data={el} />
        )
      }
    </div>
  );
};

export default ShopAnimalList;
