import styled from "styled-components";
import { Link, useNavigate } from "react-router-dom";

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
        navigate("../")
      }
    } else {
      navigate("../")
    }
 
  
  };

  return (
  <Wrap>
    <div className="buttonContainer">
      <h1>All Questions</h1>
      <WriteButton onClock={click}>Ask Questions</WriteButton>
    </div>
    <div>
      <ListContainer>
          {/*.map((el,idx) => <key값 작성>)*/}
            <QuestionContainer >
              <div>
                <div>NO.</div>
                <div>질문 갯수</div>
              </div>
              <div className="contentContainer">
                <h3>title</h3>
                <div className="writerContainer">
                  {/*<img>프로필사진</img>*/}
                  <Link>
                    아이디
                  </Link>
                  <div>
                    날짜
                    {/*new Date(el.createdAt).toLocaleString("ko-KR")*/}
                  </div>
                </div>
              </div>
            </QuestionContainer>
      </ListContainer>
    </div>
  </Wrap>
  );
  
};

export default QuestionList;

const Wrap = styled.main`
  color: black;
  width: 73%;
  height: 100%;
  display: flex;
  flex-direction: column;
  position: relative;
  left: 230px;
  margin-top: 70px;
  padding: 30px;
  .buttonContainer {
    display: flex;
    justify-content: right;
    border-bottom: 1px solid #8c8c8c;
    height: 70px;
    > h1 {
      flex: 1;
      margin: 0;
    }
}
`;


const ListContainer = styled.div`
  display: flex;
  flex-direction: column;
  border-bottom: 1px solid #8c8c8c;
`;

const QuestionContainer = styled.div`
  display: flex;
  div:nth-child(1) {
    margin: auto 20px;
    text-align: center;
  }
  .contentContainer {
    width: 800px;
    h3 {
      flex-wrap: nowrap;
      color: #3C5A91;
      }
  }    
  .writerContainer {
    display: flex;
    justify-content: right;
    margin-bottom: 20px;
    align-items: end;
    a {
      color: #282828;
    }
    > div {
      color: #6e6e6e;
    }
  }
`;

const WriteButton = styled.button`
  height: 30px;
  line-height: 30px;
  border-radius: 6px;
  padding: 0 12px;
  background-color: #008efb;
`;