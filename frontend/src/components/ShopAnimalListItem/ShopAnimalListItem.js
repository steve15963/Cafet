import { useNavigate } from 'react-router-dom'

import './ShopAnimalListItem.scoped.css'

const ShopAnimalListItem = ({ shopId, data }) => {

  const navigate = useNavigate();

  const goToDetailAnimal = () => {
    navigate(`/shop/${shopId}/${data.shopPetId}`)
  }
  return (
    <div className='animalItem'>
      <div className='img_section' onClick={goToDetailAnimal}>
        <img alt={data.petName} src={data.shopPetFileDtoList[0].url} />
      </div>
      <div className='info_section'>
        <div className='name-wrapper'>{data.petName}</div>
        <div className='birth-wrapper'>{data.birth}</div>
      </div>
    </div>
  )
}

export default ShopAnimalListItem