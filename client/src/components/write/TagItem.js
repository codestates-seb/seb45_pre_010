import { useState } from "react";
import styled from "styled-components";

const TagItem = () => {
  const [inputValue, setInputValue] = useState("");
  const [tags, setTags] = useState([]);

  const handleInputChange = (e) => {
    setInputValue(e.target.value);
  };

  const handleInputKeyPress = (e) => {
    if (e.key === "Enter" && inputValue.trim() !== "") {
      if (tags.length < 5) {
        setTags([...tags, inputValue.trim()]);
        setInputValue("");
      } else {
        alert("태그는 최대 5개까지만 생성 가능합니다.");
        setInputValue("");
      }
    }
  };

  const handleTagDelete = (tag) => {
    const updatedTags = tags.filter((t) => t !== tag);
    setTags(updatedTags);
  };

  return (
    <TagBox>
      {tags.map((tag, index) => (
        <Tag key={index}>
          <em>{tag}</em>
          <button onClick={() => handleTagDelete(tag)}></button>
        </Tag>
      ))}

      <TagInput
        type="text"
        placeholder="enter로 tag를 생성해주세요."
        value={inputValue}
        onChange={handleInputChange}
        onKeyDown={handleInputKeyPress}
      />
    </TagBox>
  );
};
export default TagItem;

const TagBox = styled.div`
  border: 1px solid #babfc4;
  border-radius: 4px;
  min-height: 34px;
  padding: 5px 5px 0;
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
  button {
    width: 10px;
    height: 10px;
    background: url("ic_tagDelete.png") no-repeat center / 10px;
    margin-left: 5px;
  }
`;

const TagInput = styled.input`
  display: inline-flex;
  min-width: 150px;
  background: transparent;
  font-size: 12px;
  margin-left: 5px;
  height: 24px;
`;
