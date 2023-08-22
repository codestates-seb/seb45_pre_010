import { useState } from "react";
import axios from "axios";
import styled from "styled-components";
import TitleInput from "../components/write/TitleInput";
import Editor from "../components/write/Editor";
import TagItem from "../components/write/TagItem";

const Write = () => {
  // 타이틀 상태
  const [titleValue, setTitleValue] = useState("");
  const handleTitleChange = (e) => {
    setTitleValue(e.target.value);
  };

  // 에디터 상태
  const [bodyValue, setBodyValue] = useState("");
  const onChangeContents = (content) => {
    setBodyValue(content);
  };

  // 태그 아이템 상태
  const [tagValue, setTagValue] = useState("");
  const [tags, setTags] = useState([]);

  // 등록 전달 데이터
  // const data = {
  //   title: titleValue,
  //   content: bodyValue,

  //   // 백엔드 데이터 만들어졌는지 확인해보고 넘겨주기
  //   // tag: tags,
  //   // created_at: new Date().toLocaleDateString().replace(/\.$/, "")
  //   created_at: new Date().toLocaleDateString().replace(/\./g, "").replace(/\s/g, "-"),
  // };

  const handleSubmit = async () => {
    const data = {
      title: titleValue,
      content: bodyValue,
      tag: tags,
      created_at: new Date().toLocaleDateString().replace(/\./g, "").replace(/\s/g, "-"),
    };

    try {
      await axios.post("http://localhost:4000", data);
      console.log("데이터가 성공적으로 등록되었습니다.");
      console.log(data);
    } catch (error) {
      console.error("데이터 등록 실패:", error);
    }
  };

  return (
    <WriteWrap>
      <WriteConteiner>
        <GuideBox>
          <Title>Title</Title>
          <TitleInput handleTitleChange={handleTitleChange} />
        </GuideBox>
        <GuideBox>
          <Title>Body</Title>
          <Editor onChangeContents={onChangeContents} />
        </GuideBox>
        <GuideBox>
          <Title>Tags</Title>
          <InfoTxt>태그는 최대 5개까지 생성 가능합니다.</InfoTxt>
          <TagItem tagValue={tagValue} setTagValue={setTagValue} tags={tags} setTags={setTags} />
        </GuideBox>
        <SubmitBtn onClick={handleSubmit}>Post your question</SubmitBtn>
      </WriteConteiner>
    </WriteWrap>
  );
};
export default Write;

const WriteWrap = styled.div`
  background-color: #f8f9f9;
  min-height: calc(100vh - 106px);
  padding-top: 52px;
`;

const WriteConteiner = styled.div`
  max-width: 1000px;
  padding: 0 20px;
  margin: 0 auto;
`;

const GuideBox = styled.div`
  padding: 28px 24px;
  border: 1px solid #e3e6e8;
  border-radius: 8px;
  background-color: #fff;
  margin-top: 12px;
`;

const Title = styled.strong`
  display: block;
  padding-bottom: 10px;
  font-size: 16px;
`;

const InfoTxt = styled.p`
  padding-bottom: 10px;
  font-size: 10px;
  font-weight: 100;
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
