import GoogleSignUpButton from "../../components/signup/GoogleSignUpButton";
import SignUpInputBox from "../../components/signup/SignUpInputBox";
import styled from 'styled-components'


function SignUp({setIsLogin, setToken}){
    return (
    <SignUpContainer>
        <SignUpWrapper>
          <GoogleSignUpButton />
          <SignUpInputBox setIsLogin={setIsLogin} setToken={setToken}/>
        </SignUpWrapper>        
    </SignUpContainer>);
}

export default SignUp;


export const SignUpContainer = styled.div`
    height: 86vh;
    display: flex;
    align-items: center;
    justify-content: center;  
    background-color: hsl(205,46%,92%); 
`

export const SignUpWrapper = styled.div`
    display: flex;    
    flex-direction: column;
`