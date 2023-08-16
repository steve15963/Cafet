import './SearchCard.scoped.css'

import { useNavigate } from 'react-router-dom';
import StarIcon from '@mui/icons-material/Star';
import { yellow } from '@mui/material/colors';


const SearchCard = ({ shopId, shopTitle, gradeCount, address, phoneNo }) => {

  const navigate = useNavigate();

  const goToShop = (shopId) => {
    navigate(`/shop/${shopId}`)
  }

  return (
    <div className="card-wrapper" onClick={() => goToShop(shopId)}>
      <div className="card red">
        <p className="tip">{shopTitle}</p>
        <p className="second-text"><StarIcon sx={{ color: yellow[700] }} fontSize="string" />{gradeCount}점</p>
        <p className="second-text">{phoneNo}</p>
        <p className="second-text">{address}</p>
      </div>
    </div>
  )
}

export default SearchCard