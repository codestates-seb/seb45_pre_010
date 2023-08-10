import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./Reset.css";

import Header from "./components/Header";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Header />
        <Routes>{/* <Route path="/" element={<Main />} /> */}</Routes>
        {/* <Footer></Footer> */}
      </div>
    </BrowserRouter>
  );
}

export default App;
