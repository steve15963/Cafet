import React, { useState } from "react";
import handleLogin from "../../utils/handleLogin/handleLogin";
import "./LoginForm.css";
import { useNavigate } from "react-router-dom";

const LoginForm = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const onLoginButtonClick = async () => {
    try {
      const response = await handleLogin(email, password);
      const token = response.data.token;
      console.log("Login success", token);
      navigate("/");
    } catch (error) {
      console.error("Login failed:");
      alert("로그인에 실패하셨습니다.");
      setEmail("");
      setPassword("");
    }
  };

  return (
    <div className="login-form">
      <input
        type="email"
        className="input-field"
        placeholder="Email"
        name="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <input
        type="password"
        className="input-field"
        placeholder="Password"
        name="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button className="login-button" onClick={onLoginButtonClick}>
        Login
      </button>
    </div>
  );
};

export default LoginForm;
