import React, {useState} from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const AuthorForm = (props) => {
    const [name,setName] = useState("")
    const navigate = useNavigate()
    const [errors, setErrors] = useState([])

    const handleSubmit = (e)=>{
        e.preventDefault()
        axios.post(`http://localhost:8000/api/author`, {name})
            .then(res=>{
                navigate("/dashboard")
            })
            .catch(err=>{
                const errMsgArr = []
                const errResponse = err.response.data.errors
                for(const eachKey in errResponse){
                    errMsgArr.push(errResponse[eachKey].message)
                }
                setErrors(errMsgArr)
            })
    }

    const navigateDashboard = (e)=>{
        navigate('/dashboard')
    }



    return (
        <div>
            <h2>Create Author</h2>
            <form onSubmit={handleSubmit}>
                <h3>
                    <label>Author Name:</label>
                    <input type="text" name="name" value={name} onChange={e=>setName(e.target.value)}/>
                </h3>
                <button type='submit'>Add Author</button>
                <button onClick={navigateDashboard}>Cancel</button>
            </form>
            {
                errors.map((err,i)=>{
                    return(
                        <p style={{color: "red"}} key={i}>{err}</p> 
                    )
                })
            }
        </div>
    )
}

export default AuthorForm