import { GoogleButtonContainer, GoogleEmailButton, GoogleLogo, GoogleLoginText } from "./GoogleButton.styled";

function GoogleButton() {
  return (
    <GoogleButtonContainer>
      <GoogleEmailButton>
        <GoogleLogo src="icons-google.png" />
        <GoogleLoginText>Log in with google</GoogleLoginText>
      </GoogleEmailButton>
    </GoogleButtonContainer>
  );
}
export default GoogleButton;
