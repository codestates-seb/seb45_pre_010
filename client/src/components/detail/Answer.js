import { useState } from "react";
import styled from "styled-components";
import Editor from "../write/Editor";

const Answer = () => {
  const [bodyValue, setBodyValue] = useState("");
  const onChangeContents = (content) => {
    setBodyValue(content);
  };

  // 답변 리스트 더미 데이터
  const answerData = [
    {
      id: "test@gmail.com",
      content: "<p>답변1 입니다</p>",
      created_at: "2023-8-17",
    },
    {
      id: "gildong@gmail.com",
      content: "<p>답변2 입니다</p>",
      created_at: "2023-8-16",
    },
    {
      id: "amuga@gmail.com",
      content: "<p>답변3 입니다</p>",
      created_at: "2023-8-15",
    },
  ];

  // 답변 등록 시 post 데이터
  const writeData = {
    content: bodyValue,
    created_at: new Date().toLocaleDateString().replace(/\./g, "").replace(/\s/g, "-"),
  };

  // const handleSubmit = async () => {
  //   const data = {
  //     content: bodyValue,
  //     created_at: new Date().toLocaleDateString(),
  //   };

  //   try {
  //     await axios.post('http://localhost:3001/data', newData);
  //     console.log('데이터가 성공적으로 등록되었습니다.');
  //   } catch (error) {
  //     console.error('데이터 등록 실패:', error);
  //   }
  // }

  return (
    <>
      <AnswerTit>{answerData.length} Answers</AnswerTit>

      {answerData.map((answer, index) => (
        <AnswerBox key={index}>
          <AnswerBody dangerouslySetInnerHTML={{ __html: answer.content }}></AnswerBody>
          <AnswerUserInfo>
            <AnswerUser>{answer.id}</AnswerUser>
            <span>{answer.created_at}</span>
          </AnswerUserInfo>
        </AnswerBox>
      ))}

      <AnswerTit>Your Answer</AnswerTit>
      <Editor onChangeContents={onChangeContents} />
      <SubmitBtn>Post Your Answer</SubmitBtn>
    </>
  );
};
export default Answer;

const AnswerTit = styled.strong`
  display: block;
  font-size: 18px;
  border-top: 1px solid #e3e6e8;
  margin-top: 20px;
  margin-bottom: 12px;
  padding-top: 30px;
`;

const AnswerBox = styled.div`
  padding: 12px 0;
  border-top: 1px solid #e3e6e8;
`;

const AnswerBody = styled.div`
  font-size: 13px;
  padding-bottom: 30px;
`;

const AnswerUserInfo = styled.div`
  text-align: right;
  font-size: 12px;
`;

const AnswerUser = styled.div`
  color: #0074cc;
  margin-bottom: 5px;
`;

const SubmitBtn = styled.button`
  display: block;
  height: 40px;
  line-height: 40px;
  padding: 0 12px;
  border-radius: 6px;
  background-color: #008efb;
  color: #fff;
  font-size: 13px;
  margin-top: 20px;
  transition: all 0.3s;
  &:hover {
    background-color: #0074cc;
  }
`;
