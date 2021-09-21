import './App.css';
// import 'bootstrap/dist/css/bootstrap.min.css';
// import { Provider } from 'styletron-react';
// import { Client as Styletron } from 'styletron-engine-atomic';

import UserForm from './components/UserForm';
import FormData from './components/FormData';

// const engine = new Styletron()

// const { firstName, lastName, email, password, confirmPassword } = UserForm;

// console.log(`${firstName}`)
// let data = [
//   { "firstName": { firstName }, "lastName": { lastName }, "email": { email }, "password": { password }, "confirmPassword": {confirmPassword } }
// ]

const data = UserForm["firstName"];


// {newUser}

function App() {
  return (
      <div className="App">
        <UserForm />
        <FormData />
        {console.log(data)}
      </div>

  );
}

export default App;