import React, {useState, useEffect} from 'react'
import axios from 'axios'
import {useParams} from 'react-router-dom'

const Starships = () => {

    const{id} = useParams()

    const [starships,setStarships] = useState([])

    useEffect(()=>{
        axios.get(`https://swapi.dev/api/starships/${id}`)
        .then(response=>{
            setStarships(response.data)
        .catch(err=>console.log(err))
        })
    },[id])


    return (
    <div>
        {
            starships&&
            <div>
                <h1>{starships.name}</h1>
                <h3>Model: {starships.model}</h3>
                <h3>Manufacturer: {starships.manufacturer}</h3>
                <h3>Starship Class: {starships.starship_class}</h3>
            </div>
        }



    </div>
    )
}

export default Starships