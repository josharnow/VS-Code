import React, { useEffect, useState } from 'react';
import { useHistory } from "react-router-dom";
import axios from "axios";

export default function Search() {
  const [selection, setSelection] = useState("");
  const [id, setID] = useState("");
  const [query, setQuery] = useState([]);
  // const history = useHistory();

  const handleQuery = e => {
    e.preventDefault();
    
    if (selection === "person" || selection === "") {
      axios.get("https://swapi.dev/api/people")
        .then(res => {
          console.log("person");
          console.log(res.data.results);
          setQuery(res.data.results);
        })
    } else if (selection === "planet") {
        axios.get("https://swapi.dev/api/planets")
          .then(res => {
            console.log("planet");
            console.log(res.data.results);
            setQuery(res.data.results);
          })
    } else {
      console.log("Check out the error!")
    }
    
    isNaN(id)
      ? console.log(`${id} is not a number`)
      : console.log(id)
    // history.push("/results");
  }


  return (
    <>
      <form onSubmit={ handleQuery }>
        <label htmlFor="dropdown">Search for:</label>
        <select id="dropdown" onChange={ (e) => setSelection(e.target.value) }>
          <option value="person">People</option>
          <option value="planet">Planets</option>
        </select>
          
        <label htmlFor="id">ID:</label>
        <input type="text" id="id" value={ id } onChange={ (e) => setID(e.target.value) }></input>

        <button type="submit">Search</button>

      </form>


      <h1>{ query[id].name }</h1>
      
        <p><b>Climate: </b>{ query[id].climate }</p>
        <p><b>Terrain: </b>{ query[id].terrain }</p>
        <p><b>Surface Water: </b>{ query[id].climate }</p>
        <p><b>Population: </b>{ query[id].population }</p>


        <ul>
          {
            isNaN(id) 
              ? console.log(`${id} is not a number`)
              : query.map((item, i) => {
                  return (
                    <>
                      <p>test</p>
                      <li key={ i }>{ item.name[id]}</li>
                    </>
                  )
                })
          }
        </ul>
      </>
  );
}