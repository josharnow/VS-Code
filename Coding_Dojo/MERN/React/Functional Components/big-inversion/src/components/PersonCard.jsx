import React, { useState } from 'react';

const PersonCard = props => {
    const [state, setState] = useState({ age: props.age });

    const handleClick = () => {
        setState({
            age: state.age + 1
        });
    }

    return (
        <React.Fragment key={null}>
            <h1>{ props.lastName }, { props.firstName }</h1>
            <p>Age: { state.age }</p>
            <p>Hair Color: { props.hairColor }</p>
            <button onClick={ handleClick }>Birthday Button for { props.firstName } { props.lastName }</button>
        </React.Fragment>
    );
}

export default PersonCard;

// import React from 'react';

// const PersonCard = props => {
//     return (
//         <React.Fragment key={null}>
//             <h1>{props.lastName}, {props.firstName}</h1>
//             <p>Age: {props.age}</p>
//             <p>Hair Color: {props.hairColor}</p>
//         </React.Fragment>
//     );
// }

// export default PersonCard;