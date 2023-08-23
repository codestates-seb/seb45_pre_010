import styled from "styled-components";

const TitleInput = ({ handleTitleChange }) => {
  return <TitleInp onChange={handleTitleChange}></TitleInp>;
};
export default TitleInput;

const TitleInp = styled.input`
  width: 100%;
  border: 1px solid #babfc4;
  border-radius: 4px;
  height: 34px;
  padding: 0 5px;
`;
