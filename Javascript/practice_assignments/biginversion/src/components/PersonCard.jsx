import React, {Component} from 'react';


const PersonCard = props => {
    return(
        <div>
            <h1> {props.lastName}, {props.firstName}</h1>
            <h2> Age: {props.age} </h2>
            <h2> Hair Color: {props.hairColor} </h2>
        </div>
    );
}

export default PersonCard;