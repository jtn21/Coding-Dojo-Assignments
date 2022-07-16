import React, {useState, useEffect} from "react";
import axios from 'axios';
import {useParams} from 'react-router-dom';

const People = () => {

    const {id} = useParams()
    const [people,setPeople] = useState([])

    //useEffect is a function so no equal sign needed
    useEffect(() =>{
        axios.get(`https://swapi.dev/api/people/${id}`)
        .then(response => {
            setPeople(response.data)
        .catch(err=>console.log(err))
        })
    },[id])



    return (
    <div>
        {
            people&&
            <div>
                <h1>{people.name}</h1>
                <h3>Height: {people.height}</h3>
                <h3>Mass: {people.mass}</h3>
                <h3>Hair Color: {people.hair_color}</h3>
                <h3>Skin Color: {people.skin_color}</h3>
                <h3>Homeworld: {people.homeworld}</h3>


            </div>
        }
    </div>
    )
}

export default People