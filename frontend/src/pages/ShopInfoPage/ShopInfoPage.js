import CallIcon from "@mui/icons-material/Call";
import HomeIcon from "@mui/icons-material/Home";
import InstagramIcon from "@mui/icons-material/Instagram";
import AccessTimeIcon from "@mui/icons-material/AccessTime";
import DescriptionIcon from "@mui/icons-material/Description";
import PlaceIcon from "@mui/icons-material/Place";

import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemText from "@mui/material/ListItemText";
import ListItemAvatar from "@mui/material/ListItemAvatar";

import Box from "@mui/material/Box";
import KakaoMap from "../../components/KakaoMap/KakaoMap";

import "./ShopInfoPage.scoped.css";
import { Stack, Avatar } from "@mui/material";

const ShopInfoPage = ({
  shopId,
  shopTitle,
  totalScore,
  gradeCount,
  longitude,
  latitude,
  address,
  phoneNo,
  descriptions,
  openedTime,
  closedTime,
  sns,
  homepage,
}) => {
  // var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667);

  // // 마커를 생성합니다
  // var marker = new kakao.maps.Marker({
  //     position: markerPosition
  // });

  // // 마커가 지도 위에 표시되도록 설정합니다
  // marker.setMap(map);
  return (
    <div>
      <Stack direction="row" justifyContent="space-between" spacing={0}>
        <Box component="span" sx={{ p: 2, border: "1px dashed grey" }}>
          <List
            sx={{ width: "100%", maxWidth: 600, bgcolor: "background.paper" }}
          >
            <ListItem>
              <ListItemAvatar>
                <Avatar>
                  <PlaceIcon />
                </Avatar>
              </ListItemAvatar>
              <ListItemText primary="주소" secondary={address} />
            </ListItem>
            <ListItem>
              <ListItemAvatar>
                <Avatar>
                  <CallIcon />
                </Avatar>
              </ListItemAvatar>
              <ListItemText primary="연락처" secondary={phoneNo} />
            </ListItem>
            <ListItem>
              <ListItemAvatar>
                <Avatar>
                  <AccessTimeIcon />
                </Avatar>
              </ListItemAvatar>
              <ListItemText
                primary="영업시간"
                secondary={`${openedTime} ~ ${closedTime}`}
              />
            </ListItem>
            <ListItem>
              <ListItemAvatar>
                <Avatar>
                  <InstagramIcon />
                </Avatar>
              </ListItemAvatar>
              <ListItemText primary="SNS" secondary={sns} />
            </ListItem>
            <ListItem>
              <ListItemAvatar>
                <Avatar>
                  <HomeIcon />
                </Avatar>
              </ListItemAvatar>
              <ListItemText primary="홈페이지" secondary={homepage} />
            </ListItem>
            <ListItem>
              <ListItemAvatar>
                <Avatar>
                  <DescriptionIcon />
                </Avatar>
              </ListItemAvatar>
              <ListItemText primary="설명" secondary={descriptions} />
            </ListItem>
          </List>
        </Box>
        <KakaoMap latitude={latitude} longitude={longitude} />
      </Stack>
    </div>
  );
};

export default ShopInfoPage;
