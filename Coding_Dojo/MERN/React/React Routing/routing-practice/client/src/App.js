import React from "react";
import { useParams } from "react-router";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
// The Switch component will act something like the stage of a play and when we go from one scene (route) to another it will change out what component(s) we see.
// The Route components will match the URLs using its path prop and only display
// its content if the prop matches.
// In v6, <Switch> elements are <Routes> instead

const Home = (props) => {
  return (
    <h1 style={ { color: "red" } }>Home Component</h1>
  );
}

const About = (props) => {
  return (
    <h1 style={ { color: "blue" } }>About Component</h1>
  );
}

const Location = (props) => {
  const { city } = useParams();

  return (
    <h1>Welcome to { city }!</h1>
  );
}

function App() {
  return (
    <BrowserRouter>
      <h1>Routing Example</h1>
      <p>
        <Link to="/">Home</Link>
        |
        <Link to="about">About</Link>
      </p>
      <p>
        <Link to="/location/seattle">Seattle</Link>
        &nbsp;|&nbsp;
        <Link to="/location/chicago">Chicago</Link>
        &nbsp;|&nbsp;
        <Link to="/location/burbank">Burbank</Link>
      </p>
      {/* <Switch> */}
      <Routes>
        <Route path="about/*" element={ <About /> } />
          {/* <About /> */}
        {/* </Route> */}
        {/* <Route exact path="/"> */}
        <Route path="/" element={ <Home /> } />
          {/* <Home /> */}
        {/* </Route> */}
        <Route path="/location/:city" element={ <Location /> } />
      </Routes>
      {/* </Switch> */}
    </BrowserRouter>
  );
}

export default App;
