import { Container, Wrapper, LogoContainer, Logo } from "./Login.styled";
import GoogleButton from "../../components/login/GoogleButton";
import InputBox from "../../components/login/InputBox";

function Login() {
  return (
    <Container>
      <Wrapper>
        <LogoContainer>
          <Logo src="stack-overflow-logo.png" />
        </LogoContainer>
        <GoogleButton />
        <InputBox />
      </Wrapper>
    </Container>
  );
}

export default Login;
