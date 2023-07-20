import React from "react";
import { Route, Routes } from "react-router-dom";
import BoardPage from "./pages/BoardPage";
import LoginPage from "./pages/LoginPage";
import MainPage from "./pages/MainPage";
import ManagePage from "./pages/ManagePage";
import MyPage from "./pages/MyPage";
import StorePage from "./pages/StorePage";

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
      </Routes>
    </div>
  );
}

export default App;
