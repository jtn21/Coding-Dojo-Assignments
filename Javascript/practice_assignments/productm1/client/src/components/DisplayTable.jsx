import React, {useEffect, useState} from 'react'
import axios from 'axios'
import {Link} from "react-router-dom"


const DisplayTable = (props) => {

    const handleDelete = (deleteId) =>{
        axios.delete(`http://localhost:8000/api/product/${deleteId}`)
            .then(res=>props.updateList(deleteId))
            .catch(err=>console.log(err))
    }

    return (
    <div>
        {
            props.productlist.map((product,i)=>{
                return(
                    <div>
                        <h4 key={i}><Link to={`/product/${product._id}`}>{product.title}</Link></h4>
                        <h6><Link to={`/product/${product._id}/edit`}>Edit</Link></h6>
                        <button onClick={()=>handleDelete(product._id)}>Delete</button>
                    </div>
                )
            })
        }
    </div>
    )
}

export default DisplayTable