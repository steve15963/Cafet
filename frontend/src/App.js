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
import InquiryPage from "./pages/InquiryPage/InquiryPage";
import CreatePage from "./pages/CreatePage/CreatePage";

const App = () => {
  return (
    <div className="App">
      <Routes>
        <Route path="/board/detail/:id" element={<BoardDetail />} />
        <Route path="/board" element={<BoardPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/" element={<MainPage />} />
        <Route path="/manage" element={<ManagePage />} />
        <Route path="/mypage" element={<MyPage />} />
        <Route path="/store" element={<StorePage />} />
        <Route path="/test" element={<TestPage />} />
        <Route path="/inquiry" element={<InquiryPage />} />
        <Route path="/create" element={<CreatePage />} />
      </Routes>
    </div>
  );
};

export default App;
