import { useNavigate } from 'react-router-dom'

const KioskAnimalListItem = ({ data }) => {
  const navigate = useNavigate();

  const goToKioskDetailAnimal = () => {
    navigate(`/kiosk/animal/${data.shopPetId}`)
  }

  return (
    <div className='animalItem'>
      <div className='img_section' onClick={goToKioskDetailAnimal}>
        <img alt={data.petName} src={data.shopPetFileDtoList.url} />
      </div>
      <div className='info_section'>
        <div className='name-wrapper'>{data.petName}</div>
        <div className='birth-wrapper'>{data.birth}</div>
      </div>
    </div>
  );
}

export default KioskAnimalListItem
