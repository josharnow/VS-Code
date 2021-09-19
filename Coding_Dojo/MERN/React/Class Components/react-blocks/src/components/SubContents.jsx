import React, { Component } from "react";
import styles from "./SubContents.module.css";

class SubContents extends Component {
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
      <div className={styles.box}>
        {children}
      </div>
    );
  }
}

export default SubContents;