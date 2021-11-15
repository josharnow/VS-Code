import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams } from "react-router-dom";
import Product from '../components/Product';

const Detail = (props) => {
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
  // console.log(product.product)

  return (
    <React.Fragment>
      { loaded && <Product product={product}/> }
      <a href="/">Go Home</a>
    </React.Fragment>
  )
}
export default Detail;
