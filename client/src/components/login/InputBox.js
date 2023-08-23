import {
  InputBoxContainer,
  InputForm,
  UserIdText,
  UserIdContainer,
  InputUserId,
  PasswordText,
  PasswordContainer,
  InputPassword,
  ConfirmButtonContainer,
  ConfirmButton,
} from "./InputBox.styled";
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
axios.defaults.withCredentials = true;
function InputBox({ setIsLogin, setToken }) {
  const navigate = useNavigate();
  const [userId, setuserId] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const userIdHandler = (e) => {
    setuserId(e.target.value);
  };

  const passwordHandler = (e) => {
    setPassword(e.target.value);
  };

  const loginHandler = async (e) => {
    e.preventDefault();
    try {
      //"http://localhost:8080/users/login"
      const res = await axios.post("http://localhost:8080/login", { email:userId, password:password });
      const token = res.data;
      console.log(token);
      setToken(token);
      setIsLogin(true);
      navigate("/");
    } catch (error) {
      setErrorMessage("ID와 PW를 확인하세요");
    }
  };

  return (
    <InputBoxContainer>
      <InputForm>
        <UserIdText>Email</UserIdText>
        <UserIdContainer>
          <InputUserId type="text" onChange={(e) => userIdHandler(e)} />
        </UserIdContainer>
        <PasswordText>Password</PasswordText>
        <PasswordContainer>
          <InputPassword type="password" onChange={(e) => passwordHandler(e)} />
        </PasswordContainer>
        <ConfirmButtonContainer>
          <ConfirmButton onClick={(e) => loginHandler(e)}>Login</ConfirmButton>
        </ConfirmButtonContainer>
        {errorMessage ? (
          <div style={{ color: "red", fontSize: "10px" }}>{errorMessage}</div>
        ) : (
          <div style={{ fontSize: "10px" }}>id와 pw를 입력하세요</div>
        )}
      </InputForm>
    </InputBoxContainer>
  );
}

export default InputBox;
