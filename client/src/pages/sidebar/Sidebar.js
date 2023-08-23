import styled from "styled-components"
import { Link } from "react-router-dom";
import { useState } from "react";
import Modify from "../../components/ modify/modify";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Sidebar({userInfo , setUserInfo, setToken, setIsLogin}){

    const navigate = useNavigate()
    const [isOpen, setIsOpen] = useState(false);

    const deleteHdr = async () =>{
        try{
            await axios.delete(`http://localhost:8080/users/delete/${userInfo.userId}`);
            setIsLogin(false);
            setToken('');
            setUserInfo('');
            navigate('/');
        }
        catch(e){
            console.log(e.response.data);
        }
        console.log(userInfo);
    }

    return(<SideStyle>
        <SideCon>
            <UserImg src="https://source.unsplash.com/random/130x130/?cat"/>
            <NickName>{userInfo.nickname}</NickName>
            <Write to="/write">글쓰기</Write>
            <Modify userInfo={userInfo}setIsOpen={setIsOpen} isOpen={isOpen} setUserInfo={setUserInfo}>정보수정</Modify>
            <Delete onClick={()=>deleteHdr()}>회원탈퇴</Delete>
        </SideCon>       
    </SideStyle>);
}

export default Sidebar;

export const SideStyle=styled.section`
    position : absolute;
    background-color: hsl(205,46%,92%);
    left:0;
    width: 15%;
    top : 56px;
    bottom: 50px;
`;
export const SideCon = styled.div`
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    font-family: inherit;
    font-weight: 800;
`

export const UserImg = styled.img`
    display: flex;
    width: 57%;
    height: 20%;
    margin-top : 20%;
    border-radius: 50%;
`;

export const NickName = styled.span`
    margin-top : 10%;    
    font-size: 30px;
    font-weight: 100;
  
`
export const Write =styled(Link)`
    margin-top : 10%;    
  
`

export const Delete = styled.div`
  font-family: inherit;
  font-weight: 800;
  margin-top : 10%;
  cursor: pointer;
  color : #525960;
  font-size : 16px;
`
