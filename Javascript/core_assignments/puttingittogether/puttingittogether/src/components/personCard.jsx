import React, { Component } from 'react';

class PersonCard extends Component{
    constructor(props){
        super(props)
        this.state = {
            age : this.props.age
        }
    }
    render(){
// const below is destructuring so now need to do this.props.xxxxx
        const {firstName, lastName, hairColor } =this.props
        return(
            <div>
                <h1>{lastName}, {firstName} </h1>
{/* this.state.age will allow you to change the age by using the onclick function below */}
                <h3>Age : {this.state.age} </h3>
                <h3>Hair Color: {hairColor}</h3>
                <button onClick={() => this.setState({age: this.state.age + 1})}>Birthday Button for {firstName} {lastName}</button>
            </div>



        );
    }
}

export default PersonCard;