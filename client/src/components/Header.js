import { Link } from "react-router-dom";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Header = ({isLogin, setIsLogin, setToken, setUserInfo}) => {
  const navigate=useNavigate();

  const LoginHandeler = () => {
    navigate('/login')
  }; 

  const LogOutHandeler = async() => {  
    try{
      await axios.post("http://localhost:8080/users/logout"); 
      setUserInfo('');
      setIsLogin(false);
      setToken('');
      navigate('/')
    }
    catch(error){
      console.log(error.responsedata)
    }  //서버가 안돌아가서 일단 닫아둠.
   
  }

  const SignUpHandler = () =>{
    window.location.href='http://localhost:3000/signup'
  }

  return (
    <HeaderStyle>
      <HeaderCon>
        <h1>
          <LogoLink to="/">
            <img src="logo.png" alt="stack overflow" />
          </LogoLink>
        </h1>
        {isLogin ? (
          <Profile>
            <img src="profile.png" alt="프로필 이미지" />
            <NickName>닉네임</NickName>
            <LogOutBtn onClick={LogOutHandeler}>Log out</LogOutBtn>            
          </Profile>
        ) : (
          <div>
            <LoginBtn onClick={LoginHandeler}>Log in</LoginBtn>
            <SignUpBtn onClick={SignUpHandler}>Sign up</SignUpBtn>
          </div>
        )}
      </HeaderCon>
    </HeaderStyle>
  );
};
export default Header;

const HeaderStyle = styled.header`
  background-color: #fff;
  position: fixed;
  left: 0;
  top: 0;
  right: 0;
  border-top: 3px solid #f48225;
  border-bottom: 1px solid #d6d8dc;
`;

const HeaderCon = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 52px;
  max-width: 1240px;
  padding: 0 20px;
  margin: 0 auto;
`;

const LogoLink = styled(Link)`
  display: block;
  height: 30px;
  > img {
    height: 100%;
    vertical-align: top;
  }
`;

const Profile = styled.div`
  > img {
    width: 24px;
    border-radius: 4px;
  }
`;

const NickName = styled.span`
  font-size: 12px;
  margin-left: 5px;
`;

const LogOutBtn = styled.button`
  height: 30px;
  line-height: 28px;
  padding: 0 12px;
  border-radius: 6px;
  border: 1px solid #d6d8dc;
  color: #000;
  font-size: 13px;
  margin-left: 10px;
  transition: all 0.3s;
  &:hover {
    background-color: #e3e3e3;
  }
`;


const LoginBtn = styled.button`
  height: 30px;
  line-height: 30px;
  padding: 0 12px;
  border-radius: 6px;
  background-color: #ddeaf2;
  color: #326991;
  font-size: 13px;
  transition: all 0.3s;
  &:hover {
    background-color: #b3d3ea;
  }
`;

const SignUpBtn = styled.button`
  height: 30px;
  line-height: 30px;
  padding: 0 12px;
  border-radius: 6px;
  background-color: #008efb;
  color: #fff;
  font-size: 13px;
  margin-left: 5px;
  transition: all 0.3s;
  &:hover {
    background-color: #0074cc;
  }
`;
