import React from "react";
import "./App.css";
import { Route, Routes } from "react-router-dom";

import BoardPage from "./pages/BoardPage";
import LoginPage from "./pages/LoginPage";
import MainPage from "./pages/MainPage";
import ManagePage from "./pages/ManagePage";
import MyPage from "./pages/MyPage";
import StorePage from "./pages/StorePage";
import TestPage from "./pages/TestPage";

const App = () => {
  return (
    <div className="App">
      <Routes>
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
