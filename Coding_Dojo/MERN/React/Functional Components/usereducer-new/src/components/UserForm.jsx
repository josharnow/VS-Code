// (1A)
import React, { useRef, useReducer, useState } from 'react'; // Imports useReducer hook

// (2A)
const initialState = { // Creates initialState object with desired key/value pairs
  firstName: { // KEY
    value: '', // Initial VALUE set to empty string
    error: null
  },
  lastName: { // KEY
    value: '', // Initial VALUE set to empty string
    error: null
  },
  email: { // KEY
    value: '', // Initial VALUE set to empty string
    error: null
  }
}

// (3A)
function reducer(state, action) { // Creates a reducer function which takes in the state and an action object.
  return { // Returns a new state object (not a mutation of original) using the current state and the given action object.
    ...state, // Spread operator is used to clone the current state
    [action.type]: action.payload // Overrides the specific piece of state we want to alter with the new value (the action's payload value)
  };
}

// Functional component
const UserForm = () => {
// const UserForm = (props) => {

// (1B)
  const [state, dispatch] = useReducer(reducer, initialState); // Invokes the useReducer function by passing in our reducer function and the initialState object

// (2B)
  function handleChange(e) { // Creates a handleChange function which takes in an event
    const { name, value } = e.target; // Destructures the name and value from the event's target, which will be one of the inputs
// (3B)
    dispatch({ // Calls the dispatch function (returned when we invoked the useReducer hook) by passing it an object with a type equal to the input's name and a payload equal to the input's new value
      type: name,
      payload: value
    });
  }

  function validateFirstName(firstName) {
    if (firstName.length >= 3) {
      return true;
    } else {

    }
  }

  // function validateEmail(emailAddress) {
  //   if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(emailAddress)) {
  //     state.firstName.error = null;
  //     return true;
  //   } else {
  //     alert("You have entered an invalid email address!");
  //     state.firstName.error = "This is your error";
  //     return false;
  //   }
  // }

  function handleSubmit(e) {
    e.preventDefault();
    validateFirstName(e.firstName.value)
    // validateEmail(state.email.value);
  }

// useRef (example 1)
  const myRef = useRef(null);
  function focusInput() {
    const node = myRef.current;
    // input.current.focus();
    node.focus();
  }

// useRef (example 2)
  const canvas = useRef(null);
  const [xVal, setXVal] = useState(0);
  const [yVal, setYVal] = useState(0);
  const [color, setColor] = useState('black');

  function drawSquare(color, x, y) {
    const node = canvas.current;
    const ctx = node.getContext('2d');

    ctx.fillStyle = color;
    ctx.fillRect(x, y, 100, 100);
  }

// (4B)
  return ( // Renders JSX
    <React.Fragment>
      <p>State: { JSON.stringify(state) }</p>  {/* Stringifies our state object to easily keep track of it */}
    <form onSubmit={ handleSubmit }>
      <div> {/* Individual <div> for each input */}
        <label>
          <span>First Name: </span>
          <input // Contains three attributes
            name="firstName" // Matches with appropriate name in initialState object
            // value={ state.firstName } // Value is derived from the state object
            value={ state.firstName.value } // Value is derived from the state object

            onChange={ handleChange } // Set to invoke the handleChange function created above
          />
          { state.firstName.error && ( // If error is not null, the error will conditionally render here
            <p className="error">{ state.firstName.error }</p>
          ) }
        </label>
      </div>
      <div> {/* Individual <div> for each input */}
        <label>
          <span>Last Name: </span>
          <input // Contains three attributes
            name="lastName" // Matches with appropriate name in initialState object
            // value={ state.lastName } // Value is derived from the state object
            value={ state.lastName.value } // Value is derived from the state object

            onChange={ handleChange } // Set to invoke the handleChange function created above
          />
          { state.lastName.error && ( // If error is not null, the error will conditionally render here
            <p className="error">{ state.lastName.error }</p>
          ) }
        </label>
      </div>
      <div> {/* Individual <div> for each input */}
        <label>
          <span>Email: </span>
          <input // Contains three attributes
            name="email" // Matches with appropriate name in initialState object
            // value={ state.email } // Value is derived from the state object
            value={ state.email.value }// Value is derived from the state object
            onChange={ handleChange } // Set to invoke the handleChange function created above
          />
          { state.email.error && ( // If error is not null, the error will conditionally render here
            <p className="error">{ state.email.error }</p>
          ) }
        </label>
      </div>
      <button type="submit">Submit</button>
    </form>

{/* useRef example 1*/}
      <input ref={myRef}/>
      <button onClick={focusInput}>Focus Me!</button>
{/* useRef example 2*/ }
      <canvas ref={ canvas } height="400" width="400" />
      <div>
        <label>X Coordinate</label>
        <input
          type="number"
          min="0"
          max="200"
          onChange={ e => setXVal(+e.target.value) }
          value={ xVal }
        />
      </div>
      <div>
        <label>Y Coordinate</label>
        <input
          type="number"
          min="0"
          max="200"
          onChange={ e => setYVal(+e.target.value) }
          value={ yVal }
        />
      </div>
      <select
        onChange={ e => setColor(e.target.value) }
        value={ color }
      >
        <option value="black">black</option>
        <option value="blue">blue</option>
        <option value="red">red</option>
      </select>
      <div>
        <button onClick={ () => drawSquare(color, xVal, yVal) }>Draw!</button>
      </div>

    </React.Fragment>
  );
}
export default UserForm;








