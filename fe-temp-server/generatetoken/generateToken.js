const jwt = require('jsonwebtoken');

// 시크릿 키, 이 키는 서버와 클라이언트 간에 안전하게 보관되어야 합니다.
const secretKey = 'your-secret-key';

// 사용자 정보 (이 예제에서는 간단한 객체로 가정합니다)
const user = {
  id: 123,
  username: 'john_doe',
  role: 'user'
};

// JWT 생성
const token = jwt.sign(user, secretKey, { expiresIn: '1h' });

console.log('Generated Token:', token);

// 생성된 토큰을 검증
jwt.verify(token, secretKey, (err, decoded) => {
  if (err) {
    console.error('Token verification failed:', err);
  } else {
    console.log('Decoded Token:', decoded);
  }
});
