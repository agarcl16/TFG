import axios from 'axios';
import React, { useEffect, useState } from 'react';

const ReservaVuelo = ({ userId }) => {
  const [fecha, setFecha] = useState('');
  const [origen, setOrigen] = useState('');
  const [destino, setDestino] = useState('');
  const [num, setNum] = useState('');
  const [vuelos, setVuelos] = useState([]);
  const [usuario, setUsuario] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
  };

  const handleChange = (e) => {
    e.preventDefault();
    
    axios.get('http://localhost:8080/api/vuelos/'+origen+'/'+destino+'/'+fecha)
      .then((response) => {
        setVuelos(response.data);
      })
      .catch((error) => {
        console.error('Error al obtener la lista de vuelos:', error);
      });
    
  };

  const handleReservar = (vuelo) => {
    
    axios.get('http://localhost:8080/apirest/'+userId)
      .then((response) => {
        console.log('Usuario encontrado: ',response.data)
        setUsuario(response.data);
      })
      .catch((error) => {
        console.error('Error al obtener usuario:', error);
      });
      
    // Crear un objeto con los datos de la nueva reserva
    const newReserva = {
        vuelo : vuelo,
        user : usuario,
        personas : num,
      };

      console.log(newReserva);
    
    axios.post('http://localhost:8080/api/reservaVuelo',newReserva)
      .then((response) => {
        console.log('reserva creada:', response.data)
      })
      .catch((error) => {
        console.error('Error al insertar reserva:', error);
      });
  };

  return (
    <div>
      <h2>Reservar Vuelo</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Fecha:</label>
          <input type="text" value={fecha} onChange={(e) => setFecha(e.target.value)} />
        </div>
        <div>
          <label>Origen:</label>
          <input type="text" value={origen} onChange={(e) => setOrigen(e.target.value)} />
        </div>
        <div>
          <label>Destino:</label>
          <input type="text" value={destino} onChange={(e) => setDestino(e.target.value)} />
        </div>
        <div>
          <label>Número de personas:</label>
          <input type="text" value={num} onChange={(e) => setNum(e.target.value)} />
        </div>
        <button type="submit" onClick={handleChange}>Buscar</button>
        <div>
            <h3>Listado:</h3>
            <ul>
                {vuelos.map((vuelo) => (
                <li key={vuelo.id}>
                    {vuelo.origen} - {vuelo.destino} - {vuelo.fecha} - {vuelo.hora}
                    <button onClick={() => handleReservar(vuelo)}>Reservar</button>
                </li>
                ))}
            </ul>
        </div>
      </form>
    </div>
  );
};

export default ReservaVuelo;