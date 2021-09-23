import React, { useEffect, useState } from 'react';

export default function Pokemon() {
  const [state, setState] = useState(0);
  const [submitted, setSubmitted] = useState({
    isSubmitted: false
  });
  
  const onSubmitHandler = e => {
    e.preventDefault();
    console.log(`Changing state from ${submitted.isSubmitted}`);
    submitted.isSubmitted
      ? setSubmitted({ isSubmitted: false })
      : setSubmitted({ isSubmitted: true });
    // console.log(`State following click: ${}`);
  }

  useEffect(() => {
    fetch('https://pokeapi.co/api/v2/pokemon')
      .then(res => res.json())
      .then(res => setState({ pokemons: res.results }))
      .catch(err => console.log(err));
  }, [submitted.isSubmitted]);

  return (
    <form onSubmit={ onSubmitHandler }>
      <button type="submit">Fetch Pokemon</button>

      {
        submitted.isSubmitted 
          && state.pokemons.map((pokemon, i) => {
            return (
              <ul>
                <li key={i}>{pokemon}</li>
              </ul>
            )})
      }

    </form>
  );
};

//   return (
//     {/* <h3>{ formMessage() }</h3> */ }
//     <button onClick={ clickHandler }>Fetch Pokemon</button>
//     // {if (state.isClicked === true) {
//     //   <p>TESTING</p>
//     // }}
//     {/* <h3>{ formMessage() }</h3> */ }
//     {
//       state.isClicked ?
//         <h3>Thank you for submitting the form!</h3> :
//         <h3>Welcome, please submit the form.</h3>
//     }
//   );
// }