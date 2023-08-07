import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

import ContentCard from "../ContentCard/ContentCard";

import axios from "axios";

const AnimalList = () => {
  let navigate = useNavigate();

  const [animalList, setAnimalList] = useState([])

  const goToAnimalDetail = (animalId) => {
    navigate(`/shop/animal/${animalId}`)
  }
  useEffect(() => {
    axios.get('')
      .then(function (response) {
        setAnimalList(response.data)
      })
      .catch(function (error) {
        console.log(error)
      })  
  }, [])

  return (
    <div>
      <ContentCard />
    </div>

    
    
  );
}

export default AnimalList;