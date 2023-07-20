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

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/BoardPage" element={<BoardPage />} />
        <Route path="/LoginPage" element={<LoginPage />} />
        <Route path="/" element={<MainPage />} />
        <Route path="/ManagePage" element={<ManagePage />} />
        <Route path="/MyPage" element={<MyPage />} />
        <Route path="/StorePage" element={<StorePage />} />
        <Route path="/TestPage" element={<TestPage />} />
      </Routes>
    </div>
  );
}

export default App;
