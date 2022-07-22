import React, {useEffect, useState} from 'react'
import DisplayTable from '../components/DisplayTable'
import axios from 'axios'

const Dashboard = () => {

    const [authorlist, setAuthorList] = useState([])

    useEffect(()=>{
        axios.get(`http://localhost:8000/api/author`)
            .then(res=>setAuthorList(res.data))
            .catch(err=>console.log(err))
    },[])

    const removeFromList= (deleteId) =>{
        const filteredList = authorlist.filter((eachAuthor, i)=>{
            return(
                eachAuthor._id !== deleteId
            )
        })
        setAuthorList(filteredList)
    }



    return (
    <div>
        {
            authorlist?
            <DisplayTable authorlist={authorlist} updateList={removeFromList}/>:
            <h1>No authors here</h1>
        }
    </div>
    )
}

export default Dashboard