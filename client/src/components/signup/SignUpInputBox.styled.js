import styled from 'styled-components'

export const SignUpContainer = styled.div`
    width: 276px;
    max-width: 100%;
    display: flex;
    justify-content: center;    
    flex-direction: column;
    align-items: center;
    border-radius: 6px;
    border: solid hsl(210,8%,85%);  
`

export const DisplayNameLable = styled.label`
    display: flex; 
`

export const DisplayNameInput = styled.input`
    width : 230px;
    height: 34px;
    display: flex;
    border-radius: 6px;    
    border: solid hsl(210,8%,85%);
`

export const SignUpEmailLable = styled.label`
`

export const SignUpEmailInput = styled.input`
    width : 230px;
    height: 34px;
    display: flex;
    border-radius: 6px;    
    border: solid hsl(210,8%,85%);
`

export const SignUpPasswordLable = styled.label`
`

export const SignUpPasswordInput = styled.input`
    width : 230px;
    height: 34px;
    display: flex;
    border-radius: 6px;    
    border: solid hsl(210,8%,85%);
`

export const SignUpButtonContainer = styled.div`
    display: flex;
`

export const SignUpButton = styled.button`
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