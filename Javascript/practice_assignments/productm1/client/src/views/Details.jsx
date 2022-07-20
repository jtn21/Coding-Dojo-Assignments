import React,{useEffect, useState} from 'react'
import axios from "axios"
import {useParams, useNavigate} from "react-router-dom"

const Details = () => {

    const [product, setProduct] = useState()
    const {id} = useParams()
    const navigate = useNavigate()

    useEffect(()=>{
        axios.get(`http://localhost:8000/api/product/${id}`)
            .then(res=>setProduct(res.data))
            .catch(err=>console.log(err))
    },[])

    // change navigation to from dashboard
    const handleDelete = ()=>{
        axios.delete(`http://localhost:8000/api/product/${id}`)
            .then(res=>navigate("/dashboard"))
            .catc(err=>console.log(err))
    }

    return (
    <div>
        {   
            product?
            <div>
                <h1>Title: {product.title}</h1>
                <h1>Price: {product.price}</h1>
                <h1>Description: {product.description}</h1>
                <button onClick={handleDelete}>Delete</button>
            </div>:
            <h1>Product not available</h1>
        }
    </div>
    )
}

export default Details