import { Container, Wrapper, LogoContainer, Logo, SignUpText, SignUpLink } from "./Login.styled";
import GoogleButton from "../../components/login/GoogleButton";
import InputBox from "../../components/login/InputBox";

function Login({setIsLogin, setToken}) {
  return (
    <Container>
      <Wrapper>
        <LogoContainer>
          <Logo src="stack-overflow-logo.png" />
        </LogoContainer>
        <GoogleButton />
        <InputBox setIsLogin={setIsLogin} setToken={setToken}/>
        <div>
          <SignUpText>Don't you have acount?
            <SignUpLink href={'http://localhost:3000/signup'} >
              Sign up
            </SignUpLink>
          </SignUpText>
        </div>
      </Wrapper>
    </Container>
  );
}

export default Login;
