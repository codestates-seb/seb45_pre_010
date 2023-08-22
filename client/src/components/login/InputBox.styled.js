import styled from 'styled-components';

export const InputBoxContainer = styled.div`
    display: flex;
    align-items: center;   
    margin-bottom : 5px;
`
export const InputForm = styled.form`
    width: 100%;
    display: flex;
    justify-content: center;    
    flex-direction: column;
    align-items: center;
    border-radius: 6px;
    border: solid hsl(210,8%,85%);   
    background-color : white ;
`
export const UserIdText = styled.label`
    display: flex;
    width: 80%;
    margin-top: 15px;   
    margin-bottom: 5px;
`
export const UserIdContainer = styled.div`
    display: flex;
    flex-direction: column;
`
export const InputUserId = styled.input`
    width : 230px;
    height: 34px;
    display: flex;
    border-radius: 6px;    
    border: solid hsl(210,8%,85%);
    &:focus{
        border: solid hsl(206,85%,57.5%);
        box-shadow: 2px 2px 4px hsl(206,85%,57.5%), -2px -2px 4px hsl(206,85%,57.5%);
    }

`
export const PasswordText = styled.label`
    display: flex;
    width: 80%;
    margin-top: 15px;   
    margin-bottom: 5px;

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
    &:focus{
        border: solid hsl(206,85%,57.5%);
        box-shadow: 2px 2px 4px hsl(206,85%,57.5%), -2px -2px 4px hsl(206,85%,57.5%);
    }
`
export const ConfirmButtonContainer = styled.div`
    display: flex;
    margin-top: 15px;
    margin-bottom: 5px;
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
