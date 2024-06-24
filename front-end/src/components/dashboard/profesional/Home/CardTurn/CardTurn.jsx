import { useContext } from "react";
import { Context } from "../../../../../../Context";

import styles from "./CardTurn.module.css"

export const CardTurn = () => {

  return (
    <div className={styles.card}>

      <div className={styles.information}>

        <div>
          <span>
            Fecha:
          </span>
          <p>
            27/6/24
          </p>
        </div>

        <div>
          <span>
            Paciente:
          </span>
          <p>
            Juan
          </p>
        </div>

        <div>
          <span>
            Hora:
          </span>
          <p>
            17:00hs
          </p>
        </div>
      </div>

      <div className={styles.button_container}>
        <button className={styles.button_white}>
          Reprogramar
        </button>
        <button className={styles.button_transparent}>
          Cancelar
        </button>
      </div>
    </div>
  )
}