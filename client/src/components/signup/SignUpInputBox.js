import {
  SignUpContainer,
  DisplayNameLable,
  DisplayNameInput,
  SignUpUserIdLable,
  SignUpUserIdInput,
  SignUpPasswordLable,
  SignUpPasswordInput,
  SignUpButtonContainer,
  SignUpButton,
} from "./SignUpInputBox.styled";
import { useState, useRef } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";


function SignUpInputBox({ setIsLogin, setToken }) {
  const navigate = useNavigate();
  const passwordRef = useRef("");
  const [displayName, setDisplayName] = useState("");
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");
  const [errorNickMessage, setErrorNickMessage] = useState("");
  const [errorUserIdMessage, setErrorUserIdMessage] = useState("");
  const [errorPasswordMessage, setErrorPasswordMEssage] = useState("");

  //const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
  //emailPattern.test(string값)  리턴값으로 boolean   혹시 필요할지도 모르니 남겨둠

  const displayNameHandler = (e) => {
    setDisplayName(e.target.value);
    if (errorNickMessage) {
      setErrorNickMessage("");
    }
  };

  const userIdHandler = (e) => {
    setUserId(e.target.value);
    if (errorUserIdMessage) {
      setErrorUserIdMessage("");
    }
  };

  const passwordHandler = (e) => {
    setPassword(e.target.value);
    if (errorPasswordMessage) {
      setErrorPasswordMEssage("");
    }
  };

  const signUpcConfirmHandler = async (e) => {
    e.preventDefault();
    const temp = userId.slice(userId.length - 10);
    if (userId.length < 11 && temp !== "@naver.com" && temp !== "@gmail.com") {
      setErrorUserIdMessage("올바른 id형식이 아닙니다.");
      if (passwordRef.current) {
        passwordRef.current.value = "";
      }
    } else if (password === "" || !(password.length >= 8 && /\d/.test(password))) {
      setErrorPasswordMEssage("올바른 pw형식이 아닙니다.");
      if (passwordRef.current) {
        passwordRef.current.value = "";
      }
    } else if (displayName === "") {
      setErrorNickMessage("닉네임을 입력하세요");
    } else {
      //'http://localhost:8080/users/signin'
      //'http://localhost:4000/signup'

      try {
        const res = await axios.post("http://localhost:8080/users/signin", {
          nickname: displayName,
          email: userId,
          password: password,
        });
        const token = res.data;
        setIsLogin(true);
        setToken(token);
        console.log(token);
        navigate("/");
      } catch (error) {
        console.log(error.response.data);
      }
      setDisplayName("");
      setUserId("");
      setPassword("");
      //console.log(userList)
    }
  };

  return (
    <SignUpContainer>
      <DisplayNameLable>Display Name</DisplayNameLable>
      <DisplayNameInput type="text" placeholder="닉네임을 입력하세요" onChange={(e) => displayNameHandler(e)} />
      {errorNickMessage ? (
        <div style={{ fontSize: "10px", color: "red", width: "80%" }}>{errorUserIdMessage}</div>
      ) : (
        <div></div>
      )}
      <SignUpUserIdLable>Email</SignUpUserIdLable>
      <SignUpUserIdInput type="userId" onChange={(e) => userIdHandler(e)} />
      {errorUserIdMessage ? (
        <div style={{ fontSize: "10px", color: "red", width: "80%" }}>{errorUserIdMessage}</div>
      ) : (
        <div style={{ fontSize: "10px", width: "80%" }}>gmail과 naver형식으로 입력하세요</div>
      )}
      <SignUpPasswordLable>Password</SignUpPasswordLable>
      <SignUpPasswordInput type="password" ref={passwordRef} onChange={(e) => passwordHandler(e)} />
      {errorPasswordMessage ? (
        <div style={{ fontSize: "10px", color: "red", width: "80%" }}>{errorPasswordMessage}</div>
      ) : (
        <div style={{ fontSize: "10px", width: "80%" }}>대소문자 구분없이 숫자 조합 8글자이상</div>
      )}
      <SignUpButtonContainer>
        <SignUpButton onClick={(e) => signUpcConfirmHandler(e)}>Sign up</SignUpButton>
      </SignUpButtonContainer>
    </SignUpContainer>
  );
}

export default SignUpInputBox;
