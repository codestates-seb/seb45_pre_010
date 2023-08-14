import styled from "styled-components";
// import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

function QuestionList() {

  const navigate = useNavigate();

const userId = localStorage.getItem("Id");    // localStorage - 세션이 바뀌어도 저장한 데이터가 유지
                                              // getItem() - value 읽어 오기
const click = (e) => {
  e.preventDefault();                         // 기본 클릭 동작 방지

  if (userId === null) {
    let loginAlert = window.confirm (         // 선택창(confirm) 발생
      "게시물 등록 시 로그인이 필요합니다."
    );
    if(loginAlert){
      navigate("")
    }
  } else {
    navigate("")
  }
 
  
  };

  return (
  <Wrap>
    <div>
      <h1>All Questions</h1>
      <WriteButton onClock={click}>Ask Questions</WriteButton>
    </div>
    <div>
      <ListContainer>
        <div></div>
      </ListContainer>
    </div>
  </Wrap>
  );
  
};

export default QuestionList;

const Wrap = styled.div`

`;
const WriteButton = styled.button`

`;
const ListContainer = styled.div`

`;