import React, { useState } from 'react';

const UserForm = (props) => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [hasBeenSubmitted, setHasBeenSubmitted] = useState(false);
  const [firstNameError, setFirstNameError] = useState(false);
  const [lastNameError, setLastNameError] = useState(false);
  const [emailError, setEmailError] = useState(false);
  const [passwordError, setPasswordError] = useState(false);
  const [confirmPasswordError, setConfirmPasswordError] = useState(false);

  const createUser = (e) => {
    e.preventDefault(); // Prevents autosubmitting the information to the route in the "action" which causes a page load.
    const newUser = { firstName, lastName, email, password };
    console.log("Welcome", newUser);
    setHasBeenSubmitted( true );
    setFirstName("");
    setLastName("");
    setEmail("");
    setPassword("");
    setConfirmPassword("");
  };

  // const formMessage = () => {
  //   if (hasBeenSubmitted) {
  //     return "Thank you for submitting the form!";
  //   } else {
  //     return "Welcome, please submit the form";
  //   }
  // };

  const handleFirstName = (e) => {
    setFirstName(e.target.value);
    if (e.target.value.length < 1) {
      setFirstNameError("First name is required!");
    } else if (e.target.value.length < 2) {
      setFirstNameError("First name must be 2 characters or longer!");
    } else {
      setFirstNameError(false);
    }
  }
  const handleLastName = (e) => {
    setLastName(e.target.value);
    if (e.target.value.length < 1) {
      setLastNameError("Last name is required!");
    } else if (e.target.value.length < 2) {
      setLastNameError("Last name must be 2 characters or longer!");
    } else {
      setLastNameError(false);
    }
  }
  const handleEmail = (e) => {
    setEmail(e.target.value);
    if (e.target.value.length < 1) {
      setEmailError("Email is required!");
    } else if (e.target.value.length < 5) {
      setEmailError("Email must be 5 characters or longer!");
    } else {
      setEmailError(false);
    }
  }
  const handlePassword = (e) => {
    setPassword(e.target.value);
    if (e.target.value.length < 1) {
      setPasswordError("Password is required!");
    } else if (e.target.value.length < 8) {
      setPasswordError("Password must be 8 characters or longer!");
    } else {
      setPasswordError(false);
    }
  }
  const handleConfirmPassword = (e) => {
    setConfirmPassword(e.target.value);
    if (password !== confirmPassword) {
      setConfirmPasswordError("Passwords must match!");
    } else {
      setConfirmPasswordError(false);
    }
  }

  return (
    <form onSubmit={ createUser }>
      {/* <h3>{ formMessage() }</h3> */}
      {
        hasBeenSubmitted ?
          <h3>Thank you for submitting the form!</h3> :
          <h3>Welcome, please submit the form.</h3>
      }
      <div>
        <label>First Name: </label>
        <input type="text" onChange={ handleFirstName } value={ firstName } />
        {
          firstNameError
          ? <p style={ { color: 'red' } }>{ firstNameError }</p>
          : ''
        }
      </div>
      <div>
        <label>Last Name: </label>
        <input type="text" onChange={ handleLastName } value={ lastName } />
        {
          lastNameError
            ? <p style={ { color: 'red' } }>{ lastNameError }</p>
            : ''
        }
      </div>
      <div>
        <label>Email: </label>
        <input type="email" onChange={ handleEmail } value={ email } />
        {
          emailError
            ? <p style={ { color: 'red' } }>{ emailError }</p>
            : ''
        }
      </div>
      <div>
        <label>Password: </label>
        <input type="password" onChange={ handlePassword } value={ password } />
        {
          passwordError
            ? <p style={ { color: 'red' } }>{ passwordError }</p>
            : ''
        }
      </div>
      <div>
        <label>Confirm Password: </label>
        <input type="password" onChange={ handleConfirmPassword } value={ confirmPassword } />
        {
          confirmPasswordError
            ? <p style={ { color: 'red' } }>{ confirmPasswordError }</p>
            : ''
        }
      </div>
      <input type="submit" value="Create User" />
    </form>
  );
};

export default UserForm;