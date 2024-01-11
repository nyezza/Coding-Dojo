import {Routes,Route} from 'react-router-dom'
import LoginRegistration from './components/login/LoginRegistration';
import './App.css';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' Component={<LoginRegistration />}/>
      </Routes>
    </div>
  );
}

export default App;
