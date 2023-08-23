import styled from "styled-components";

const Footer = () => {
  return (
    <FooterStyle>
      <FooterCon>
        <img src="logo_w.png" alt="로고 아이콘" />
        <CorTxt>© 2023 team. HEXA Coder</CorTxt>
      </FooterCon>
    </FooterStyle>
  );
};
export default Footer;

const FooterStyle = styled.footer`
  background-color: #23262a;
  height: 50px;
`;

const FooterCon = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 50px;
  max-width: 1240px;
  padding: 0 20px;
  margin: 0 auto;
  > img {
    height: 30px;
  }
`;

const CorTxt = styled.span`
  color: #fff;
  font-size: 12px;
  font-weight: 100;
`;
