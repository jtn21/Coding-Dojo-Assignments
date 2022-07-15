import React, {useState} from 'react'



const Display = (props) => {
    const [isDone, setIsDone] = useState(false)

    const handleDelete =(indexToDelete) =>{
        const filteredList = props.items.filter((element, i )=>{
            return i !== indexToDelete
        })
        console.log(filteredList)
        props.onTodoUpdate(filteredList)
    }

    const handleCheckone = (index)=>{
        const checkOne =props.items.map((eachItem,i)=>{
            if(index === i){
                eachItem.isDone = !eachItem.isDone;
            }
            return eachItem
        });
        setIsDone(checkOne);
    }




    return (
        <div>
            <h1>Things to do:</h1>
            {
                props.items.map((eachItem,i)=>{
                    return(
                        <div>
                        <h3 key={i} style={
                            eachItem.isDone?
                            {textDecoration: "line-through"}:{textDecoration: "underline"}
                            }>{eachItem.todo}</h3>
                            <input type="checkbox" name="isDone" checked={eachItem.isDone} onChange={e=>handleCheckone(e.target.checked)}/>
                            <button onClick={(e)=>handleDelete(i)}>Delete</button>
                        </div>
                    )
                })
            }

        </div>

    )
}


export default Display