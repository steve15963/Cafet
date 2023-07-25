import React from "react";
import "./App.css";
import { Route, Routes } from "react-router-dom";

import BoardDetail from "./pages/BoardDetail/BoardDetail";
import BoardPage from "./pages/BoardPage/BoardPage";
import LoginPage from "./pages/LoginPage/LoginPage";
import MainPage from "./pages/MainPage/MainPage";
import ManagePage from "./pages/ManagePage/ManagePage";
import MyPage from "./pages/MyPage/MyPage";
import StorePage from "./pages/StorePage/StorePage";
import TestPage from "./pages/TestPage/TestPage";

const App = () => {
  return (
    <div className="App">
      <Routes>
        <Route path="/boarddetail" element={<BoardDetail />} />
        <Route path="/boardpage" element={<BoardPage />} />
        <Route path="/loginpage" element={<LoginPage />} />
        <Route path="/" element={<MainPage />} />
        <Route path="/managepage" element={<ManagePage />} />
        <Route path="/mypage" element={<MyPage />} />
        <Route path="/storepage" element={<StorePage />} />
        <Route path="/testpage" element={<TestPage />} />
      </Routes>
    </div>
  );
};

export default App;
