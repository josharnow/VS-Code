import React from 'react';
import './App.css';
import Main from './views/Main';
import Detail from './views/Detail';
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      {/* <Main /> */}

      {/* <Detail /> */}

      <Routes>
        <Route path="/" element={ <Main /> } />
        <Route path="/:id" element={ <Detail/> } />
      </Routes>
    </BrowserRouter>
  );
}
export default App;

      // <BrowserRouter>
      //   <h1>Routing Example</h1>
      //   <p>
      //     <Link to="/">Home</Link>
      //     |
      //     <Link to="about">About</Link>
      //   </p>
      //   <p>
      //     <Link to="/location/seattle">Seattle</Link>
      //     &nbsp;|&nbsp;
      //     <Link to="/location/chicago">Chicago</Link>
      //     &nbsp;|&nbsp;
      //     <Link to="/location/burbank">Burbank</Link>
      //   </p>
      //   <Routes>
      //     <Route path="about/*" element={ <About /> } />
      //     <Route path="/" element={ <Home /> } />
      //     <Route path="/location/:city" element={ <Location /> } />
      //   </Routes>

      // </BrowserRouter>