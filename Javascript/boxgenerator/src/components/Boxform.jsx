import React, {useState} from 'react'


const Boxform = ({onSubmit}) => {
    const[color, setColor] = useState("");

    return (
    <form onSubmit ={e=>onSubmit(e, color)} >
        <label>Please type in a color:</label>
        <input type="text" onChange={(e)=>setColor(e.target.value)} value={color}/>
        <button type="submit">Add</button>
    </form>
    );
};

export default Boxform