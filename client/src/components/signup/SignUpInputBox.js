import { SignUpContainer , DisplayNameLable, DisplayNameInput,
SignUpEmailLable, SignUpEmailInput,
SignUpPasswordLable, SignUpPasswordInput,
SignUpButtonContainer, SignUpButton } from "./SignUpInputBox.styled";
import { useState } from "react";
import { userData } from "../../dummydata/usetData";

function SignUpInputBox(){
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

    const signUpcConfirmHandler = () =>{
        if(email && password){      
            const user =  {
            id : id,
            displayName : displayName,
            email : email,
            password : password
            }
            console.log(user);
            console.log(id);
            idHandler();
            setUserList(userList.concat(user)); 
            setDisplayName('');
            setEmail('');
            setPassword('');       
            console.log(userList);
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
        onChange={(e)=>passwordHandler(e)}/>  
        <SignUpButtonContainer>
            <SignUpButton onClick={()=>signUpcConfirmHandler()}>Sign up</SignUpButton>
        </SignUpButtonContainer>      
    </SignUpContainer>
    );
}

export default SignUpInputBox;