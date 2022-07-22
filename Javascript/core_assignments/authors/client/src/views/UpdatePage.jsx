import axios from 'axios'
import React, {useState,useEffect} from 'react'
import {useParams,useNavigate} from "react-router-dom"


const UpdatePage = () => {
    const [name,setName] = useState("")
    const [errors, setErrors] = useState([])

    const{id} = useParams()
    const navigate = useNavigate()

    useEffect(()=>{
        axios.get(`http://localhost:8000/api/author/${id}`)
            .then(res=>{
                const author = res.data
                setName(author.name)
            })
            .catch(err=>console.log(err))
    },[])


    const handleSubmit = (e)=>{
        e.preventDefault()
        axios.put(`http://localhost:8000/api/author/${id}`, {name})
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
        <h2>Edit the Author</h2>
        <form onSubmit={handleSubmit}>
            <h3>
                <label>Author Name:</label>
                <input type="text" name="name" value={name} onChange={e=>setName(e.target.value)}/>
            </h3>
            <button type='submit'>Update Author</button>
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

export default UpdatePage
