import React, { useState } from "react";
import Header from "../components/layout/Header/Header";
import "./MainPage.css";
import Footer from "../components/layout/Footer/Footer";
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
    title: "고양이",
    thumbnail: "images/maincat.png",
  },
  {
    id: 1,
    title: "개",
    thumbnail: "images/maindog.png",
  },
  {
    id: 2,
    title: "토끼",
    thumbnail: "images/mainrabbit.png",
  },
  {
    id: 3,
    title: "친칠라",
    thumbnail: "images/mainchinchilla.png",
  },
  {
    id: 4,
    title: "개벽이",
    thumbnail: "images/mainwalldog.png",
  },
  {
    id: 5,
    title: "햄찌",
    thumbnail: "images/mainhamster.png",
  },
  {
    id: 6,
    title: "개죽이",
    thumbnail: "images/mainbamboodog.png",
  },
  {
    id: 7,
    title: "잉여",
    thumbnail: "",
  },
];

const MainPage = () => {
  const [cards, setCards] = useState(mockCards);
  return (
    <div>
      <Header />
      <div className="MainPage">
        <Masonry columns={3} spacing={2}>
          {cards.map((item, index) => (
            <div className="card">
              <div className="container">
                <h4>
                  <b>{item.title}</b>
                </h4>
              </div>
              <img
                src={`${item.thumbnail}?w=162&auto=format`}
                style={{ width: "100%", display: "block" }}
                loading="lazy"
                alt={item.title}
              />
            </div>
          ))}
        </Masonry>
      </div>
      <Footer />
    </div>
  );
};

export default MainPage;
