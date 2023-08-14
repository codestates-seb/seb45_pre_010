import { SignUpContainer , DisplayNameLable, DisplayNameInput,
SignUpEmailLable, SignUpEmailInput,
SignUpPasswordLable, SignUpPasswordInput,
SignUpButtonContainer, SignUpButton } from "./SignUpInputBox.styled";

function SignUpInputBox(){
    return(<SignUpContainer>
        <DisplayNameLable>Display Name</DisplayNameLable>
        <DisplayNameInput />
        <SignUpEmailLable>Email</SignUpEmailLable>
        <SignUpEmailInput />
        <SignUpPasswordLable>Password</SignUpPasswordLable>
        <SignUpPasswordInput />  
        <SignUpButtonContainer>
            <SignUpButton>Sign up</SignUpButton>
        </SignUpButtonContainer>      
    </SignUpContainer>
    );
}

export default SignUpInputBox;