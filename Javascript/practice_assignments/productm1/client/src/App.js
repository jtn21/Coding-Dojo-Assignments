
import './App.css';
import Dashboard from './views/Dashboard'
import {Routes, Route, Link} from "react-router-dom"
import CreatePage from './views/CreatePage';
import Details from './views/Details';
import UpdatePage from './views/UpdatePage';
import Main from './views/Main';

function App() {
  return (
    <div className="App">
      <div>
        <Link to ="/dashboard">Dashboard</Link>
      </div>
      <Link to ="/product/new">Create new product</Link>
      {/* the routes is for local 3000 */}
      <Routes>
        <Route path="/dashboard" element={<Dashboard/>}/>
        <Route path="/" element ={<Main />}/>
        <Route path="/product/new" element={<CreatePage/>}/>
        <Route path="/product/:id" element={<Details/>}/>
        <Route path="/product/:id/edit" element={<UpdatePage/>}/>



      </Routes>
    
    </div>
  );
}

export default App;
