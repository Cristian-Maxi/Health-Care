import React from "react";
import "./EmotionCard.css"

const EmotionCard = ({ fechaCreacion, tipoEmocion, descripcion }) => {
  // Formatear la fecha según tus preferencias
  // const formattedDate = new Date(fechaCreacion).toLocaleDateString();
    // Obtener día, mes y año desde la fecha de creación
    const dateObject = new Date(fechaCreacion);
    const day = dateObject.getDate();
    const month = dateObject.getMonth() + 1; // Los meses van de 0 a 11 en JavaScript
    const year = dateObject.getFullYear();
  
    // Formatear la fecha en formato dd/mm/yyyy
    const formattedDate = `${day}/${month}/${year}`;

  return (
    <div className="emotionCard-container">
      <div className="info-emotion">
        <p><strong>Fecha:</strong> {formattedDate}</p>
        <strong>Nivel de ánimo:</strong>
        <span className="animo">{tipoEmocion}</span>
        <p><strong>Descripción:</strong> {descripcion}</p>
      </div>
    </div>
  );
}

export default EmotionCard;
// import React from "react";
// import "./EmotionCard.css"


// const EmotionCard = () =>{
// return(
//     <div className="emotionCard-container">
//         <div className="info-emotion">
       
//         <p><strong>Fecha:</strong> 03/05/2024</p>
//         <p><strong>Emoción</strong> Tristeza</p>
//         <p><strong>Descripción:</strong> bla bla bla bla bla</p>
        
       
//       </div>


//     </div>
// )
// }

// export default EmotionCard