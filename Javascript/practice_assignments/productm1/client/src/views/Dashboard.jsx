import React, {useEffect, useState} from 'react'
import DisplayTable from '../components/DisplayTable'
import axios from 'axios'


const Dashboard = () => {
    const [productlist,setProductList] = useState([])

    useEffect(()=>{
        axios.get(`http://localhost:8000/api/product`)
            .then(res=> setProductList(res.data))
            .catch(err=>console.log(err))
    },[])

    const removeFromList = (deleteId) =>{
        const filteredList = productlist.filter((eachProduct, i)=>{
            return(
                eachProduct._id !== deleteId
            )
        })
        setProductList(filteredList)
    }

    return (
        <div>
            {
                productlist?
                <DisplayTable productlist={productlist} updateList={removeFromList}/>:
                <h1>No products now</h1>
            }
        </div>

    )
}

export default Dashboard