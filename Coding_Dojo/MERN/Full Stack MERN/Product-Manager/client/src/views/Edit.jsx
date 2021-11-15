import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, Link } from "react-router-dom";
import Product from '../components/Product';
import Form from '../components/Form';

const Edit = (props) => {
  const [product, setProduct] = useState({})
  const [loaded, setLoaded] = useState(false);
  const { id } = useParams();

  // const list = props.products.products.map((product, i) => <a href={ product._id } key={ i }>{ product.title }</a>)
  // const details = 
  // console.log(props)

  useEffect(() => {
    axios.get(`http://localhost:8000/api/products/${id}`)
      .then(res => {
        setProduct(res.data);
        setLoaded(true);
      })
      .catch(err => console.error(err));
  }, []);
  // console.log(product.title)

  return (
    <React.Fragment>
      {/* { loaded && <Product product={ product } /> } */}
      { loaded && <Form product={ product } id={ id } />}
      <Link to="/">Go Home</Link>
    </React.Fragment>
  )
}
export default Edit;