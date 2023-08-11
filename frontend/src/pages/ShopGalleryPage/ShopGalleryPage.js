import Typography from "@mui/material/Typography";
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader
import { Carousel } from "react-responsive-carousel";
import {
  Card,
  CardActionArea,
  CardContent,
  CardMedia,
  Stack,
} from "@mui/material";

const ShopGalleryPage = () => {
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
          <Card sx={{ maxWidth: 800 }}>
            <CardActionArea>
              <CardMedia
                component="img"
                height="360"
                image={content.url}
                alt={content.title}
              />
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  {content.desc}
                </Typography>
              </CardContent>
            </CardActionArea>
          </Card>
        </Stack>
      ))}
    </Carousel>
  );
};

export default ShopGalleryPage;
