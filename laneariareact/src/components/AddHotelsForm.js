import axios from 'axios';
import React, { useEffect, useState } from 'react';

const AddHotelForm = () => {
  const [name, setName] = useState('');
  const [location, setLocation] = useState('');
  const [hoteles, setHoteles] = useState([]);

  useEffect(() => {
    // Llamada a la API para obtener la lista de hoteles
    axios.get('http://localhost:8080/api/hoteles')
      .then((response) => {
        setHoteles(response.data);
      })
      .catch((error) => {
        console.error('Error al obtener la lista de hoteles:', error);
      });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    // Crear un objeto con los datos del nuevo hotel
    const newHotel = {
      nombre: name,
      ubicacion: location,
    };

    // Enviar la petición POST al backend para añadir el hotel
    axios.post('http://localhost:8080/api/hoteles', newHotel)
      .then(response => {
        console.log('Hotel añadido:', response.data);
        // Limpiar los campos del formulario después de añadir el hotel
        setName('');
        setLocation('');
      })
      .catch(error => {
        console.error('Error al añadir el hotel:', error);
      });
  };

  return (
    <div>
      <h2>Añadir Hotel</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Nombre del Hotel:</label>
          <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        </div>
        <div>
          <label>Ubicación:</label>
          <input type="text" value={location} onChange={(e) => setLocation(e.target.value)} />
        </div>
        <button type="submit">Añadir Hotel</button>
      </form>
      <h2>Lista de Hoteles</h2>
      <ul>
        {hoteles.map((hotel) => (
          <li key={hotel.id}>
            {hotel.nombre} - {hotel.ubicacion}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AddHotelForm;