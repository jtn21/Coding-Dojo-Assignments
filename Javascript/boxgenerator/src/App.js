import Boxform from './components/Boxform';
import './App.css';
import {useState} from 'react'

function App() {
  const [boxes, setBoxes] = useState([])
  const handleSubmit =(e,color) => {
    e.preventDefault();
    setBoxes([...boxes,color])
}
  return (
    <div className="App">
        <Boxform onSubmit = {handleSubmit}/>
        <div style={{display: 'flex', gap: 30 }}>{boxes.map((box,i)=><div key={i} style={{backgroundColor: box, width: '50px', height: '50px'}}></div>)}</div>
    </div> 
  );
}

export default App;
