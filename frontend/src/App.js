import React from "react";
import "./App.css";
import { Route, Routes } from "react-router-dom";

import BoardDetail from "./pages/BoardDetail/BoardDetail";
import BoardPage from "./pages/BoardPage/BoardPage";
import LoginPage from "./pages/LoginPage/LoginPage";
import LoginForm from "./components/LoginForm/LoginForm";
import SignUpForm from "./components/SignUpForm/SignUpForm";
import EmailCheckForm from "./components/EmailCheckForm/EmailCheckForm";
import MainPage from "./pages/MainPage/MainPage";
import MainList from "./components/MainList/MainList";
import Rule from "./components/Rule/Rule";
import InquiryForm from "./components/InquiryForm/InquiryForm";
import ManagePage from "./pages/ManagePage/ManagePage";
import ManageUsers from "./components/Manage/ManageUsers";
import ManageShops from "./components/Manage/ManageShops";
import ManageInquiry from "./components/Manage/ManageInquiry";
import MyPage from "./pages/MyPage/MyPage";
import AccountData from "./components/AccountData/AccountData";
import AccountModify from "./components/AccountModify/AccountModify";
import ShopPage from "./pages/ShopPage/ShopPage";
import TestPage from "./pages/TestPage/TestPage";
// import AnimalList from "./pages/AnimalListPage/AnimalListPage";
import ShopAnimalDetailPage from "./components/ShopAnimalDetailPage/ShopAnimalDetailPage";
import ShopInfoPage from "./pages/ShopInfoPage/ShopInfoPage";
import CreatePage from "./pages/CreatePage/CreatePage";
import ManageInquiryDetail from "./components/Manage/ManageInquiryDetail";
// import ManageInquiryList from "./components/ManageRequestList/ManageRequestList";
import SearchShopPage from "./pages/SearchShopPage/SearchShopPage";
import KioskMain from "./pages/KioskMain/KioskMain";
import KioskLogin from "./components/KioskLogin/KioskLogin";
import KioskNameList from "./components/KioskNameList/KioskNameList";
import OrderCheckPage from "./OrderCheckPage/OrderCheckPage";
import MenuPostPage from "./MenuPostPage/MenuPostPage";
import KioskAnimalListPage from "./pages/KioskAnimalListPage/KioskAnimalListPage";
import OnePage from "./OrderPage/OnePage";
import KioskAnimalDetailPage from "./pages/KioskAnimalDetailPage/KioskAnimalDetailPage";
import PrivacyPolicy from "./components/PrivacyPolicy/PrivacyPolicy";
import KioskRegist from "./components/KioskRegist/KioskRegist";
import LiveMap from "./LiveMap/LiveMap.js";
import KioskManage from "./KioskManagePage/KioskManage";

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
        </Route>
        <Route path="/" element={<MainPage />}>
          <Route path="" element={<MainList />} />
          <Route path="rule" element={<Rule />} />
          <Route path="privacypolicy" element={<PrivacyPolicy />} />
          <Route path="inquiry" element={<InquiryForm />} />
        </Route>
        <Route path="/manage" element={<ManagePage />}>
          <Route path="" element={<ManageUsers />} />
          <Route path="shops" element={<ManageShops />} />
          <Route path="inquiry">
            <Route path="" element={<ManageInquiry />} />
            <Route path=":id" element={<ManageInquiryDetail />} />
          </Route>
        </Route>
        <Route path="/mypage" element={<MyPage />}>
          <Route path=":userId" element={<AccountData />} />
          <Route path="modify" element={<AccountModify />} />
        </Route>
        <Route path="/shop/:shopId" element={<ShopPage />} />
        <Route path="/shop/:shopId/:petId" element={<ShopAnimalDetailPage />} />
        <Route path="/animal/:id/info" element={<ShopInfoPage />} />
        <Route path="create">
          <Route path="" element={<CreatePage />} />
          <Route path=":id" element={<CreatePage />} />
        </Route>
        <Route path="/test" element={<TestPage />} />
        <Route path="/search" element={<SearchShopPage />} />
        <Route path="/kiosk" element={<KioskMain />}>
          <Route path="" element={<KioskLogin />} />
          <Route path="manage/:shopId" element={<KioskManage />} />
          <Route path="manage/:shopId/post" element={<MenuPostPage />} />
          <Route path="manage/:shopId/check" element={<OrderCheckPage />} />
          <Route path="list" element={<KioskNameList />} />
          <Route path="first" element={<KioskRegist />} />
          <Route path="menu/buy/:shopId/:tableId" element={<OnePage />} />
          <Route path="animal" element={<KioskAnimalListPage />}>
            {/* <Route path=":animalId" element={<KioskAnimalDetailPage />} /> */}
          </Route>
        </Route>
        <Route
          path="/kiosk/animal/:animalId"
          element={<KioskAnimalDetailPage />}
        />
        <Route path="/livemap" element={<LiveMap />}></Route>
      </Routes>
    </div>
  );
};

export default App;
