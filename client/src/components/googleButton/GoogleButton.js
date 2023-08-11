import { GoogleButtonContainer, GoogleEmailButton, GoogleLogo, GoogleLoginText } from "./GoogleButton.styled";
import googleLogo from '../../common/image/icons-google.png'

function GoogleButton (){
    return (<GoogleButtonContainer>
        <GoogleEmailButton>
          <GoogleLogo src={googleLogo} />
          <GoogleLoginText>Log in with google</GoogleLoginText>
        </GoogleEmailButton>
      </GoogleButtonContainer>);

}
export default GoogleButton;