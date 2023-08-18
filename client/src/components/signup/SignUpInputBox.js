import { SignUpContainer , DisplayNameLable, DisplayNameInput,
SignUpUserIdLable, SignUpUserIdInput,
SignUpPasswordLable, SignUpPasswordInput,
SignUpButtonContainer, SignUpButton } from "./SignUpInputBox.styled";
import { useState, useRef,  } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";



function SignUpInputBox({setIsLogin, setToken}){
    const navigate = useNavigate();
    const passwordRef = useRef('');
    const [displayName, setDisplayName] = useState('');
    const [userId, setUserId] = useState('');
    const [password, setPassword]= useState('');
    const [errorUserIdMessage, setErrorUserIdMessage] = useState('');
    const [errorPasswordMessage, setErrorPasswordMEssage]= useState('');

    //const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
    //emailPattern.test(string값)  리턴값으로 boolean   혹시 필요할지도 모르니 남겨둠
 

    const displayNameHandler = (e) =>{
        setDisplayName(e.target.value);
    };

    const userIdHandler = (e)=>{        
        setUserId(e.target.value);
    }

    const passwordHandler = (e)=>{
        setPassword(e.target.value);       
    }

    const signUpcConfirmHandler = async(e) =>{
                   
        e.preventDefault();     
        const temp = userId.slice(userId.length -10)
        if(userId.length <11 && temp !== '@naver.com' && temp !=='@gmail.com'){
            setErrorUserIdMessage('올바른 형식이 아닙니다.')
            if(passwordRef.current){
                passwordRef.current.value = '';
            }           
        } 
        else if(password === '' || !(password.length >= 8 && /\d/.test(password))){
            // console.log('invaild pw')
            // console.log(password)
            if(passwordRef.current){
                passwordRef.current.value = '';
            }      
        }

        else{          
            //왜그런지 모르겠는데 이거없으면 작동이 안됨. 
            
            const user =  {
                displayName : displayName? displayName : userId,
                userId : userId,
                password : password,
                createAt :  new Date().toLocaleDateString().replace(/\./g, "").replace(/\s/g, "-"),
                }
            try{
                const res =await axios.post('http://localhost:4000/signup', {user});
                const token = res.data;
                setIsLogin(true);
                setToken(token);
                console.log(token)
                navigate('/')
            }  
            catch(error){
                console.log(error.response.data)
            }  
                    
            console.log(user);
            setDisplayName('');
            setUserId('');
            setPassword('');                
            //console.log(userList)                         
        }
        
    }

    return(<SignUpContainer>
        <DisplayNameLable>Display Name</DisplayNameLable>
        <DisplayNameInput 
        type="text"        
        placeholder="필수아님"
        onChange={(e)=>displayNameHandler(e)}/>
        <SignUpUserIdLable>Email</SignUpUserIdLable>
        <SignUpUserIdInput 
        type="userId"
        onChange={(e)=>userIdHandler(e)}/>        
        {errorUserIdMessage?(<div style={{fontSize:'10px', color:'red', width:'80%'}}>{errorUserIdMessage}</div>)
        :(<div style={{fontSize:'10px', width:'80%'}}>gmail과 naver형식으로 입력하세요</div>)}        
        <SignUpPasswordLable>Password</SignUpPasswordLable>
        <SignUpPasswordInput 
        type="password"
        ref ={passwordRef}
        onChange={(e)=>passwordHandler(e)}/> 
        {errorPasswordMessage?(<div style={{fontSize:'10px', color:'red', width:'80%'}}></div>)
        :(<dvi style={{fontSize:'10px', width:'80%'}}>영문자와 숫자조합 8글자이상</dvi>)} 
        <SignUpButtonContainer>
            <SignUpButton onClick={(e)=>signUpcConfirmHandler(e)}>Sign up</SignUpButton>
        </SignUpButtonContainer>      
    </SignUpContainer>
    );
}

export default SignUpInputBox;