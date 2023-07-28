import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

const Dashboard = () => {
  return (
    <div>
      <h2>Welcome to the Dashboard</h2>
        <div className="App">
            <h1>Aplicación de Hoteles y vuelos</h1>
            <nav>
            <Link to="/dashBoardAdmin/addHotel">Gestionar Hoteles</Link>
            <Link to="/dashBoardAdmin/addHotel">Gestionar Vuelos</Link>
            <Link to="/dashBoardAdmin/addHotel">Gestionar Usuarios</Link>
            </nav>
        </div>
    </div>
  );
};

export default Dashboard;