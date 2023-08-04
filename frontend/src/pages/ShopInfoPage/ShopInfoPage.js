import CallIcon from '@mui/icons-material/Call';
import HomeIcon from '@mui/icons-material/Home';
import InstagramIcon from '@mui/icons-material/Instagram';
import AccessTimeIcon from '@mui/icons-material/AccessTime';
import DescriptionIcon from '@mui/icons-material/Description';
import PlaceIcon from '@mui/icons-material/Place';
import MapIcon from '@mui/icons-material/Map';
import PetsIcon from '@mui/icons-material/Pets';

import Box from '@mui/material/Box';
import KakaoMap from '../../components/KakaoMap/KakaoMap';

import Typography from '@mui/material/Typography';


const ShopInfoPage = ({shopId, shopTitle, totalScore, gradeCount, longitude, latitude, address, phoneNo, descriptions, openedTime, closedTime, sns, homepage}) => {
  return (
    <div>
      <h2>
        <PetsIcon />
        {shopTitle}
      </h2>
      <div>
        <MapIcon></MapIcon>
        <KakaoMap latitude={latitude} longitude={longitude} />
      </div>
      <div>
      <Typography sx={{ display: "flex", alignItems: "center"}}>
        <PlaceIcon />
        오시는 길
      </Typography>
      </div>
      <Box sx={{ display: "flex", alignItems:"center"}}>
        <Typography sx={{ display: "flex", alignItems: "center" }}>
          <CallIcon /> 
          {phoneNo}
        </Typography>
      </Box>
      <div>
        <DescriptionIcon /> {descriptions}
      </div>
      <div>
        < AccessTimeIcon />{openedTime} ~ {closedTime}
      </div>
      <div>
        <InstagramIcon />{sns}
      </div>
      <div>
        <HomeIcon />{homepage}
      </div>
    </div>
  );
}

export default ShopInfoPage