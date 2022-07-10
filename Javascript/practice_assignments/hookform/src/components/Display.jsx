import React from 'react'

const Display = (props) => {
    return (
        <div>
            <h1>Display</h1>
            <p>First Name: {props.firstname} </p>
            <p>Last Name: {props.lastname} </p>
            <p>Email: {props.email} </p>
            <p>Password: {props.password} </p>
            <p>Confirm Password: {props.confirmpw} </p>
        </div>
    )
}

export default Display