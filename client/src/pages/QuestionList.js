import styled from "styled-components";
import { useState, useEffect } from "react";
import { useNavigate, useParams, Link } from "react-router-dom";
import { readData } from "../api/questionAPI";
import Pagination from "./Pagination";

function QuestionList() {
  const [list, setList] = useState("");
  const [PageInfo, setPageInfo] = useState();
  const navigate = useNavigate();
  const { page } = useParams(); //현재 라우팅의 파라미터를 가져와서 page 변수에 할당
  // 현재 페이지의 정보가 추출

  const readPage = async (el) => {
    const { data } = await readData(el); //파라미터 el을 사용하여 readData 함수를 호출
    setList(data.data); //리스트 업데이트
    setPageInfo(data.pageInfo); //페이지정보 업데이트
  };

  const userId = localStorage.getItem("Id"); // localStorage - 세션이 바뀌어도 저장한 데이터가 유지
  // getItem() - value 읽어 오기
  const click = (e) => {
    e.preventDefault(); // 기본 클릭 동작 방지
    if (userId === null) {
      let loginAlert = window.confirm(
        // 선택창(confirm) 발생
        "게시물 등록 시 로그인이 필요합니다."
      );
      if (loginAlert) {
        navigate("../login");
      }
    } else {
      navigate("../write");
    }
  };

  const moveQustion = ({ id }) => {
    navigate(`/questionlist/${id}`);
  };

  useEffect(() => {
    // 현재페이지 파라미터 변경될 때마다 실행되는 비동기작업
    (async () => {
      // 초기 렌더링 시에도 페이지 데이터를 가져옴
      await readPage(page); // page변수 변경시 실행
    })(); // readPage함수 호출하여 현재페이지 데이터 읽기
  }, [page]); // ^ [page] 배열 전달

  return (
    <Wrap>
      <div className="buttonContainer">
        <h1>All Questions</h1>
        <WriteButton onClick={click}>Ask Question</WriteButton>
      </div>
      <div className="questionsContainer">
        <ListContainer>
          {list &&
            list.map((el, idx) => (
              <QuestionContainer key={`${el.id}`}>
                <div>
                  <div>No.</div>
                  <div id="contentNum">{idx + 1}</div>
                </div>
                <div className="contentContainer">
                  <h3 onClick={() => moveQustion(el)}>{el.title}</h3>
                  <div className="writerContainer">
                    <img alt="profile" src={"member"}></img>
                    <Link to={`/members/${el.member.id}`}>{el.member.name}</Link>
                    <div className="date">{new Date(el.createdAt).toLocaleString("ko-KR")}</div>
                  </div>
                </div>
              </QuestionContainer>
            ))}
        </ListContainer>
      </div>
      <Pagination pageInfo={PageInfo} readPage={readPage} page={page} />
    </Wrap>
  );
}

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
      color: #3c5a91;
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
