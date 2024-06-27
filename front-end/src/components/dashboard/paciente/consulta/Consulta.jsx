import React from "react";
import "./Consulta.css"
import Sidebar from "../../sidebar/Sidebar";
import Profesionales from "./profesionales/Profesionales";

const Consulta = () =>{
    return(
        <div className="consulta-cont">
            
            <div className="dashboard-paciente">
                <Sidebar />

                <div className="profesionales">
                    <Profesionales></Profesionales>

                </div>

              
            </div>
        </div>
    )
}

export default Consulta