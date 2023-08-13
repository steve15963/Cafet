import { useState } from "react";
import { useParams } from "react-router-dom";

import InfoIcon from '@mui/icons-material/Info';
import BlurOnIcon from '@mui/icons-material/BlurOn';

// import {
//   Box,
// } from "@mui/material";

import './KioskAnimalDetailPage.scoped.css'
import KioskHeatmap from "../../components/KioskHeatmap/KioskHeatmap";
import KioskAnimalInfo from "../../components/KioskAnimalInfo/KioskAnimalInfo";

const KioskAnimalDetailPage = () => {

  // 버튼 클릭 시 보여줄 것
  const [visibleInfo, setVisibleInfo] = useState(true);
  const [visibleHeat, setVisibleHeat] = useState(false);

  const { animalId } = useParams();
  
  const onClickInfo = () => {
    setVisibleInfo(true)
    setVisibleHeat(false)
  }

  const onClickHeat = () => {
    setVisibleInfo(false)
    setVisibleHeat(true)
  }

  return (
    <div>
      <div className="icons" style={{marginTop: '10px', marginBottom: '10px'}}>
        <InfoIcon onClick={onClickInfo}
                  className='InfoIcon' fontSize="large" 
                  style={{marginLeft: '20px', marginRight: '20px'}} />
        <BlurOnIcon onClick={onClickHeat}
                    className="BlurOnIcon" fontSize="large" />
      </div>
      <div>
        {visibleInfo && <KioskAnimalInfo id={animalId}/>}
        {visibleHeat && <KioskHeatmap id={animalId} />}
      </div>
    </div>
  )
}

export default KioskAnimalDetailPage;