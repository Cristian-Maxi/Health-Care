import React from "react";
import "./Profesionales.css";
import ProfesionalCard from "../profesionalCard/ProfesionalCard";
import Data from "../../Data"; // Asegúrate de que Data.js exporte los datos de los psicólogos

const Profesionales = () => {
  return (
    <div className="consulta-container">
    <h2 className="consulta-title">Profesionales</h2>
    <div className="professional-list">
      {Data.map((professional, index) => (
        <ProfesionalCard
          key={index}
          nombre={professional.nombre}
          apellido={professional.apellido}
          especialidad={professional.especialidad}
          valoracion={professional.valoracion}
          descripcion={professional.descripcion}
        />
      ))}
    </div>
  </div>
    // <div>
    //   <h2>Profesionales</h2>
    //   <div className="professional-list">
    //     {Data.map(professional => (
    //       <ProfesionalCard
    //         key={professional.id}
    //         nombre={professional.nombre}
    //         apellido={professional.apellido}
    //         especialidad={professional.especialidad}
    //         valoracion={professional.valoracion}
    //         descripcion={professional.descripcion}
    //       />
    //     ))}
    //   </div>
    // </div>
  );
};

export default Profesionales;


// import React from "react";
// import "./Profesionales.css"
// import ProfesionalCard from "../profesionalCard/ProfesionalCard";
// import Data from "../../Data.js"

// const Profesionales = ()=>{

//     return(
//         <div>
//             <h2>Profesionales </h2>
//             <ProfesionalCard> </ProfesionalCard>
//         </div>
//     )
// }

// export default Profesionales