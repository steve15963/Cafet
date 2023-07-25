import React, { useState } from "react";
import "./MainPage.css";
import Header from "../../components/Header/Header";
import Footer from "../../components/Footer/Footer";
// import Box from "@mui/material/Box";
import Paper from "@mui/material/Paper";
import Masonry from "@mui/lab/Masonry";
import { styled } from "@mui/material/styles";

const Label = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === "dark" ? "#1A2027" : "#fff",
  ...theme.typography.body2,
  padding: theme.spacing(0.5),
  textAlign: "center",
  color: theme.palette.text.secondary,
  borderBottomLeftRadius: 0,
  borderBottomRightRadius: 0,
}));

const mockCards = [
  {
    id: 0,
    boardTitle: "고양이를 키우면 장점",
    thumbnail: "images/main/cat.png",
    boardContent:
      "고양이를 키우면 장점이 뭐냐구요? 귀엽습니다! 요 싸가지없는 눈빛, 사악한 이빨, 늘씬한 각선미...",
  },
  {
    id: 1,
    boardTitle: "개",
    thumbnail: "images/main/dog.png",
    boardContent: "Wow so scare Concern Many text Cute animals Wow",
  },
  {
    id: 2,
    boardTitle: "토끼가 강한 이유",
    thumbnail: "images/main/rabbit.png",
    boardContent: "깡도 있고 총도 있기 때문이다",
  },
  {
    id: 3,
    boardTitle: "친칠라",
    thumbnail: "images/main/chinchilla.png",
    boardContent:
      "친칠라(Chinchilla)는 남아메리카의 안데스 산맥에 서식하는 천축서소목(parvorder Caviomorpha)의 설치류이다. '친칠라'라는 이름은 안데스 산맥에 거주하면서 모피를 깔개로 썼던 '친차'족(Chinchas)에서 유래하였다. 19세기 말까지 모피를 구하기 위한 사냥으로 개체수가 급감했다. 하위종 모두 국제자연보전연맹(IUCN) 적색목록에 멸종위기종으로 등재되어 있다.야생에서의 관측이 쉽지 않은 종으로 그나마 긴꼬리친칠라가 간혹 관측된다. 긴꼬리친칠라는 애완용으로 개량하여 판매하고 있다.",
  },
  {
    id: 4,
    boardTitle: "벽에 끼인 개",
    thumbnail: "images/main/walldog.png",
    boardContent: "이후 스태프가 맛있게 먹었습니다",
  },
  {
    id: 5,
    boardTitle: "강아지 훈육하기",
    thumbnail: "",
    boardContent: "짐승은 매가 약이라고 생각하신다면 반만 맞는 말입니다.",
  },
  {
    id: 6,
    boardTitle: "햄찌",
    thumbnail: "images/main/hamster.png",
    boardContent: "귀여운 햄스터다",
  },
  {
    id: 7,
    boardTitle: "개죽이",
    thumbnail: "images/main/bamboodog.png",
    boardContent:
      "개죽이는 막대기를 쥐어주면 움켜쥐었다. 특히나 높은 곳에선 무엇이든 매달리려는 힘이 대단했다. 그게 신기해서 앞마당에 있는 대나무에 매달려 있는 사진을 찍게 됐고, 그것이 디시인사이드 등 인터넷에 퍼지면서 네티즌들로부터 '개죽이'라는 이름을 얻게 됐다.",
  },
  {
    id: 8,
    boardTitle: "냥타벅스 후기 씁니다",
    thumbnail: "a.png",
    boardContent:
      "커피가 맛있습니다 그런데 고양이들은 사람한테 전혀 관심이 없어 보이네요.",
  },
  {
    id: 9,
    boardTitle: "강아징",
    thumbnail: "images/main/puppy.png",
    boardContent: "귀여워 멍멍",
  },
  {
    id: 10,
    boardTitle: "검은 고양이",
    thumbnail: "images/main/blackcat.png",
    boardContent: "외곽이 안보여요 ㅋㅋ",
  },
  {
    id: 11,
    boardTitle: "아기토끼",
    thumbnail: "images/main/babyrabbit.png",
    boardContent: "너무 귀여워요",
  },
  {
    id: 11,
    boardTitle: "오리새끼들",
    thumbnail: "images/main/ducklings.png",
    boardContent: "오리꽦꽦 병아리 삐악삐악",
  },
  {
    id: 12,
    boardTitle: "살려줘요",
    thumbnail: "images/main/wooddog.png",
    boardContent: "이 나무판자에 갇혔어요",
  },
];

const MainPage = () => {
  const [cards, setCards] = useState(mockCards);

  return (
    <div style={{ backgroundColor: "#fdfdfd" }}>
      <Header />
      <div className="MainPage">
        <Masonry columns={3} spacing={2}>
          {cards.map((item) => (
            <div class="card-container">
              <div class="card">
                <div class="front-content">
                  <img
                    src={`${item.thumbnail}?auto=format`}
                    alt={item.title}
                    onError={(e) => (e.target.style.display = "none")}
                    // onError="this.style.display='none"
                    //e.target.src = "images/main/noimage.png"
                    loading="lazy"
                  />
                  {/* <p>&nbsp;</p> */}
                </div>
                <div class="content">
                  <p class="heading">{item.boardTitle}</p>
                  <p>{item.boardContent}</p>
                </div>
              </div>
            </div>
          ))}
        </Masonry>
      </div>
      <Footer />
    </div>
  );
};

export default MainPage;
