import styled from "styled-components";

const TagItem = ({ tagValue, setTagValue, tags, setTags }) => {
  const handleInputChange = (e) => {
    setTagValue(e.target.value);
  };

  // 엔터 키 태그 생성 이벤트
  const handleInputKeyPress = (e) => {
    if (e.key === "Enter" && tagValue.trim() !== "") {
      if (tags.length < 5) {
        if (!tags.includes(tagValue.trim())) {
          setTags([...tags, tagValue.trim()]);
          setTagValue("");
        } else {
          alert("중복된 태그는 생성할 수 없습니다.");
          setTagValue("");
        }
      } else {
        alert("태그는 최대 5개까지만 생성 가능합니다.");
        setTagValue("");
      }
    }
  };

  // 엑스버튼 클릭 삭제 이벤트
  const handleTagDelete = (tag) => {
    const updatedTags = tags.filter((t) => t !== tag);
    setTags(updatedTags);
  };

  // 백스페이스 삭제 이벤트
  const handleInputKeyDown = (e) => {
    if (e.key === "Backspace" && tagValue === "") {
      const updatedTags = [...tags];
      updatedTags.pop();
      setTags(updatedTags);
    }
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
        value={tagValue}
        onChange={handleInputChange}
        onKeyUp={handleInputKeyPress}
        onKeyDown={handleInputKeyDown}
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
