import React, {useEffect, useState} from 'react'
import axios from "axios"
import { useParams, useNavigate, } from "react-router-dom"

const UpdatePage = () => {
    const[title,setTitle] = useState("")
    const[price,setPrice] = useState("")
    const[description,setDescription] = useState("")

    const {id} = useParams()
    const navigate = useNavigate()

    useEffect(()=> {
        axios.get(`http://localhost:8000/api/product/${id}`)
            .then(res => {
                const product = res.data
                setTitle(product.title)
                setPrice(product.price)
                setDescription(product.description)
            })
            .catch(err=> console.log(err))
    },[])

    //change navigation from dashboard
    const handleSubmit = (e) =>{
        e.preventDefault()
        axios.put(`http://localhost:8000/api/product/${id}`, {title, price, description})
            .then(res=>navigate("/"))
            .catch(err=>console.log(err))
    }


    return (
        <form onSubmit={handleSubmit}>
            <h3>
                <label>Title:</label>
                <input type="text" name="title" value={title} onChange={e=>setTitle(e.target.value)}/>
            </h3>
            <h3>
                <label>Price:</label>
                <input type="number" name="price" value={price} onChange={e=>setPrice(e.target.value)}/>
            </h3>
            <h3>
                <label>Description</label>
                <input type="text" name="description" value={description} onChange={e=>setDescription(e.target.value)}/>
            </h3>
            <button type='submit'>Update</button>
        </form>
    )
}

export default UpdatePage