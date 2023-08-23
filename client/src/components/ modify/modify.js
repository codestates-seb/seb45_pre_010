import Modal from 'react-modal';
import React , {useState} from 'react';
import styled from 'styled-components';
import axios from 'axios';

function Modify({userInfo, setUserInfo,isOpen , setIsOpen}) {

  // 근데 생각해보니까 모달로 하고싶어서 하긴했는데 별로 보기좋진않네.. 불편하기도하고.

  const [newNick , setNewNick] = useState('');
  const [newPw, setNewPw] = useState('');

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
      background: "white",
      overflow: "auto",
      top: "35vh",
      left: "38vw",
      right: "38vw",
      bottom: "35vh",
      WebkitOverflowScrolling: "touch",
      borderRadius: "14px",
      outline: "none",
      zIndex: 10,      
      },
  };
  const inputNickHdr = (e) =>{
    setNewNick(e.target.value);
  }
  const inputPwHdr = (e) => {
    setNewPw(e.target.value);
  }

  const setNickHdr = () =>{
    const newInfo = {
      userId : userInfo.userId,
      nickname : newNick,
      email : userInfo.email,
      createAt : userInfo.createAt
    }
    
    setUserInfo(newInfo);
    setNewNick('');
  }

  // const setNickHdr = async () =>{
  //   try{
  //     await axios.patch(`http://localhost:8080/users/update/${userInfo.userId}`, {
  //     //보낼 데이터
  //     }

  //     );
  //   }
  //   catch(e){
  //     console.log(e.response.data);
  //   }
  // }

  const setPwHdr = () =>{
    const newInfo = {
      //id: userInfo.id?,  <-- 나중에 서버랑 연결되면 손봐야됨.
      nickname : userInfo.nickname,
      email : userInfo.email,
      password : newPw
    }
    setUserInfo(newInfo);
    setNewPw('');
   // console.log(newInfo)
  }


  return (    
    <>
      <ModalBtn onClick={()=>modalHdr()}>정보수정</ModalBtn>
      <Modal 
        isOpen={isOpen}
        style={modalStyle}
        onRequestClose={()=>modalHdr()}
        ariaHideApp={false}
        >
        <ContentCon>
          <Logo src="stack-overflow-logo.png"></Logo>
          <Temp1>
            <InputNick 
            placeholder='변경할 닉네임을 입력하세요'
            onChange={(e)=>inputNickHdr(e)}/>
            <ConfirmBtn1
            onClick={()=>setNickHdr()}>ok</ConfirmBtn1>
          </Temp1>
          <Temp2>
            <InputPw 
            placeholder='변경할 pw를 입력하세요'
            onChange={(e)=>inputPwHdr(e)}/>
            <ConfirmBtn2
            onClick={()=>setPwHdr()}>ok</ConfirmBtn2>
          </Temp2>
        </ContentCon>          
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
export const ContentCon = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
`
export const Logo = styled.img`
  display: flex;
  height: 30px;
  width: 30px;
  margin-bottom: 5%;
`

export const Temp1 = styled.div`
  display: flex;
  flex-direction: row;
  height: 30%;
  margin-bottom: 10%;
  width : 90%;
`
export const InputNick = styled.input`
  display: flex;
  width : 100%;
  height: 100%;
  display: flex;
  border-radius: 6px;    
  border: solid hsl(210,8%,85%);
  &:focus{
      border: solid hsl(206,85%,57.5%);
      box-shadow: 2px 2px 4px hsl(206,85%,57.5%), -2px -2px 4px hsl(206,85%,57.5%);
  }
  &::placeholder{
        font-size: 10px;
        color: gray;
        font-style: italic;
    }
`
export const ConfirmBtn1=styled.button`
  display: flex;
  height: 100%;
  width: 20%;
  margin-left: 5%;
  border-radius: 6px;
  background-color: #008efb;
  align-items: center;
  justify-content: center;
  color: white;
  font-size: 15px;
  transition: all 0.3s;  
  &:hover {
    background-color: #0074cc;
  }
`

export const Temp2 = styled.div`
  display: flex;
  flex-direction: row;
  height: 30%;
  margin-bottom: 10%;
  width : 90%;
`

export const InputPw = styled(InputNick)`
`
export const ConfirmBtn2 = styled(ConfirmBtn1)`
`

