import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./Reset.css";
import styled from "styled-components";

import Header from "./components/Header";
import Footer from "./components/Footer";
import QuestionList from "./pages/QuestionList";
import QuestionDetail from "./pages/QuestionDetail";
import Login from "./pages/login/Login";
import Write from "./pages/Write";

function App() {
  return (
    <BrowserRouter>
      <Header />
      <MainContainer>
        <Routes>
          <Route path="/" element={<QuestionList />} />
          <Route path="/QuestionDetail" element={<QuestionDetail />} />
          <Route path="/login" element={<Login />} />
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
