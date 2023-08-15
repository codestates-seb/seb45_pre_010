import { GoogleButtonContainer, GoogleEmailButton, GoogleLogo, GoogleLoginText } from "../login/GoogleButton.styled";

function GoogleSignUpButton(){
    return(<GoogleButtonContainer>
        <GoogleEmailButton>
          <GoogleLogo src="icons-google.png" />
          <GoogleLoginText>Sign up with google</GoogleLoginText>
        </GoogleEmailButton>
      </GoogleButtonContainer>);

}

export default GoogleSignUpButton;