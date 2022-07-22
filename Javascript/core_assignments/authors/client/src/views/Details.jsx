import axios from 'axios'
import React, {useState,useEffect} from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const Details = () => {
  const [author,setAuthor] = useState()
  const {id} = useParams()
  const navigate = useNavigate()

  useEffect(()=>{
    axios.get(`http://localhost:8000/api/author/${id}`)
      .then(res=>setAuthor(res.data))
      .catch(err=>console.log(err))
  },[])


  const handleDelete= ()=>{
    axios.delete(`http://localhost:8000/api/author/${id}`)
      .then(res=>navigate("/dashboard"))
      .catch(err=>console.log(err))
  }
  return (
    <div>
      {
        author?
        <div>
          <h1>Name: {author.name} </h1>
          <button onClick={handleDelete}>Delete</button>
        </div>:
        <h1> Author not available</h1>
      }
    </div>
  )
}

export default Details