// const UserForm = (props) => {
//   const [firstName, setFirstName] = useState("");
//   const [lastName, setLastName] = useState("");
//   const [email, setEmail] = useState("");
//   const [password, setPassword] = useState("");
//   const [confirmPassword, setConfirmPassword] = useState("");
//   const [hasBeenSubmitted, setHasBeenSubmitted] = useState(false);
//   const [firstNameError, setFirstNameError] = useState(false);
//   const [lastNameError, setLastNameError] = useState(false);
//   const [emailError, setEmailError] = useState(false);
//   const [passwordError, setPasswordError] = useState(false);
//   const [confirmPasswordError, setConfirmPasswordError] = useState(false);

//   const createUser = (e) => {
//     e.preventDefault(); // Prevents autosubmitting the information to the route in the "action" which causes a page load.
//     const newUser = { firstName, lastName, email, password };
//     console.log("Welcome", newUser);
//     setHasBeenSubmitted( true );
//     setFirstName("");
//     setLastName("");
//     setEmail("");
//     setPassword("");
//     setConfirmPassword("");
//   };

//   // const formMessage = () => {
//   //   if (hasBeenSubmitted) {
//   //     return "Thank you for submitting the form!";
//   //   } else {
//   //     return "Welcome, please submit the form";
//   //   }
//   // };

//   const handleFirstName = (e) => {
//     setFirstName(e.target.value);
//     if (e.target.value.length < 1) {
//       setFirstNameError("First name is required!");
//     } else if (e.target.value.length < 2) {
//       setFirstNameError("First name must be 2 characters or longer!");
//     } else {
//       setFirstNameError(false);
//     }
//   }
//   const handleLastName = (e) => {
//     setLastName(e.target.value);
//     if (e.target.value.length < 1) {
//       setLastNameError("Last name is required!");
//     } else if (e.target.value.length < 2) {
//       setLastNameError("Last name must be 2 characters or longer!");
//     } else {
//       setLastNameError(false);
//     }
//   }
//   const handleEmail = (e) => {
//     setEmail(e.target.value);
//     if (e.target.value.length < 1) {
//       setEmailError("Email is required!");
//     } else if (e.target.value.length < 5) {
//       setEmailError("Email must be 5 characters or longer!");
//     } else {
//       setEmailError(false);
//     }
//   }
//   const handlePassword = (e) => {
//     setPassword(e.target.value);
//     if (e.target.value.length < 1) {
//       setPasswordError("Password is required!");
//     } else if (e.target.value.length < 8) {
//       setPasswordError("Password must be 8 characters or longer!");
//     } else {
//       setPasswordError(false);
//     }
//   }
//   const handleConfirmPassword = (e) => {
//     setConfirmPassword(e.target.value);
//     if (password !== confirmPassword) {
//       setConfirmPasswordError("Passwords must match!");
//     } else {
//       setConfirmPasswordError(false);
//     }
//   }

//   return (
//     <form onSubmit={ createUser }>
//       {/* <h3>{ formMessage() }</h3> */}
//       {
//         hasBeenSubmitted ?
//           <h3>Thank you for submitting the form!</h3> :
//           <h3>Welcome, please submit the form.</h3>
//       }
//       <div>
//         <label>First Name: </label>
//         <input type="text" onChange={ handleFirstName } value={ firstName } />
//         {
//           firstNameError
//           ? <p style={ { color: 'red' } }>{ firstNameError }</p>
//           : ''
//         }
//       </div>
//       <div>
//         <label>Last Name: </label>
//         <input type="text" onChange={ handleLastName } value={ lastName } />
//         {
//           lastNameError
//             ? <p style={ { color: 'red' } }>{ lastNameError }</p>
//             : ''
//         }
//       </div>
//       <div>
//         <label>Email: </label>
//         <input type="email" onChange={ handleEmail } value={ email } />
//         {
//           emailError
//             ? <p style={ { color: 'red' } }>{ emailError }</p>
//             : ''
//         }
//       </div>
//       <div>
//         <label>Password: </label>
//         <input type="password" onChange={ handlePassword } value={ password } />
//         {
//           passwordError
//             ? <p style={ { color: 'red' } }>{ passwordError }</p>
//             : ''
//         }
//       </div>
//       <div>
//         <label>Confirm Password: </label>
//         <input type="password" onChange={ handleConfirmPassword } value={ confirmPassword } />
//         {
//           confirmPasswordError
//             ? <p style={ { color: 'red' } }>{ confirmPasswordError }</p>
//             : ''
//         }
//       </div>
//       <input type="submit" value="Create User" />
//     </form>
//   );
// };

// export default UserForm;