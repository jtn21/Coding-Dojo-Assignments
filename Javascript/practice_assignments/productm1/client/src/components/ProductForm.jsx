import React, {useState} from 'react'
import axios from 'axios'
import { useNavigate} from "react-router-dom"

const ProductForm = (props) => {
    const [title,setTitle] = useState("")
    const [price,setPrice] = useState("")
    const [description, setDescription] = useState("")

    const navigate = useNavigate()

    const handleSubmit = (e) =>{
        e.preventDefault()
        axios.post(`http://localhost:8000/api/product`, {title,price,description})
            .then(res=>{
                navigate("/dashboard")
            })
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
        <button type='submit'>Create</button>
    </form>
    )
}

export default ProductForm