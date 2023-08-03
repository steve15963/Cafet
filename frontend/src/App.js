import React from "react";
import "./App.css";
import { Route, Routes } from "react-router-dom";

import BoardDetail from "./pages/BoardDetail/BoardDetail";
import BoardPage from "./pages/BoardPage/BoardPage";
import LoginPage from "./pages/LoginPage/LoginPage";
import MainPage from "./pages/MainPage/MainPage";
import InquiryForm from "./components/InquiryForm/InquiryForm";
import MainList from "./components/MainList/MainList";
import ManagePage from "./pages/ManagePage/ManagePage";
import MyPage from "./pages/MyPage/MyPage";
import StorePage from "./pages/StorePage/StorePage";
import TestPage from "./pages/TestPage/TestPage";
import CreatePage from "./pages/CreatePage/CreatePage";
import ManageUsers from "./components/ManageUsers/ManageUsers";
import ManageShops from "./components/ManageShops/ManageShops";
import ManageRequest from "./components/ManageRequests/ManageRequests";

const App = () => {
  return (
    <div className="App">
      <Routes>
        <Route path="/board/detail/:id" element={<BoardDetail />} />
        <Route path="/board" element={<BoardPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/login/:path" element={<LoginPage />} />
        <Route path="/" element={<MainPage />}>
          <Route path="" element={<MainList />} />
          <Route path="inquiry" element={<InquiryForm />} />
        </Route>
        <Route path="/manage" element={<ManagePage />}>
          <Route path="" element={<ManageUsers />} />
          <Route path="shops" element={<ManageShops />} />
          <Route path="requests" element={<ManageRequest />} />
        </Route>
        <Route path="/mypage" element={<MyPage />} />
        <Route path="/mypage/:path" element={<MyPage />} />
        <Route path="/store" element={<StorePage />} />
        <Route path="/test" element={<TestPage />} />
        <Route path="/create" element={<CreatePage />} />
      </Routes>
    </div>
  );
};

export default App;
