import React, {useState} from 'react'


const TodoForm = (props) => {
    const [todo,setTodo] = useState("")


    const handleSubmit = (e)=>{
        e.preventDefault()
        props.onNewTodo({todo})
    }


    return (
    <form onSubmit={handleSubmit}>
        <div>
            <label>Todo List</label>
            <input type="text" name="todo" value={todo} onChange={e=>setTodo(e.target.value)}/>
        </div>
        <button type="submit">Add todo</button>

    </form>


    )
}

export default TodoForm