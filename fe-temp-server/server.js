const {USER_DATA} =require('./db/data');
const cors = require('cors');
const express = require('express');
const app = express();
const port = 4000;

app.use(cors());
// 루트 경로에 대한 요청 처리
app.get('/', (req, res) => {
  res.send(USER_DATA);
});

// 서버 시작
app.listen(port, () => {
  console.log(`서버가 http://localhost:${port} 에서 실행 중입니다.`);
});
