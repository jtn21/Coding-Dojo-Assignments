import './App.css';
import CreatePage from './views/CreatePage';
import Dashboard from './views/Dashboard';
import Details from './views/Details';
import UpdatePage from './views/UpdatePage';
import {Routes, Route, Link} from 'react-router-dom'
import Main from './views/Main'


function App() {
  return (
    <div className="App">
      <h1> Favorite authors</h1>
        <Link to ="/dashboard">Dashboard</Link>
        <Link to ="/author/new">Add new Author</Link>

        <Routes>
          <Route path="/dashboard" element={<Dashboard/>}/>
          <Route path="/author/new" element={<CreatePage/>}/>
          <Route path="/author/:id" element={<Details/>}/>
          <Route path="/author/:id/edit" element={<UpdatePage/>}/>
          <Route path="/" element={<Main/>}/>
        </Routes>
    </div>

  );
}

export default App;
