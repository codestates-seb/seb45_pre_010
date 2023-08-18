import { InputBoxContainer, InputForm, UserIdText, 
    UserIdContainer, InputUserId, UserIdErrorMassage,
    PasswordText, PasswordContainer, InputPassword, PasswordErrorMassage
, ConfirmButtonContainer, ConfirmButton  } from "./InputBox.styled";
import { useState } from "react";
import axios from "axios";


function InputBox({setIsLogin, setToken}){
    const [userId, setuserId] = useState('');
    const [password , setPassword] = useState('');

    const userIdHandler = (e) =>{
        setuserId(e.target.value);        
    }

    const passwordHandler = (e) =>{
        setPassword(e.target.value);        
    }

    const loginHandler =async (e) =>{
        e.preventDefault();
        try{
            const res = await axios.post('http://localhost:4000', {userId, password})
            const token = res.data;
            console.log(token);
            setToken(token);
            setIsLogin(true);
        }
        catch(error){
            console.log(error.response.data);
        }
    }

    return (
        <InputBoxContainer>
          <InputForm>
            <UserIdText>userId</UserIdText>
            <UserIdContainer>
                <InputUserId
                type = 'userId'
                onChange={(e)=>userIdHandler(e)}
                />
                <UserIdErrorMassage>userId 에러</UserIdErrorMassage>
            </UserIdContainer>
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