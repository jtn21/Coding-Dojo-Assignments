import React, {useState} from 'react'
import FetchDisplay from '../components/FetchDisplay'

const FetchPokemon = () => {

    const [pokemon, setPokemon] = useState([])

    const fetchPokemon = () => {
        fetch(`https://pokeapi.co/api/v2/pokemon/`)
            .then(response => {
                return response.json()
            })
            .then(jsonResponse => {
                //this will give you what you are getting
                console.log(jsonResponse)
                //jsonResponse --> grab results because lives inside the jsonResponse
                setPokemon(jsonResponse.results)
            })
            .catch(err=> console.log(err))
    }
    return (
    <div>
        <h1>Fetch That Pokemon</h1>
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
