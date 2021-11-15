import React from 'react'
import axios from 'axios';
import { Link } from "react-router-dom";
import styles from "./ProductList.module.css";

const ProductList = (props) => {
  const { removeFromDom } = props;

  const deleteProduct = (id) => {
    axios.delete(`http://localhost:8000/api/products/${id}`)
      .then(res => {
        removeFromDom(id)
      })
      .catch(err => console.error(err));
  }

  const products = props.products.products;

  const viewList = products.map((product, i) => <Link to={product._id} key={i}>{product.title}</Link>)
  
  const editList = products.map((product, i) => <Link to={product._id + "/edit"} key={ i }>{ product.title }</Link>)
  
  // const deleteList = products.map((product, i) => <Link to={ product._id + "/delete" } key={ i }>{ product.title }</Link>)
  
  const deleteList = products.map((product, idx) => {
    return <p key={ idx }>
      <Link to={ "/" + product._id }>
        { product.title }
      </Link>
      |
      <Link to={ "/" + product._id + "/edit"}>
        <button>Edit</button>
      </Link>
      <button onClick={ (e) => { deleteProduct(product._id) } }>
        Delete
      </button>
    </p>
  })
  
  
  // function handleDelete(e) {
    //   const product = props.product.product;
    //   // const { title, price, description } = state;
    //   product && console.log(product._id)
    //   // const { title, price, description } = e.target;
    //   e.preventDefault();
    
    //   // console.log(e.target)
    
    //   axios.delete(`http://localhost:8000/api/products/${product._id}`, {
      //     title,
      //     price,
      //     description
      //   })
      //     .then(res => console.log(res))
      //     .catch(err => console.error(err));
      //   handleErrors(e);
      // }
      
      return (
        <div>
        <div className={ styles.list }>
          <h2>View Product</h2>
          { viewList }
        </div>
        <div className={ styles.list }>
          <h2>Edit Product</h2>
          { editList }
        </div>
        <div className={ styles.list }>
          <h2>Delete Product</h2>
          { deleteList }
        </div>
      </div>
  )
}

export default ProductList;