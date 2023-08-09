import CallIcon from "@mui/icons-material/Call";
import HomeIcon from "@mui/icons-material/Home";
import InstagramIcon from "@mui/icons-material/Instagram";
import AccessTimeIcon from "@mui/icons-material/AccessTime";
import DescriptionIcon from "@mui/icons-material/Description";
import PlaceIcon from "@mui/icons-material/Place";
import PetsIcon from "@mui/icons-material/Pets";

import Box from "@mui/material/Box";
import KakaoMap from "../../components/KakaoMap/KakaoMap";

import Typography from "@mui/material/Typography";
import "./ShopInfoPage.scoped.css";
import { Stack, Container } from "@mui/material";

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
          <Stack spacing={2}>
            <Typography
              variant="h5"
              sx={{ display: "flex", alignItems: "center", gap: "15px" }}
            >
              <PetsIcon />
              {shopTitle}
            </Typography>
            <hr />
            <Typography
              sx={{ display: "flex", alignItems: "center", gap: "15px" }}
            >
              <PlaceIcon />
              {address}
            </Typography>
            <Typography
              sx={{ display: "flex", alignItems: "center", gap: "15px" }}
            >
              <CallIcon />
              {phoneNo}
            </Typography>
            <Typography
              sx={{ display: "flex", alignItems: "top", gap: "15px" }}
              paragraph
            >
              <DescriptionIcon />
              {descriptions}
            </Typography>
            <Typography
              sx={{ display: "flex", alignItems: "center", gap: "15px" }}
            >
              <AccessTimeIcon />
              {openedTime} ~ {closedTime}
            </Typography>
            <Typography
              sx={{ display: "flex", alignItems: "center", gap: "15px" }}
            >
              <InstagramIcon />
              {sns}
            </Typography>
            <Typography
              sx={{ display: "flex", alignItems: "center", gap: "15px" }}
            >
              <HomeIcon />
              {homepage}
            </Typography>
          </Stack>
        </Box>

        <Container>
          <KakaoMap latitude={latitude} longitude={longitude} />
        </Container>
      </Stack>
    </div>
  );
};

export default ShopInfoPage;
