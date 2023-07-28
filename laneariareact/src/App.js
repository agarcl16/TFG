import React, { useState } from 'react';
import './App.css';
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from 'react-router-dom';
import RegisterForm from './components/RegisterForm';
import LoginForm from './components/LoginForm';
import DasAdmin from './components/DasAdmin';
import AddHotel from './components/AddHotelsForm';
import DasUser from './components/DasUser';
import ReservaHotel from './components/ReservaHotel';
import ReservaVuelo from './components/ReservaVuelo';
import GestionReserva from './components/GestionReserva';
import axios from 'axios';

function App() {
  const [userId, setUserId] = React.useState(null);
  const navigate = useNavigate();

  const handleLogin = async (username, password) => {
    // Validación básica del usuario y la contraseña
    if (username === 'admin' && password === 'admin') {
      navigate('/dashBoardAdmin');
    } else {
      try {
        const usuario = {
          name: username,
          password: password,
        };
        const response = await axios.post('http://localhost:8080/apirest/user', usuario);
  
        // Si la solicitud es exitosa, actualiza el estado del usuario y redirecciona al Dashboard
        setUserId(response.data);
        if(response.data!==null)
        navigate('/dashBoardUser');
        else console.log('No existe el usuario');
      } catch (error) {
        console.log('error');
      }
    }
  };
  return (
    <div className="App">
      <h1>LANEARIA</h1>
      <Routes>
        <Route path="/" element={
      <nav>
        <Link to="/registro">Registro</Link>
        <Link to="/login">Login</Link>
      </nav>} />
        <Route path="/registro" element={<RegisterForm />} />
        <Route path="/login" element={<LoginForm handleLogin={handleLogin} />} />
        <Route path="/dashBoardAdmin" element={<DasAdmin />} />
        <Route path="/dashBoardAdmin/addHotel" element={<AddHotel />} />
        <Route path="/dashBoardUser" element={<DasUser userId={userId} />} />
        <Route
          path="/dashBoardUser/reservaHotel"
          element={<ReservaHotel userId={userId}/>}
        />
        <Route
          path="/dashBoardUser/reservaVuelo"
          element={<ReservaVuelo userId={userId}/>}
        />
        <Route
          path="/dashBoardUser/gestionReserva"
          element={<GestionReserva userId={userId}/>}
        />
      </Routes>
    </div>
  );
}
/*
<Router>
      <div className="App">
        <h1>Aplicación de Hoteles y vuelos</h1>
        <nav>
          <Link to="/añadir-hotel">Añadir Hotel</Link>
        </nav>
        <Routes>
          <Route path="/añadir-hotel" element={<AddHotelForm />} />
          <Route path="/" element={<HotelList />} />
        </Routes>
      </div>
    </Router>
    */

export default App;