import React, { useEffect, useState } from 'react';
import axios from "axios";

export default function Pokemon() {
  const [pokemon, setPokemon] = useState([]);
  const [submitted, setSubmitted] = useState({
    isSubmitted: false
  });
  
  const onSubmitHandler = e => {
    e.preventDefault();
    axios.get("https://pokeapi.co/api/v2/pokemon")
      .then(res => {
        console.log(res.data.results);
        setPokemon(res.data.results);
      })
    // console.log(state.pokemon);
    console.log(`Changing state from ${submitted.isSubmitted}`);
    submitted.isSubmitted
      ? setSubmitted({ isSubmitted: false })
      : setSubmitted({ isSubmitted: true });
    // console.log(`State following click: ${}`);
  }


  
  // useEffect(() => {
  //   fetch(`https://pokeapi.co/api/v2/pokemon`)
  //     .then(res => res.json())
  //     .then(res => {
  //       console.log(res.data.results);
  //       setPokemon(res[0].pokemon);
  //     })
  //     .catch(err => console.log(err));
  // }, [submitted.isSubmitted]);

  return (
    <form onSubmit={ onSubmitHandler }>
      <button type="submit">Fetch Pokemon</button>

      <ul>
        {
          submitted.isSubmitted 
            && 
              pokemon.map((item, i) => {
                return (
                    <li key={ i }>{ item.name }</li>
                )})
        }
      </ul>

    </form>
  );
};