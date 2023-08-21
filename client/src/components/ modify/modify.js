import Modal from 'react-modal';
import React from 'react';
import styled from 'styled-components';


function Modify({isOpen , setIsOpen}) {

  const modalHdr = () =>{
    setIsOpen(!isOpen)
  }

  const modalStyle = {
    overlay: {
      position: "fixed",
      top: 0,
      left: 0,
      right: 0,
      bottom: 0,
      backgroundColor: "rgba(255, 255, 255, 0.45)",
      zIndex: 10,
    },
    content: {
      display: "flex",
      justifyContent: "center",
      background: "#ffffe7",
      overflow: "auto",
      top: "42vh",
      left: "38vw",
      right: "38vw",
      bottom: "42vh",
      WebkitOverflowScrolling: "touch",
      borderRadius: "14px",
      outline: "none",
      zIndex: 10,
    },
  };
  return (    
    <>
      <ModalBtn onClick={()=>modalHdr()}>정보수정</ModalBtn>
      <Modal 
        isOpen={isOpen}
        style={modalStyle}
        onRequestClose={()=>modalHdr()}
        ariaHideApp={false}
        >
          모달 내용 or 컴포넌트
      </Modal>          
    </>
  )


}

export default Modify;

export const ModalBtn = styled.button`
  font-family: inherit;
  font-weight: 800;
  margin-top : 10%;
  cursor: pointer;
  color : #525960;
  font-size : 16px;
`