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
    const [createAt, setCreateAt]= useState('');

 
    function formatDate() {
        const date = new Date();
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    }   

    const displayNameHandler = (e) =>{
        setDisplayName(e.target.value);
    };

    const userIdHandler = (e)=>{        
        setUserId(e.target.value);
    }

    const passwordHandler = (e)=>{
        setPassword(e.target.value);
        setCreateAt(formatDate());//이거 너무 쓸데없이 불필요하게 반복됨.
    }

    const signUpcConfirmHandler = async(e) =>{
                   
        e.preventDefault();     
        const temp = userId.slice(userId.length -10)
        if(userId.length <11 && temp !== '@naver.com' && temp !=='@gmail.com'){
            // console.log(userId)
            // console.log('invalid id')
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
            console.log(createAt)
            const user =  {
                displayName : displayName? displayName : userId,
                userId : userId,
                password : password,
                createAt : createAt
                }
            try{
                const res =await axios.post('http://localhost:4000', {user});
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
        onChange={(e)=>displayNameHandler(e)}/>
        <SignUpUserIdLable>userId</SignUpUserIdLable>
        <SignUpUserIdInput 
        type="userId"
        onChange={(e)=>userIdHandler(e)}/>
        <SignUpPasswordLable>Password</SignUpPasswordLable>
        <SignUpPasswordInput 
        type="password"
        ref ={passwordRef}
        onChange={(e)=>passwordHandler(e)}/>  
        <SignUpButtonContainer>
            <SignUpButton onClick={(e)=>signUpcConfirmHandler(e)}>Sign up</SignUpButton>
        </SignUpButtonContainer>      
    </SignUpContainer>
    );
}

export default SignUpInputBox;