import React from "react";
import "./Turnos.css"

const Turnos =()=>{
    return(
        <div className="turnos-cont">
             <hr className="divider" />
            <h2 className='title-home'>Mis turnos</h2>
            <div>
                <div className="info-turno">
        
                    <p><strong>Fecha:</strong> 03/05/2024</p>
                    <p><strong>Profesional:</strong> Maria marta</p>
                    <div className="buttons-turno">
                        <button className="button-turno" onClick={() => { /* hagregar emotion */ }}>Link</button>
                        <button className="button-turno" onClick={() => { /* hagregar emotion */ }}>Cancelar </button>
                    </div>
                    
                    
                </div>


            </div>
           

        </div>
    )
}

export default Turnos