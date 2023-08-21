import styled from "styled-components"
import { Link } from "react-router-dom";
import { useState } from "react";
import Modify from "../../components/ modify/modify";

function Sidebar({userInfo}){

    const [isOpen, setIsOpen] = useState(false);

    return(<SideStyle>
        <SideCon>
            <UserImg src="https://source.unsplash.com/random/130x130/?cat"/>
            <NickName>{userInfo.nickname}</NickName>
            <Write to="/write">글쓰기</Write>
            <Modify setIsOpen={setIsOpen} isOpen={isOpen}>정보수정</Modify>
        </SideCon>       
    </SideStyle>);
}

export default Sidebar;

export const SideStyle=styled.section`
    position : absolute;
    background-color: hsl(205,46%,92%);
    left:0;
    width: 15%;
    top : 55px;
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
    width: 55%;
    height: 20%;
    margin-top : 20%;
    border-radius: 50%;
`;

export const NickName = styled.span`
    margin-top : 10%;    
  
`
export const Write =styled(Link)`
    margin-top : 10%;    
  
`

export const ModifyInfo = styled.div`
    margin-top : 10%;       
    cursor: pointer;
     
`