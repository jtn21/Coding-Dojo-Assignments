import React, {useEffect,useState} from 'react'
import axios from 'axios'
import AuthorForm from '../components/AuthorForm'
import DisplayTable from '../components/DisplayTable'

const Main = () => {
    const [authorlist, setAuthorList] = useState([])
    const [refresh,setRefresh] = useState(true)

    const refreshList=()=>{
        setRefresh(!refresh)
    }

    useEffect(()=>{
        axios.get(`http://localhost:8000/api/author`)
        .then(res=>setAuthorList(res.data))
        .catch(err=>console.log(err))
    },[refresh])



    return (
    <div>
        <AuthorForm updateList={refreshList}/>
        <DisplayTable authorlist={authorlist}/>
    </div>
    )
}

export default Main