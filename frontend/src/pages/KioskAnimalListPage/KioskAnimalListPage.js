import { useState, useEffect } from "react";
import axios from "axios";

import KioskAnimalListItem from "../../components/KioskAnimalListItem/KioskAnimalListItem";

const KioskAnimalListPage = () => {
  let shopId = 1

  const [animalList, setAnimalList] = useState([]);

  useEffect(() => {
    axios
      .get(`https://i9a105.p.ssafy.io/api/shop/${shopId}`)
      .then(function (response) {
        setAnimalList(response.data.shopPetList);
      })
      .catch(function (error) {
        console.log(error);
      });
  }, [shopId]);

  return (
    <div>
      <div>애견정보</div>
      {
        animalList.map((el) => 
          <KioskAnimalListItem 
              key={el.shopPetId}
              data={el} />
        )
      }
    </div>
  );
  
  
}

export default KioskAnimalListPage;
