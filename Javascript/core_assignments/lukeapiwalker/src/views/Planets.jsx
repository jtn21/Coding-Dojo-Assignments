import React, { useState, useEffect } from 'react'
import axios from 'axios'
import {useParams} from 'react-router-dom'

//1. get the id from params
//2. go to axios to get info from id
//3 useEffect to grab info 
//4. set state once jsonresponse


const Planets = () => {

    // get id from params
    const {id} = useParams()
    // set state for whatever we are trying to get. make it empty array
    const [planet,setPlanet] = useState([])
    // use --> ${} when using backticks `` in order to grab content
    useEffect(()=>{
        axios.get(`https://swapi.dev/api/planets/${id}`)
        .then(response=>{
            setPlanet(response.data)
        .catch(err => console.log(err))
        })
        
    //----> [id] allows us to change the page when changing the id for the api call
    },[id])

    //use the && to check to make sure if it is blank
    return (
    <div>
        
        {
            planet&&
            <div>
                <h1>{planet.name}</h1>
                <h3>Climate: {planet.climate}</h3>
                <h3>Terrain: {planet.terrain}</h3>
                <h3>Surface Water: {planet.surface_water}</h3>
                <h3>Population: {planet.population}</h3>
            </div>
        }


    </div>
    )
}

export default Planets