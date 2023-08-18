import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

import KioskHeatmap from "../../components/KioskHeatmap/KioskHeatmap";

import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';

import DescriptionIcon from '@mui/icons-material/Description';
import CakeIcon from '@mui/icons-material/Cake';
import PersonIcon from '@mui/icons-material/Person';
import PetsIcon from '@mui/icons-material/Pets';
import TodayIcon from '@mui/icons-material/Today';

import { green } from '@mui/material/colors';

const KioskAnimalDetailPage = () => {

  const [ detailAnimal, setDetailAnimal ] = useState([])

  const { animalId } = useParams();

  
  useEffect(() => {
    axios.get(`https://i9a105.p.ssafy.io/api/shopPet/${animalId}`)
      .then((res) => {
        setDetailAnimal(res.data)
      })
      .catch()
  }, [animalId])

  return (
    <div>
      <div className="info-wrapper">
        <List sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
          <ListItem>
            <ListItemAvatar>
              <Avatar sx={{ bgcolor: green[500] }}>
                <PetsIcon />
              </Avatar>
            </ListItemAvatar>
            <ListItemText primary="이름" 
                          secondary={detailAnimal.petName} />
          </ListItem>
          <ListItem>
            <ListItemAvatar>
              <Avatar sx={{ bgcolor: green[500] }}>
                <DescriptionIcon />
              </Avatar>
            </ListItemAvatar>
            <ListItemText primary="특징" 
                          secondary={detailAnimal.description} />
          </ListItem>
          <ListItem>
            <ListItemAvatar>
              <Avatar sx={{ bgcolor: green[500] }}>
                <CakeIcon />
              </Avatar>
            </ListItemAvatar>
            <ListItemText primary="생일"
                          secondary={detailAnimal.birth} />
          </ListItem>
          <ListItem>
            <ListItemAvatar>
              <Avatar sx={{ bgcolor: green[500] }}>
                <TodayIcon />
              </Avatar>
            </ListItemAvatar>
            <ListItemText primary="나이"
                          secondary={detailAnimal.petAge} />
          </ListItem>
          <ListItem>
            <ListItemAvatar>
              <Avatar sx={{ bgcolor: green[500] }}>
                <PersonIcon />
              </Avatar>
            </ListItemAvatar>
            <ListItemText primary="성별" secondary={detailAnimal.gender} />
          </ListItem>
        </List>
      </div>
      <div className="heatmap-section">
        <h4>자주 있는 장소</h4>
        <KioskHeatmap id={animalId} /> 
      </div>
    </div>
  )
}

export default KioskAnimalDetailPage;