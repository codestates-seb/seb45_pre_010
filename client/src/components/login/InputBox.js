import { InputBoxContainer, InputForm, EmailText, 
    EmailContainer, InputEmail, EmailErrorMassage,
    PasswordText, PasswordContainer, InputPassword, PasswordErrorMassage
, ConfirmButtonContainer, ConfirmButton  } from "./InputBox.styled";

function InputBox(){
    return (
        <InputBoxContainer>
          <InputForm>
            <EmailText>Email</EmailText>
            <EmailContainer>
                <InputEmail/>
                <EmailErrorMassage>email 에러</EmailErrorMassage>
            </EmailContainer>
            <PasswordText/>Password
            <PasswordContainer>
                <InputPassword/>
                <PasswordErrorMassage>password에러</PasswordErrorMassage>
            </PasswordContainer>
            <ConfirmButtonContainer>
                <ConfirmButton>Login</ConfirmButton>
            </ConfirmButtonContainer>
          </InputForm>       
        </InputBoxContainer>
    );
}

export default InputBox;