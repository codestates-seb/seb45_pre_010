import { Container, Wrapper, LogoContainer, Logo } from "./Login.styled";
import GoogleButton from "../../components/googleButton/GoogleButton";
import InputBox from "../../components/inputBox/InputBox";
import stackLogo from "../../common/image/stack-overflow-logo.png";

function Login() {
  return (
    <Container>
      <Wrapper>
        <LogoContainer>
          <Logo src={stackLogo} />
        </LogoContainer>
        <GoogleButton />
        <InputBox />
        
      </Wrapper>
    </Container>
  );
}

export default Login;
