import React from 'react'
import './App.css';
import PersonCard from './components/personCard';

const people = [
  {"firstName": "Jane", "lastName": "Doe", "age": 45, "hairColor": "Black"},
  {"firstName": "John", "lastName": "Smith", "age": 88, "hairColor": "Brown"},
]

function App() {
  return (
    <div className="App">

      {people.map(person => 
        <PersonCard firstName = {person.firstName} lastName = {person.lastName} age = {person.age} hairColor = {person.hairColor} />
        )}
    </div>
  );
}

export default App;
