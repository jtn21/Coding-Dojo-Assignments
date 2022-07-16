import React, {useState, useEffect} from 'react'
import axios from 'axios'
import {useParams} from 'react-router-dom'

const Species = () => {

    const {id} = useParams()

    const [species,setSpecies] = useState([])

    useEffect(()=>{
        axios.get(`https://swapi.dev/api/species/${id}`)
        .then(response=>{
            setSpecies(response.data)
        .catch(err=>console.log(err))
        })
        
    },[id])





    return (
    <div>
        {
            species&&
            <div>
                <h1>{species.name}</h1>
                <h3>{species.classification}</h3>
                <h3>{species.designation}</h3>
                <h3>{species.average_height}</h3>
                <h3>{species.homeworld}</h3>
            </div>
        }
    </div>
    )
}

export default Species