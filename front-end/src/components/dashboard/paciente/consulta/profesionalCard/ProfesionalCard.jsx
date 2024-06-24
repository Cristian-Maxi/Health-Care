// ProfessionalCard.js
import React from 'react';
import { FaUser } from 'react-icons/fa'; // Importa el icono de usuario de React Icons
import './ProfesionalCard.css'; // Asegúrate de crear y ajustar este archivo CSS según tus necesidades

const ProfesionalCard = ({ nombre, apellido, especialidad, valoracion, descripcion }) => {
  // const formattedEspecialidad = especialidad.replace(/_/g, ' ');
  const formattedEspecialidad = especialidad === 'MINDFULNESS_Y_TERAPIAS_BASADAS_EN_LA_ATENCIÓN_PLENA' 
    ? especialidad.split('_')[0] 
    : especialidad.replace(/_/g, ' ');



  const renderStars = () => {
    const totalStars = 5;
    let stars = [];
    for (let i = 1; i <= totalStars; i++) {
      stars.push(
        <span key={i} className={i <= valoracion ? 'star-filled' : 'star-empty'}>
          ★
        </span>
      );
    }
    return stars;
  };

  return (
    <div className="professional-card">
    <div className="card-header">
      <FaUser className="user-avatar" /> 
      <div className="user-info">
        <h3>{nombre} {apellido}</h3>
        <div className="specialties">
          <p className='subtitle'>Tipo de terapia:</p>
          <span className="specialty-tag">{formattedEspecialidad}</span>
        </div>
      </div>
    </div>
    <div className="card-body">
      <div className="reviews">
        <span className='subtitle'>Valoración: </span>
        <span className="stars">{renderStars()}</span>
        {/* <span>{'★'.repeat(valoracion)}</span> */}
      </div>
      <p className='subtitle'>Descripción :</p>
      <p className="description">{descripcion}</p>
      <button className="details-button">Agendar consulta</button>
    </div>
  </div>
  );
};

export default ProfesionalCard;



// import React from "react";
// import "./ProfesionalCard.css"

// const ProfesionalCard = ()=>{
//     return(
//         <div className="profesional-card">
//             <h2>Psicologo</h2>
//         </div>
//     )
// }

// export default ProfesionalCard