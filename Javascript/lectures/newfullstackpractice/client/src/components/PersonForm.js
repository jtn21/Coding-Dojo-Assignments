import React, {useState} from 'react'

import axios from 'axios'

const PersonForm = () => {
    const [firstName,setFirstName] = useState("");
    const [lastName,setLastName] = useState("");
    const handleSubmit = e =>{
        e.preventDefault();
        axios.post('http://localhost:8000/api/people', {
            firstName,
            lastName
        })
            .then(res=>console.log("Response: ", res))
            .catch(err=>console.log("Error: ", err))
    }

    return (
        <form onSubmit={handleSubmit}>
            <h3>
                <label>First Name</label>
                <input type="text" onChange={e=>setFirstName(e.target.value)}/>
            </h3>
            <h3>
            <label>Last Name</label>
                <input type="text" onChange={e=>setLastName(e.target.value)}/>
            </h3>
            <button>Submit</button>
        </form>
    )
}

export default PersonForm
