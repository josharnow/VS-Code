import React from 'react'
import axios from 'axios';
// import styles from "./ProductList.module.css";


const Product = (props) => {
  // const list = props.products.map(item => `<li>${item}</li>`);
  // const list = props.products.map((product, i) => `<p key={ i }>{
  // product.title }, { product.price}, { product.description }</p>`);

  // console.log(props.products.products)

  // const list = props.product.product.map((value, i) => <a href={ value._id } key={ i }>{ value.title }</a>)
  
  // console.log(props.product.product)

  const product = props.product.product;
  console.log(product.title)
  // console.log(`${product.title}`)
  


  return (
    // <div className={ styles.list }>
    <React.Fragment>
      <p>Title: { product.title }</p>
      <p>Price: ${ product.price }</p>
      <p>Description: { product.description }</p>
    </React.Fragment>
  )
}
export default Product;