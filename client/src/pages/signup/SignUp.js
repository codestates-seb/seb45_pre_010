import GoogleSignUpButton from "../../components/signup/GoogleSignUpButton";
import SignUpInputBox from "../../components/signup/SignUpInputBox";
import { SignUpContainer, SignUpWrapper } from "./SignUp.styled";


function SignUp(){
    return (
    <SignUpContainer>
        <SignUpWrapper>
          <GoogleSignUpButton />
          <SignUpInputBox />
        </SignUpWrapper>        
    </SignUpContainer>);
}

export default SignUp;