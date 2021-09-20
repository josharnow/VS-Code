import React from 'react';

const PersonCard = props => {
    return (
        <React.Fragment key={null}>
            <h1>{props.lastName}, {props.firstName}</h1>
            <p>Age: {props.age}</p>
            <p>Hair Color: {props.hairColor}</p>
        </React.Fragment>
    );
}

export default PersonCard;