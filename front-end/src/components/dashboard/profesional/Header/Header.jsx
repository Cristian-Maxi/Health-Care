import { useContext } from "react";
import { Context } from "../../../../../Context";

import styles from "./Header.module.css"

export const Header = () => {

  const { authState } = useContext(Context);

  const { user } = authState;

  const valoration = Array.from({ length: user.valoracion });


  return (
    <section className={styles.profile_container}>
      <h1>
        {user.nombre} {user.apellido}
      </h1>

      <div>
        <h5>
          Terapias:
        </h5>
        <span className={styles.major}>
          {user.especialidad}
        </span>
      </div>

      <div>
        <h5>
          Descripción:
        </h5>
        <span className={styles.description}>
          {user.descripcion}
        </span>
      </div>

      <div>
        <h5>
          Valoracion:
        </h5>
        {<span>
          {valoration.map((_, index) => (
            <span key={index}>⭐</span>
          ))}
        </span>}
      </div>
    </section>
  )
}