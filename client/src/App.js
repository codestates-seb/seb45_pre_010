import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./Reset.css";
import styled from "styled-components";

import Header from "./components/Header";
import Footer from "./components/Footer";
import QuestionList from "./pages/QuestionList";
import QuestionDetail from "./pages/QuestionDetail";
import Login from "./pages/login/Login";
import Write from "./pages/Write";
import SignUp from "./pages/signup/SignUp";
import Sidebar from "./pages/sidebar/Sidebar";
import { useState, useEffect } from "react";

function App() {
  const [isLogin , setIsLogin] = useState(false);
  const [token, setToken] = useState('');
  const [userInfo, setUserInfo] =useState('');

  useEffect(()=>{setUserInfo(token);
  },[token]);

  
   //백앤드와 연계시 가장먼저 바꿔야됨.!!

  
  return (
    <BrowserRouter>
      <Header isLogin={isLogin} setIsLogin={setIsLogin} setToken={setToken} setUserInfo={setUserInfo}/>
      {isLogin?(<Sidebar userInfo={userInfo} setUserInfo={setUserInfo}
      setIsLogin={setIsLogin} setToken={setToken} />):('')}
      <MainContainer>
        <Routes>
          <Route path="/" element={<QuestionList />} />
          <Route path="/login" element={<Login setIsLogin={setIsLogin} setToken={setToken}/>} />
          <Route path="/QuestionDetail" element={<QuestionDetail />} />          
          <Route path="/signup" element={<SignUp setIsLogin={setIsLogin} setToken={setToken} />}/>
          <Route path="/Write" element={<Write />} />          
        </Routes>
      </MainContainer>
      <Footer />
    </BrowserRouter>
  );
}

export default App;

const MainContainer = styled.main`
  min-height: calc(100vh - 50px);
  padding-top: 56px;
`;
