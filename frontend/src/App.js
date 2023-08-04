import React from "react";
import "./App.css";
import { Route, Routes } from "react-router-dom";

import BoardDetail from "./pages/BoardDetail/BoardDetail";
import BoardPage from "./pages/BoardPage/BoardPage";
import LoginPage from "./pages/LoginPage/LoginPage";
import MainPage from "./pages/MainPage/MainPage";
import ManagePage from "./pages/ManagePage/ManagePage";
import MyPage from "./pages/MyPage/MyPage";
import ShopPage from "./pages/ShopPage/ShopPage";
import TestPage from "./pages/TestPage/TestPage";
import AnimalList from "./pages/AnimalListPage/AnimalListPage";
import AnimalDetail from "./pages/AnimalDetailPage/AnimalDetailPage";
import ShopInfoPage from "./pages/ShopInfoPage/ShopInfoPage";
import InquiryPage from "./pages/InquiryPage/InquiryPage";
import CreatePage from "./pages/CreatePage/CreatePage";

const App = () => {
  return (
    <div className="App">
      <Routes>
        <Route path="/board/detail/:id" element={<BoardDetail />} />
        <Route path="/board" element={<BoardPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/login/:path" element={<LoginPage />} />
        <Route path="/" element={<MainPage />} />
        <Route path="/:path" element={<MainPage />} />
        <Route path="/manage" element={<ManagePage />} />
        <Route path="/manage/:path" element={<ManagePage />} />
        <Route path="/manage/:path/:id" element={<ManagePage />} />
        <Route path="/mypage" element={<MyPage />} />
        <Route path="/mypage/:path" element={<MyPage />} />
        <Route path="/shop/:shopId" element={<ShopPage />} />
        <Route path="/shop/animal" element={<AnimalList />} />
        <Route path="/shop/animal/:id" element={<AnimalDetail />} />
        <Route path="/shop/animal/:id/info" element={<ShopInfoPage />} />
        <Route path="/test" element={<TestPage />} />
        <Route path="/inquiry" element={<InquiryPage />} />
        <Route path="/create" element={<CreatePage />} />
      </Routes>
    </div>
  );
};

export default App;
