import React, { useReducer } from 'react';

const initialState = {
  firstName: {
    value: '',
    error: null
  },
  lastName: {
    value: '',
    error: null
  },
  email: {
    value: '',
    error: null
  },
  password: {
    value: '',
    error: null
  },
  confirmPassword: {
    value: '',
    error: null
  }
};

function reducer(state, action) {
  return {
    ...state,
    [action.type]: action.payload
  };
}

function handleChange(e) {
  const { name, value } = e.target;
  dispatch({
    type: name,
    payload: value
  });
  
  if (name === state.firstName) {
    console.log(state.firstName);
    handleFirstName(e);
  }
}

const UserForm = () => {
  const [state, dispatch] = useReducer(reducer, initialState);

  const handleFirstName = (e) => {
    // setFirstName(e.target.value);
    if (e.target.value.length < 1) {
      state.firstName.error("First name is required!");
        console.log(state.firstName.error)
    } else if (e.target.value.length < 2) {
      state.firstName.error("First name must be 2 characters or longer!");
    } else {
      state.firstName.error(null);
    }
  }
  const handleLastName = (e) => {
    // setLastName(e.target.value);
    if (e.target.value.length < 1) {
      state.lastName.error("Last name is required!");
    } else if (e.target.value.length < 2) {
      state.lastName.error("Last name must be 2 characters or longer!");
    } else {
      state.lastName.error(null);
    }
  }
  const handleEmail = (e) => {
    // setEmail(e.target.value);
    if (e.target.value.length < 1) {
      state.email.error("Email is required!");
    } else if (e.target.value.length < 5) {
      state.email.error("Email must be 5 characters or longer!");
    } else {
      state.email.error(null);
    }
  }
  const handlePassword = (e) => {
    // setPassword(e.target.value);
    if (e.target.value.length < 1) {
      state.password.error("Password is required!");
    } else if (e.target.value.length < 8) {
      state.password.error("Password must be 8 characters or longer!");
    } else {
      state.password.error(null);
    }
  }
  const handleConfirmPassword = (e) => {
    // setConfirmPassword(e.target.value);
    if (e.target.value !== state.password.value) {
      state.password.error("Passwords must match!");
    } else {
      state.password.error(null);
    }
  }

  return (
    <div>
      { JSON.stringify(state) }
      <div>
        <label>
          <span>First Name:</span>{ ' ' }
          <input
            name="firstName"
            type="text"
            value={ state.firstName.value }
            onChange={ handleChange }
          />
        </label>
      </div>
        {
          state.firstName.error !== null && (
            <p className="error" style={{color: 'black'}}>{ state.firstName.error }</p>
          )
        }
      <div>
        <label>
          <span>Last Name:</span>{ ' ' }
          <input
            name="lastName"
            type="text"
            value={ state.lastName.value }
            onChange={ handleChange }
          />
        </label>
      </div>
      <div>
        <label>
          <span>Email:</span>{ ' ' }
          <input
            name="email"
            type="email"
            value={ state.email.value }
            onChange={ handleChange }
          />
        </label>
      </div>
      <div>
        <label>
          <span>Password:</span>{ ' ' }
          <input
            name="password"
            type="password"
            value={ state.password.value }
            onChange={ handleChange }
          />
        </label>
      </div>
      <div>
        <label>
          <span>Confirm Password:</span>{ ' ' }
          <input
            name="confirmPassword"
            type="password"
            value={ state.confirmPassword.value }
            onChange={ handleChange }
          />
        </label>
      </div>
    </div>
  );
};

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