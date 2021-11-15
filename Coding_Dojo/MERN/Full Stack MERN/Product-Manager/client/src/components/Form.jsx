import React, { useReducer, useState } from 'react';
import axios from 'axios';
import styles from "./Form.module.css";

const initialState = {
  title: '',
  price: '',
  description: ''
  };

const initialError = {
  title: true,
  price: true,
  description: true
  };

// function init(initialError) {
//   return { count: initialCount };
// }
  
function reducer(state, action) {
  return {
    ...state,
    [action.type]: action.payload
  };
}

const Form = () => {
  // const [titleError, setTitleError] = useState(null);
  // const [priceError, setPriceError] = useState(null);
  // const [descriptionError, setDescriptionError] = useState(null);

  const [state, dispatch] = useReducer(reducer, initialState);
  // const [error] = useReducer(reducer, initialError);
  const [error, errorDispatch] = useReducer(reducer, initialError);

  
  function handleChange(e) {
    const { name, value } = e.target;
    dispatch({
      type: name,
      payload: value
    });
  }

  function handleErrors(e) {
    const { title, price, description } = state;
    const { name, value } = e.target; // for error useReducer

    let isError = true;
    // let errorCount = {
    //   title: 0,
    //   price: 0,
    //   description: 0
    // };
    
    // Validations
    if (!title) {
      error.title = "Title is required!";
      // setTitleError("Title is required!");
      // errorCount.title = 1;
    } else if (title.length < 10) {
      error.title = "Title must be at least 10 characters long!";
      // setTitleError("Title must be at least 10 characters long!");
      // errorCount.title = 1;
    } else {
      error.title = false;
      // setTitleError(null);
      // errorCount.title = 0;
    }
    
    if (!price) {
      error.price = "Price is required!";
      // setPriceError("Price is required!");
      // errorCount.price = 1;
    } else if (price < 0.01) {
      error.price = "Price must be at least $0.01!";
      // setPriceError("Price must be at least $0.01!");
      // errorCount.price = 1;
    } else {
      error.price = false;
      // setPriceError(null);
      // errorCount.price = 0;
    }
    
    if (!description) {
      error.description = "Description is required!";
      // setDescriptionError("Description is required!");
      // errorCount.description = 1;
    } else if (description.length < 10) {
      error.description = "Description must be at least 10 characters long!";
      // setDescriptionError("Description must be at least 10 characters long!");
      // errorCount.description = 1;
    } else {
      error.description = false;
      // setDescriptionError(null);
      // errorCount.description = 0;
    }

    // const findValues = obj => Object.values(obj).reduce((a, b) => a + b);

    // const sumValues = obj => Object.values(obj).reduce((a, b) => a + b);
    // console.log(sumValues(errorCount))
    // console.log(sumValues(error))
    // console.log(Object.values(error))
    // console.log(!Object.values(error.title))

    // !sumValues(error)
    //   && (isError = false)

    if (!error.title && !error.price && !error.description) {
      isError = false;
    }

    console.log("Error: ", isError)
    
    // dispatch({ // for error useReducer
    //   type: name,
    //   payload: value
    // });

    errorDispatch({ // for error useReducer
      type: name,
      payload: value
    });

    console.log("Errors: ", error);

    return isError;
    // !isError
      // && 
  }
  
  function handleSubmit(e) {
    const { title, price, description } = state;
    // const validator = handleErrors(e);

    e.preventDefault(); // Prevents default behavior of the submit
    
    // handleErrors(e);
    console.log(handleErrors(e))
    // console.log("submit error:", error)
    // console.log(error === null)
    
    axios.post('http://localhost:8000/api/products', { // Make a post request to create a new product
    title,
    price,
    description
    })
    .then(res => console.log(res))
    .catch(err => console.log(err))

    if (!handleErrors(e)) { // resets form inputs to initial states upon successful form submission
      state.title = initialState.title;
      state.price = initialState.price;
      state.description = initialState.description;
    }
  }

return (
  <React.Fragment>
    {/* { JSON.stringify(state) } */ }
      { JSON.stringify(error) }
      <form onSubmit={ handleSubmit } className={ styles.form }>
          <div className={ styles.formBox }>
            <label htmlFor='title'>Title</label>
              <input
                name="title"
                value={ state.title }
                onChange={ handleChange }
                type="text"
                id='title'
              />
          </div>
          {
            error.title
            // titleError 
              && <p className={ styles.error }>{ error.title }</p>
              // && <p className={ styles.error }>{ titleError }</p>
          }
          <div className={ styles.formBox }>
            <label htmlFor='price'>Price</label>
              <input
                name="price"
                value={ state.price }
                onChange={ handleChange }
                type="number"
                step="0.01"
                min="0"
                id='price'
              />
          </div>
          {
            error.price
            // priceError
              && <p className={ styles.error }>{ error.price }</p>
            // && <p className={ styles.error }>{ priceError }</p>
          }
          <div className={ styles.formBox }>
            <label htmlFor='description'>Description</label>
              <input
                name="description"
                value={ state.description }
                onChange={ handleChange }
                type="text"
                id='description'
              />
          </div>
          {
            error.description
            // descriptionError
              && <p className={ styles.error }>{ error.description }</p>
            // && <p className={ styles.error }>{ descriptionError }</p>
          }
          <button type='submit' className={ styles.formButton }>Create</button>
      </form>
    </React.Fragment>
  );
}
export default Form;

              // import React, { useState } from 'react'
              // import axios from 'axios';
              
              // const Form = () => {
              //   //keep track of what is being typed via useState hook
              //   const [title, setTitle] = useState("");
              //   const [price, setPrice] = useState("");
              //   const [description, setDescription] = useState("");
              
              //   //handler when the form is submitted
              //   function handleSubmit(e) {
              //     //prevent default behavior of the submit
              //     e.preventDefault();
              //     //make a post request to create a new person
              //     axios.post('http://localhost:8000/api/products', {
              //       title,
              //       price,
              //       description
              //     })
              //       .then(res => console.log(res))
              //       .catch(err => console.log(err))
              //   }
              //   //onChange to update firstName and lastName
              //   return (
              //     <form onSubmit={ handleSubmit }>
              //       <p>
              //         <label>Title</label>
              //         <input type="text" onChange={ (e) => setTitle(e.target.value) } value={ title } />
              //       </p>
              //       <p>
              //         <label>Price</label>
              //         <input type="number" onChange={ (e) => setPrice(e.target.value) } value={ price } />
              //       </p>
              //       <p>
              //         <label>Description</label>
              //         <input type="text" onChange={ (e) => setDescription(e.target.value) } value={ description } />
              //       </p>
              //       <input type="submit" />
              //     </form>
              //   )
              // }
              // export default Form;