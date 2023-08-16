import { InputBoxContainer, InputForm, EmailText, 
    EmailContainer, InputEmail, EmailErrorMassage,
    PasswordText, PasswordContainer, InputPassword, PasswordErrorMassage
, ConfirmButtonContainer, ConfirmButton  } from "./InputBox.styled";
import { userData } from "../../dummydata/usetData";
import { useState } from "react";

function InputBox(){
    const [email, setEmail] = useState('');
    const [password , setPassword] = useState('');

    const emailHandler = (e) =>{
        setEmail(e.target.value);        
    }

    const passwordHandler = (e) =>{
        setPassword(e.target.value);        
    }

    const loginHandler = (e) =>{
        const [user] = userData.filter((el)=>el.email === email);

        e.preventDefault();
       
        if(user.password === password){
            window.location.href = 'http://localhost:3000/'
        }
    }

    return (
        <InputBoxContainer>
          <InputForm>
            <EmailText>Email</EmailText>
            <EmailContainer>
                <InputEmail
                type = 'email'
                onChange={(e)=>emailHandler(e)}
                />
                <EmailErrorMassage>email 에러</EmailErrorMassage>
            </EmailContainer>
            <PasswordText/>Password
            <PasswordContainer>
                <InputPassword
                type ='password'
                onChange={(e)=>passwordHandler(e)}/>
                <PasswordErrorMassage>password에러</PasswordErrorMassage>
            </PasswordContainer>
            <ConfirmButtonContainer>
                <ConfirmButton onClick={(e)=>loginHandler(e)}>Login</ConfirmButton>
            </ConfirmButtonContainer>
          </InputForm>       
        </InputBoxContainer>
    );
}

export default InputBox;