import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./Reset.css";
import styled from "styled-components";

import Login from "./pages/login/Login"
import Header from "./components/Header";
import Footer from "./components/Footer";

function App() {
  return (
    <BrowserRouter>
      <Header />
      <MainContainer>
        <Routes>
          <Route path='/login' element={<Login />} /> 
          {/* <Route path="/" element={<Main />} /> */}</Routes>
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
