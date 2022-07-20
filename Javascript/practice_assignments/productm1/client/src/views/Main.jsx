import React, {useEffect, useState} from 'react'
import DisplayTable from '../components/DisplayTable'
import ProductForm from '../components/ProductForm'
import axios from 'axios'


const Main = () => {
    const [productlist, setProductList] = useState([])
    const [refresh, setRefresh] = useState(true)

    const refreshList=()=>{
        setRefresh(!refresh)
    }


    useEffect(()=>{
        axios.get(`http://localhost:8000/api/product`)
            .then(res=> setProductList(res.data))
            .catch(err=>console.log(err))
    },[refresh])



    return (
    <div>
        <ProductForm updateList={refreshList}/>
        <DisplayTable productlist={productlist}/>
    </div>
    )
}

export default Main