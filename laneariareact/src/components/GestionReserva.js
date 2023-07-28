import axios from 'axios';
import React, { useEffect, useState } from 'react';

const GestionReserva = ({ userId }) => {
    const [vuelos, setVuelos] = useState([]);
    const [hoteles, setHoteles] = useState([]);

    useEffect(() => {
    axios.get('http://localhost:8080/api/reservaHotel/'+userId)
      .then((response) => {
        setHoteles(response.data);
      })
      .catch((error) => {
        console.error('Error al obtener la lista de hoteles:', error);
      });
      axios.get('http://localhost:8080/api/reservaVuelo/'+userId)
      .then((response) => {
        setVuelos(response.data);
      })
      .catch((error) => {
        console.error('Error al obtener la lista de hoteles:', error);
      });
    }, []);

  return (
    <div>
      <h2>Gestion de Reservas</h2>
        <div>
          <label>Reservas de Hoteles</label>
            <ul>
                {hoteles.map((hotel) => (
                <li key={hotel.id}>
                    Ubicacion: {hotel.hotel.ubicacion} Desde: {hotel.fechaDesde} - Hasta: {hotel.fechaHasta} - personas: {hotel.personas}
                </li>
                ))}
            </ul>
        </div>
        <div>
          <label>Reservas de vuelos</label>
            <ul>
                {vuelos.map((vuelo) => (
                <li key={vuelo.id}>
                    Origen: {vuelo.vuelo.origen} - Destino: {vuelo.vuelo.destino} - Fecha: {vuelo.vuelo.fecha} - Hora: {vuelo.vuelo.fecha} - Persona: {vuelo.personas}
                </li>
                ))}
            </ul>
        </div>
    </div>
  );
};

export default GestionReserva;