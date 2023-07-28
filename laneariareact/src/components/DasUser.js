import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

const Dashboard = ({userId}) => {
  return (
    <div>
      <h2>Welcome to the Dashboard</h2>
        <div className="App">
            <h1>Aplicación de Hoteles y vuelos</h1>
            <nav>
            <Link to="/dashBoardUser/reservaHotel">Reservar Hotel</Link>
            <Link to="/dashBoardUser/reservaVuelo">Reservar Vuelo</Link>
            <Link to="/dashBoardUser/gestionReserva">Gestionar Reserva</Link>
            </nav>
        </div>
    </div>
  );
};

export default Dashboard;