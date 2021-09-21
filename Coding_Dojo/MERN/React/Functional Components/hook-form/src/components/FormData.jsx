import React, { useState } from 'react';
// import UserForm from './UserForm';

const FormData = (props) => {

  return (
    <React.Fragment key={ null }>
      <p>Your Form Data</p>
      <div>
        <p>First Name</p>
        <p>{ props.firstName }</p>
      </div>
      <div>
        <p>Last Name</p>
        <p>{ props.lastName }</p>
      </div>
      <div>
        <p>Email</p>
        <p>{ props.email}</p>
      </div>
      <div>
        <p>Password</p>
        <p>{ props.password }</p>
      </div>
      <div>
        <p>Confirm Password</p>
        <p>{ props.confirmPassword }</p>
      </div>
    </React.Fragment>
  );
};

export default FormData;