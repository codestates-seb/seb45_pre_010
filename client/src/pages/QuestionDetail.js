import { useState, useEffect } from "react";
import styled from "styled-components";
import Answer from "../components/detail/Answer";

const dummyData = [
  {
    id: "test@gmail.com",
    title: "제목입니다",
    content: "<p>본문입니다</p>",
    tag: ["태그", "태그2"],
    created_at: "2023-8-17",
  },
];

function QuestionDetail() {
  const [data, setData] = useState(null);

  useEffect(() => {
    const foundData = dummyData.find((item) => item.id === "test@gmail.com");
    setData(foundData);
  }, []);

  return (
    <div>
      {data ? (
        <DetailConteiner>
          <TitleBox>
            <strong>{data.title}</strong>
            <TitleInfo>
              질문 날짜<span>{data.created_at}</span>
              작성자<span>{data.id}</span>
            </TitleInfo>
          </TitleBox>

          <DetailBox dangerouslySetInnerHTML={{ __html: data.content }}></DetailBox>

          {data.tag.map((tag, index) => (
            <Tag key={index}>
              <em>{tag}</em>
            </Tag>
          ))}

          {/* 답변 */}
          <Answer />
        </DetailConteiner>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
}

export default QuestionDetail;

const DetailConteiner = styled.div`
  max-width: 1000px;
  padding: 0 20px;
  margin: 0 auto;
`;

const TitleBox = styled.div`
  padding: 30px 0 12px;
  border-bottom: 1px solid #e3e6e8;
  > strong {
    display: block;
    font-size: 28px;
    font-weight: 300;
  }
`;

const TitleInfo = styled.div`
  padding-top: 20px;
  font-size: 12px;
  color: #aeaeae;
  > span {
    margin-right: 16px;
    margin-left: 5px;
    color: #7d7d7d;
  }
`;

const DetailBox = styled.div`
  padding: 12px 0 20px;
`;

const Tag = styled.span`
  display: inline-block;
  border-radius: 4px;
  background-color: #e1edf4;
  color: #437aa2;
  padding: 0 5px;
  margin-right: 5px;
  margin-bottom: 5px;
  :last-child {
    margin-right: 0;
  }
  em {
    height: 24px;
    line-height: 24px;
    font-size: 12px;
  }
`;
