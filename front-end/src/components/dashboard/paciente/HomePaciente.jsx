import React from 'react';
import Sidebar from '../sidebar/Sidebar';
import './HomePaciente.css';
import DataPaciente from './dataPaciente/DataPaciente';
import DailyEmotions from './dailyEmotions/DailyEmotions';
import Turnos from "./turnos/Turnos";

const HomePaciente = () => {
  return (
    <div className="dashboard-paciente">
      <Sidebar />
      <div className="content">
        <div className="data-paciente">
          <DataPaciente />
        </div>
        <div className='daily-part'>
          <DailyEmotions />
        </div>
        <div className='turnos-part'>
          <Turnos />
        </div>
      </div>
    </div>
  );
};

export default HomePaciente;



// import React from 'react';
// import Sidebar from '../sidebar/Sidebar';
// import './HomePaciente.css';
// import DataPaciente from './dataPaciente/DataPaciente';
// import DailyEmotions from './dailyEmotions/DailyEmotions';
// import Turnos from "./turnos/Turnos"

// const HomePaciente = () => {
//   return (
//     <div className="dashboard-paciente">
//       <Sidebar />
//       <div className="content">
//         <div className="data-paciente">
//           <DataPaciente />
//         </div>
//         <div className='daily-part'>
//           <DailyEmotions></DailyEmotions>
//         </div>
//         <div className='turnos-part'>
//           <Turnos></Turnos>
//         </div>
       
        
//       </div>
//     </div>
//   );
// };

// export default HomePaciente;



// import React from 'react';
// import Sidebar from '../sidebar/Sidebar';
// import './HomePaciente.css';
// import DataPaciente from "./dataPaciente/DataPaciente"

// const HomePaciente = () => {
//   return (
//     <div className="dashboard-paciente">
//       <Sidebar></Sidebar>
//       <div className='data-paciente'>
//       <DataPaciente></DataPaciente>
//       </div>
//       <hr className="divider" />
      
//       <h1>hola paciente</h1>

//     </div>
//   );
// };

// export default HomePaciente;