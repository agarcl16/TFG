import React, { useState } from 'react';
import axios from 'axios';

const RegisterForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    // Crear un objeto con los datos del usuario a registrar
    const newUser = {
      username: username,
      password: password,
    };

    // Enviar la petición POST al backend para registrar al usuario
    axios.post('http://localhost:8080/api/register', newUser)
      .then(response => {
        console.log('Usuario registrado:', response.data);
        // Limpiar los campos del formulario después de registrar al usuario
        setUsername('');
        setPassword('');
      })
      .catch(error => {
        console.error('Error al registrar al usuario:', error);
      });
  };

  return (
    <div>
      <h2>Registro</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Nombre de usuario:</label>
          <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
        </div>
        <div>
          <label>Contraseña:</label>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        </div>
        <button type="submit">Registrarse</button>
      </form>
    </div>
  );
};

export default RegisterForm;