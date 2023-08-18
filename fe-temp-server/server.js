const {USER_DATA} =require('./db/data');
const cors = require('cors');
const express = require('express');
const app = express();
const port = 4000;

app.use(cors());
app.use(express.json());
// 루트 경로에 대한 요청 처리
app.get('/', (req, res) => {
  res.send(USER_DATA);
});

app.post('/', (req, res) => {
    const receivedData = req.body;
    console.log(receivedData);
      
    if (receivedData) {
     
      res.json(receivedData);
    } else {
      res.status(400).json({ error: '데이터가 유효하지 않습니다.' });
    }
  });

// 서버 시작
app.listen(port, () => {
  console.log(`서버가 http://localhost:${port} 에서 실행 중입니다.`);
});
