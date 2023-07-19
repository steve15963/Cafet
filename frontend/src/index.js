import React from "react";
import ReactDOM from "react-dom";
<<<<<<< HEAD
import Header from "./common/Header";
import Footer from "./common/Footer";
// import "bootstrap/dist/css/bootstrap.min.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

// ReactDOM.render(<Header />, document.getElementById("root"));
ReactDOM.render(<Footer />, document.getElementById("root"));
=======
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter as Router } from "react-router-dom";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <Router>
      <App />
    </Router>
  </React.StrictMode>
);

reportWebVitals();
>>>>>>> f0c92d2cf114f31c0889811e482dc39d871b2172
