import axios from "axios";
axios.defaults.withCredentials = true;

export const readData = async (pageNum) => {
  //${pageNum}
  try {
    const res = await axios.get(`http://localhost:8080/questions?page=1&size=10`);
    return res;
  } catch (e) {
    console.log(e);
  }
};
