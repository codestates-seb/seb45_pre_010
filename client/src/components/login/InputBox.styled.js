import styled from 'styled-components';

export const InputBoxContainer = styled.div`
    display: flex;
    align-items: center;    
`
export const InputForm = styled.form`
    width: 276px;
    max-width: 100%;
    display: flex;
    justify-content: center;    
    flex-direction: column;
    align-items: center;
    border-radius: 6px;
    border: solid hsl(210,8%,85%);  
     
`
export const EmailText = styled.label`
    display: flex;   
`
export const EmailContainer = styled.div`
    display: flex;
    flex-direction: column;
`
export const InputEmail = styled.input`
    width : 230px;
    height: 34px;
    display: flex;
    border-radius: 6px;    
    border: solid hsl(210,8%,85%);
`
export const EmailErrorMassage = styled.div`
    display: flex;
    
`

export const PasswordText = styled.label`
    display: flex;
`
export const PasswordContainer = styled.div`
    display: flex;
    flex-direction: column;
`
export const InputPassword = styled.input`
    width : 230px;
    height: 34px;
    display: flex;
    border-radius: 6px;    
    border: solid hsl(210,8%,85%);
`
export const PasswordErrorMassage = styled.div`
    display: flex;
`
export const ConfirmButtonContainer = styled.div`
    display: flex;
`
export const ConfirmButton = styled.button` 
    width : 230px;
    height: 34px;
    background-color: hsl(206,85%,57.5%);
    display: flex;
    border : 0;
    border-radius: 6px;
    align-items: center;
    justify-content: center;
    color : white;
    cursor: pointer;
    &:hover{
        background-color: #0074cc;
    }
`
