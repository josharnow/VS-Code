import React from 'react'
import Form from '../components/Form';

function Main() {
  // const [message, setMessage] = useState("Loading...")
  // useEffect(() => {
  //   axios.get("http://localhost:8000/api")
  //   .then(res => setMessage(res.data.message))
  // }, []);
  return (
    <React.Fragment>
      {/* <h2>Message from the backend: { message }</h2> */}
      <h1 className='text-center'>Product Manager</h1>
      <Form />
    </React.Fragment>
        )
      }
  export default Main;