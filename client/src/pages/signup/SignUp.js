import GoogleSignUpButton from "../../components/signup/GoogleSignUpButton";
import SignUpInputBox from "../../components/signup/SignUpInputBox";
import { SignUpContainer, SignUpWrapper } from "./SignUp.styled";


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