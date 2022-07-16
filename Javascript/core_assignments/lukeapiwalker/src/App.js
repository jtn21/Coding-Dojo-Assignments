
import './App.css';
import HeaderForm from './components/HeaderForm';
import Planets from './views/Planets';
import People from './views/People';
import {Route,Routes} from 'react-router-dom'
import Starships from './views/Starships';
import Species from './views/Species';


const ErrorPage = () =>{
  return(
    <div>
      <h1>These aren't the droids you're looking for</h1>
      <img src="https://cdn.vox-cdn.com/thumbor/ma_wD4f3W99qmBnojCMxjBxdkbk=/0x0:1919x803/920x613/filters:focal(807x249:1113x555):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/70918122/image_2022_05_27_143301304.0.png" alt="obiwan"/>
    </div>

  )
}

function App() {
  return (
    <div>
      <h1>Luke Walker API</h1>
      <HeaderForm/>

      <Routes>
        <Route path ="/planets/:id" element={<Planets/>} />
        <Route path="/people/:id" element={<People/>} />
        <Route path="/starships/:id" element={<Starships/>}/>
        <Route path="/species/:id" element={<Species/>}/>
        <Route path="*" element={<ErrorPage/>}/>
      </Routes>



    </div>
  );
}

export default App;
