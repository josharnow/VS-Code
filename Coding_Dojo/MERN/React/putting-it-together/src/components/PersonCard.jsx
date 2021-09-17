import React, { Component } from "react";

class PersonCard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            age: this.props.age
        };
    }

    // this.setState((state) => {
    //     return { quantity: state.age + 1 };
    // });

    // flipSwitch = () => {
    //     if (this.state.position === "On") {
    //         this.setState({ position: "Off" });
    //     } else {
    //         this.setState({ position: "On" });
    //     }
    // }

    ageUp = () => {
        // this.setState({age: this.props.age + 1});
        this.setState((state) => {
            return { age: state.age + 1 };
        });
    }

    render() {
        const { firstName, lastName, hairColor } = this.props;
        const { age } = this.state;
        return (
            <>
                <h1>{lastName}, {firstName}</h1>
                <p>Age: {age}</p>
                <p>Hair Color: {hairColor}</p>
                <button onClick={this.ageUp}>Birthday Button for {firstName} {lastName}</button>
            </>
        );
    }
}

export default PersonCard;