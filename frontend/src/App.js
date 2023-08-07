import React from "react";
import "./App.css";
import { Route, Routes } from "react-router-dom";

import BoardDetail from "./pages/BoardDetail/BoardDetail";
import BoardPage from "./pages/BoardPage/BoardPage";
import LoginPage from "./pages/LoginPage/LoginPage";
import LoginForm from "./components/LoginForm/LoginForm";
import SignUpForm from "./components/SignUpForm/SignUpForm";
import EmailCheckForm from "./components/EmailCheckForm/EmailCheckForm";
import RePasswordForm from "./components/RePassword/RePassword";
import MainPage from "./pages/MainPage/MainPage";
import MainList from "./components/MainList/MainList";
import InquiryForm from "./components/InquiryForm/InquiryForm";
import ManagePage from "./pages/ManagePage/ManagePage";
import ManageUsers from "./components/ManageUsers/ManageUsers";
import ManageShops from "./components/ManageShops/ManageShops";
import ManageRequest from "./components/ManageRequests/ManageRequests";
import MyPage from "./pages/MyPage/MyPage";
import AccountData from "./components/AccountData/AccountData";
import AccountModify from "./components/AccountModify/AccountModify";
import ShopPage from "./pages/ShopPage/ShopPage";
import TestPage from "./pages/TestPage/TestPage";
// import AnimalList from "./pages/AnimalListPage/AnimalListPage";
// import AnimalDetail from "./pages/AnimalDetailPage/AnimalDetailPage";
import ShopInfoPage from "./pages/ShopInfoPage/ShopInfoPage";
import CreatePage from "./pages/CreatePage/CreatePage";
import ManageRequestDetail from "./components/ManageRequestDetail/ManageRequestDetail";
import ManageRequestList from "./components/ManageRequestList/ManageRequestList";

const App = () => {
  return (
    <div className="App">
      <Routes>
        <Route path="/board/detail/:id" element={<BoardDetail />} />
        <Route path="/board" element={<BoardPage />} />
        <Route path="/login" element={<LoginPage />}>
          <Route path="" element={<LoginForm />} />
          <Route path="signup" element={<SignUpForm />} />
          <Route path="password" element={<EmailCheckForm />} />
          <Route path="repassword" element={<RePasswordForm />} />
        </Route>
        <Route path="/" element={<MainPage />}>
          <Route path="" element={<MainList />} />
          <Route path="inquiry" element={<InquiryForm />} />
        </Route>
        <Route path="/manage" element={<ManagePage />}>
          <Route path="" element={<ManageUsers />} />
          <Route path="shops" element={<ManageShops />} />
          <Route path="requests" element={<ManageRequest />}>
            <Route path="" element={<ManageRequestList />} />
          </Route>
          <Route path="requests/:id" element={<ManageRequestDetail />} />
        </Route>
        <Route path="/mypage" element={<MyPage />}>
          <Route path="" element={<AccountData />} />
          <Route path="modify" element={<AccountModify />} />
        </Route>
        <Route path="/shop" element={<ShopPage />} />
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
        {/* <Route path="/shop/animal" element={<AnimalList />} />
        <Route path="/shop/animal/:id" element={<AnimalDetail />} /> */}
        <Route path="/shop/animal/:id/info" element={<ShopInfoPage />} />
        <Route path="/test" element={<TestPage />} />
        <Route path="/create" element={<CreatePage />} />
        <Route path="/test" element={<TestPage />} />
      </Routes>
    </div>
  );
};

export default App;
