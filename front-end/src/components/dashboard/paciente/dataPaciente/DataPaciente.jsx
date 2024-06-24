import React, { useState, useEffect } from 'react';
//import { decode as jwtDecode } from 'jwt-decode'; // Usar la importación con nombre
//import jwtDecode from 'jwt-decode'; // Importación por defecto
import { jwtDecode } from "jwt-decode";
import "./DataPaciente.css";
import { FaUserCircle } from 'react-icons/fa';

const DataPaciente = () => {
  const [paciente, setPaciente] = useState(null);

  useEffect(() => {
    const traerPaciente = async () => {
      const token = localStorage.getItem('jwtToken');
      if (!token) {
        console.error('No se encontró el token');
        return;
      }

      try {
        const decodedToken = jwtDecode(token);
        const id = decodedToken.id; // Asumiendo que el token contiene un campo `id` que identifica al paciente

        const response = await fetch(`https://c18-36-ft-java-react.onrender.com/paciente/seleccionar/${id}`, {
          headers: {
            Authorization: `Bearer ${token}`
          }
        });

        if (!response.ok) {
          throw new Error('Network response was not ok');
        }

        const data = await response.json();
        setPaciente(data);
        console.log(data)
      } catch (error) {
        console.error('Hubo un error al obtener los datos del paciente:', error);
      }
    };

    traerPaciente();
  }, []);

  if (!paciente) {
    return <div>Cargando...</div>;
  }

  return (
    <div className="data-card">
      <div className="pic-paciente">
        <FaUserCircle size={100} color="#1d4738" /> 
      </div>
      <div className="info">
        <h2 className='name-paciente'>{paciente.nombre} {paciente.apellido}</h2>
        <p><strong>Edad:</strong> {paciente.telefono} años</p>
        <p><strong>Ubicación:</strong> {paciente.email}</p>
        <p><strong>Terapia:</strong> {paciente.documento}</p>
        <p><strong>Atendido por:</strong> {paciente.nombre}</p>
        <hr className="divider" />
      </div>
    </div>
  );
};

export default DataPaciente;


// import React from 'react';
// import "./DataPaciente.css"
// import { FaUserCircle } from 'react-icons/fa';

// const HomePaciente = () => {
//   return (
//     <div className="data-card">
//       <div className="pic-paciente">
//         <FaUserCircle size={100} color="#1d4738" /> 
//       </div>
//       <div className="info">
//         <h2 className='name-paciente'>Juan Perez</h2>
//         <p><strong>Edad:</strong> 26 años</p>
//         <p><strong>Ubicación:</strong> Bs As, Argentina</p>
//         <p><strong>Terapia:</strong> cognitivo-conductual</p>
//         <p><strong>Atendido por:</strong> María Marta Gomez</p>
//         <hr className="divider" />
//       </div>

//     </div>
//   );
// };

// export default HomePaciente;