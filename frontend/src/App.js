import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import BoardPage from "./pages/BoardPage";
import LoginPage from "./pages/LoginPage";
import MainPage from "./pages/MainPage";
import ManagePage from "./pages/ManagePage";
import MyPage from "./pages/MyPage";
import StorePage from "./pages/StorePage";

const App = () => {
  return (
    <Router>
      <Route path="/Board" exact>
        <BoardPage />
      </Route>
      <Route path="/LoginPage">
        <LoginPage />
      </Route>
      <Route path="/" exact>
        <MainPage />
      </Route>
      <Route path="/ManagePage">
        <ManagePage />
      </Route>
      <Route path="/MyPage">
        <MyPage />
      </Route>
      <Route path="/StorePage">
        <StorePage />
      </Route>
    </Router>
  );
};

export default App;
