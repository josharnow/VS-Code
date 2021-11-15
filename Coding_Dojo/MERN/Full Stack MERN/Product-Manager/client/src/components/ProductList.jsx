import React from 'react'
import axios from 'axios';
import styles from "./ProductList.module.css";

const ProductList = (props) => {
  // const list = props.products.map(item => `<li>${item}</li>`);
  // const list = props.products.map((product, i) => `<p key={ i }>{
  // product.title }, { product.price}, { product.description }</p>`);

  // console.log(props.products.products)
  const list = props.products.products.map((product, i) => <a href={product._id} key={i}>{product.title}</a>)
  

  return (
      <div className={ styles.list }>
        { list }
      </div>
  )
}
export default ProductList;