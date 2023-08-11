import styled from "styled-components";

const Write = () => {
  return (
    <WriteWrap>
      <WriteConteiner></WriteConteiner>
    </WriteWrap>
  );
};
export default Write;

const WriteWrap = styled.div`
  background-color: #f8f9f9;
  min-height: calc(100vh - 106px);
`;

const WriteConteiner = styled.div`
  max-width: 1000px;
  padding: 0 20px;
  margin: 0 auto;
`;
