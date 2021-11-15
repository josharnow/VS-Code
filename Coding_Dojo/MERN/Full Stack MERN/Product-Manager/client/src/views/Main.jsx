import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Form from '../components/Form';
import ProductList from '../components/ProductList';

function Main(props) {
  // const [message, setMessage] = useState("Loading...")
  // useEffect(() => {
  //   axios.get("http://localhost:8000/api")
  //   .then(res => setMessage(res.data.message))
  // }, []);
  // const [people, setPeople] = useState([]);
  // const [loaded, setLoaded] = useState(false);

  // useEffect(() => {
  //   axios.get('http://localhost:8000/api/people')
  //     .then(res => {
  //       setPeople(res.data);
  //       setLoaded(true);
  //     })
  //     .catch(err => console.error(err));
  // }, []);

  const [products, setProducts] = useState([]);
  const [loaded, setLoaded] = useState(false);

  useEffect(() => {
    axios.get('http://localhost:8000/api/products')
      .then(res => {
        setProducts(res.data);
        setLoaded(true);
      })
      .catch(err => console.error(err));
  }, []);

  return (
    <React.Fragment>
      {/* <h2>Message from the backend: { message }</h2> */}
      <Form />
      { loaded && <ProductList products={ products }/> }
    </React.Fragment>
        )
      }
  export default Main;