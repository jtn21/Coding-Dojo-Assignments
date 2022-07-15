import React, {useState} from 'react';
import DisplayTodo from './DisplayTodo';
import TodoForm from './TodoForm';

const TodoContainer = () => {
    const [items,setItems] = useState([])
    

    const receiveNewTodo =(newTodo) =>{
        setItems([...items, newTodo])
    }

    const updateTodos = (updatedTodos) =>{
        setItems(updatedTodos)
    }

    return (
        <div>
            <TodoForm  onNewTodo = {receiveNewTodo}/>
            <DisplayTodo items = {items} onTodoUpdate = {updateTodos}/>
        </div>

    )
}

export default TodoContainer