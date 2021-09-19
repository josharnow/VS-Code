import React from 'react';
import './App.css';
import Header from './components/Header';
import Navigation from './components/Navigation';
import Main from './components/Main';
import SubContents from './components/SubContents';
import Advertisement from './components/Advertisement';

// function iterateComponent(ComponentName, quantity) {
//   let componentArr = [];
//   let i = 0;
//   while (i < quantity) {
//     // componentArr += `<${ComponentName} />`;
//     componentArr += ComponentName;
//     ++i;
//   }
//   return `<${componentArr} />`;

// }

function App() {
  return (
    <div className="box">
      <Header />
      <div className="flex">
        <Navigation />
        <Main>
          <div className="flex center">
            <SubContents />
            <SubContents />
            <SubContents />
            {/* {iterateComponent(SubContents, 2)} */}
            {/* {listItems} */}
            {/* {<SubContents /> * 3} */}
          </div>
          <Advertisement />
        </Main>
      </div>
    </div>
  );
}

export default App;