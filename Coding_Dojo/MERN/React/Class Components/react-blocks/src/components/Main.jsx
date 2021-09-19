import React, { Component } from "react";
import styles from "./Main.module.css";

class Main extends Component {
  constructor (props) {
    super(props);
    this.state = {
      // age: this.props.age
    };
  }

  render() {
    // const { firstName, lastName, hairColor } = this.props;
    // const { age } = this.state;
    const { children } = this.props;

    return (
      // <div className={`${styles.box} ${styles.flex}`}></div>
      <div className={styles.box}>
        {children}
      </div>
    );
  }
}

export default Main;