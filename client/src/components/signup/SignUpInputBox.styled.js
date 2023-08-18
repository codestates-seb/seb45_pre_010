import styled from 'styled-components'

export const SignUpContainer = styled.div`
    width: 100%;
    display: flex;
    justify-content: center;    
    flex-direction: column;
    align-items: center;
    border-radius: 6px;
    border: solid hsl(210,8%,85%);  
    background-color: white;
`

export const DisplayNameLable = styled.label`
    display: flex;
    width: 80%;
    margin-top: 15px;   
    margin-bottom: 5px;
`

export const DisplayNameInput = styled.input`
    width : 85%;
    height: 34px;
    display: flex;
    border-radius: 6px;    
    border: solid hsl(210,8%,85%);
    &:focus{
        border: solid hsl(206,85%,57.5%);
        box-shadow: 2px 2px 4px hsl(206,85%,57.5%), -2px -2px 4px hsl(206,85%,57.5%);
    }
    &::placeholder{
        font-size: 10px;
        color: gray;
        font-style: italic;
    }
    /* &:placeholder-shown {
    background-color: lightgray; */
  /* } */
`

export const SignUpUserIdLable = styled.label`
    display: flex;
    width: 80%;
    margin-top: 15px;   
    margin-bottom: 5px;
`

export const SignUpUserIdInput = styled.input`
    width : 85%;
    height: 34px;
    display: flex;
    border-radius: 6px;    
    border: solid hsl(210,8%,85%);
    &:focus{
        border: solid hsl(206,85%,57.5%);
        box-shadow: 2px 2px 4px hsl(206,85%,57.5%), -2px -2px 4px hsl(206,85%,57.5%);
    }
`

export const SignUpPasswordLable = styled.label`
    display: flex;
    width: 80%;
    margin-top: 15px;   
    margin-bottom: 5px;
`

export const SignUpPasswordInput = styled.input`
    width : 85%;
    height: 34px;
    display: flex;
    border-radius: 6px;    
    border: solid hsl(210,8%,85%);
    &:focus{
        border: solid hsl(206,85%,57.5%);
        box-shadow: 2px 2px 4px hsl(206,85%,57.5%), -2px -2px 4px hsl(206,85%,57.5%);
    }
`

export const SignUpButtonContainer = styled.div`
    display: flex;    
    width: 85%;
    margin-top: 15px;
    margin-bottom: 5px;
`

export const SignUpButton = styled.button`
    width : 100%;
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