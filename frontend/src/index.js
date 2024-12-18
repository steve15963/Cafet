import React from "react";
import "./index.css";
import ReactDOM from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import { CookiesProvider } from "react-cookie";

import App from "./App";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <CookiesProvider>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </CookiesProvider>
);
