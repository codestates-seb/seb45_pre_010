import { SignUpContainer , DisplayNameLable, DisplayNameInput,
SignUpEmailLable, SignUpEmailInput,
SignUpPasswordLable, SignUpPasswordInput,
SignUpButtonContainer, SignUpButton } from "./SignUpInputBox.styled";
import { useState, useRef } from "react";
import { userData } from "../../dummydata/usetData";


function SignUpInputBox(){
    const passwordRef = useRef('');
    const [id , setId] = useState(userData.length+1);
    const [displayName, setDisplayName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword]= useState('');
    const [userList, setUserList]= useState(userData);

    const displayNameHandler = (e) =>{
        setDisplayName(e.target.value);
    };

    const emailHandler = (e)=>{        
        setEmail(e.target.value);
    }
    const idHandler = () =>{
        setId(id+1);
    }

    const passwordHandler = (e)=>{
        setPassword(e.target.value);
    }

    const signUpcConfirmHandler = (e) =>{
        const temp = email.slice(email.length -10)
        if(email.length <11 && temp !== '@naver.com' && temp !=='@gmail.com'){
            // console.log(email)
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
            e.preventDefault();//왜그런지 모르겠는데 이거없으면 작동이 안됨. 

            const user =  {
            id : id,
            displayName : displayName? displayName : email,
            email : email,
            password : password
            }
            //console.log(user);
            idHandler();
            setUserList(userList.concat(user)); 
            setDisplayName('');
            setEmail('');
            setPassword('');                
            //console.log(userList)
            //window.location.href('http://localhost:3000/')                           
        }
        
    }

    return(<SignUpContainer>
        <DisplayNameLable>Display Name</DisplayNameLable>
        <DisplayNameInput 
        type="text"        
        onChange={(e)=>displayNameHandler(e)}/>
        <SignUpEmailLable>Email</SignUpEmailLable>
        <SignUpEmailInput 
        type="email"
        onChange={(e)=>emailHandler(e)}/>
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