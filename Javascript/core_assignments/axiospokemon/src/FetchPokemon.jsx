import React, {useState} from 'react'
import axios from "axios"

const FetchPokemon = () => {
    
    const [pokemon,setPokemon] = useState([])
    

    const fetchPokemon = () =>{
        axios.get(`https://pokeapi.co/api/v2/pokemon/`)
        .then(response =>setPokemon(response.data.results))
        .catch(err=>console.log(err))
    };

    return (
    <div>
        <h1>FetchPokemon</h1>
        <button onClick={fetchPokemon}>Fetch Pokemon</button>
        <div>
        <h1>Name: {pokemon.map((pokemonName,i)=>{
            return(<div key={i}>{pokemonName.name}</div>)
        })}  </h1>
        </div>
    </div>
    
    )
}

export default FetchPokemon