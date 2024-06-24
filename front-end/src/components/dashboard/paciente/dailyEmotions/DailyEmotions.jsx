import React from "react";
import "./DailyEmotions.css"
import EmotionCard from "../emotionCard/EmotionCard"
import Emociones from "./DataEmociones"

const DailyEmotions = ()=>{
    return(
        <div className="daily-container">
            <div className="daily-title-button">
                <h2 className='title-home'>Diario de emociones</h2>
                <button className="button-daily" onClick={() => { /* hagregar emotion */ }}>Agregar emoción</button>

            </div>
           
            <div className="emotions-part">
                    {Emociones.map(emocion => (
                        <EmotionCard
                            key={emocion.id} // Asegúrate de usar un key único para cada emoción
                            fechaCreacion={emocion.fechaCreacion}
                            tipoEmocion={emocion.tipoEmocion}
                            descripcion={emocion.descripcion}
                        />
                    ))}
            </div>
            

        </div>
    )
}

export default DailyEmotions