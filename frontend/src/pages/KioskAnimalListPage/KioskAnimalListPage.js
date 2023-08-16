import { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader
import { Carousel } from "react-responsive-carousel";
import {
  Card,
  CardActionArea,
  CardMedia,
  Stack,
} from "@mui/material";

const KioskAnimalListPage = () => {
  const navigate = useNavigate();
  //eslint-disable-next-line
  const shopId = localStorage.getItem("userId");
  //eslint-disable-next-line
  const [animalList, setAnimalList] = useState([])
  useEffect(() => {
    axios.get(`https://i9a105.p.ssafy.io/api/shop/${1}`)
      .then(function(res) {
        setAnimalList(res.data.shopPetList)
      })
      .catch((err) => console.log(err))
  }, [])

  const goToDetailAnimal = (id) => {
    navigate(`/kiosk/animal/${id}`)
  }

  const stepFourCarousel = [
    {
      title: "2004",
      url: "/images/main/babyrabbit.png",
      desc: "a baby rabbit",
    },
    {
      title: "2005",
      url: "/images/main/blackcat.png",
      desc: "a black cat",
    },
    {
      title: "2010",
      url: "/images/main/dog.png",
      desc: "the origin of the doge meme",
    },
    {
      title: "2020",
      url: "/images/main/ducklings.png",
      desc: "cute ducklings",
    },
  ];
  return (
    <Carousel
      showArrows={true}
      centerMode={true}
      centerSlidePercentage={50}
      showThumbs={false}
      showStatus={false}
      autoPlay={true}
      infiniteLoop={true}
    >
      {stepFourCarousel.map((content) => (
        <Stack mr={3}>
          <Card sx={{ maxWidth: 800 }} onClick={() => goToDetailAnimal(1)} >
            <CardActionArea>
              <CardMedia
                component="img"
                height="360"
                image={content.url}
                alt={content.title}
              />
              {/* <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  {content.petName}
                </Typography>
              </CardContent> */}
            </CardActionArea>
          </Card>
        </Stack>
      ))}
    </Carousel>
  );
}

export default KioskAnimalListPage;
