import React from 'react'
import axios from 'axios'
import {Link} from "react-router-dom"

const DisplayTable = (props) => {

    const handleDelete = (deleteId)=>{
        axios.delete(`http://localhost:8000/api/author/${deleteId}`)
            .then(res=>props.updateList(deleteId))
            .catch(err=>console.log(err))
    }


    return (
    <div>
        {
            props.authorlist.map((author,i)=>{
                return(
                    <div>
                        <h4 key={i}><Link to={`/author/${author._id}`}>{author.name}</Link></h4>
                        <h6><Link to={`/author/${author._id}/edit`}>Edit</Link></h6>
                        <button onClick={()=>handleDelete(author._id)}>Delete</button>
                    </div>
                )
            })
        }
    </div>
    )
}

export default DisplayTable