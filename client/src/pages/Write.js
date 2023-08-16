import styled from "styled-components";
import TagItem from "../components/write/TagItem";
import Editor from "../components/write/Editor";

const Write = () => {
  return (
    <WriteWrap>
      <WriteConteiner>
        <GuideBox>
          <Title>Title</Title>
          <TitleInput></TitleInput>
        </GuideBox>
        <GuideBox>
          <Title>Body</Title>
          <Editor />
        </GuideBox>
        <GuideBox>
          <Title>Tags</Title>
          <InfoTxt>태그는 최대 5개까지 생성 가능합니다.</InfoTxt>
          <TagItem />
        </GuideBox>
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

const TitleInput = styled.input`
  width: 100%;
  border: 1px solid #babfc4;
  border-radius: 4px;
  height: 34px;
  padding: 0 5px;
`;
