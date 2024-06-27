import { Header } from "../Header/Header";
import { CardTurn } from "./CardTurn/CardTurn";
import { CardPatient } from "./CardPatient/CardPatient";
import Sidebar from "../Sidebar/Sidebar";

import styles from "./HomeProfesional.module.css";

export const HomeProfesional = () => {
  return (
    <div className={styles.dashboard_container}>
        <Sidebar />

      <section className={styles.section}>
        <Header />

        <section>
          <div className={styles.divider}>
            <h1>Mis pacientes</h1>
            <hr />
          </div>
          <div className={styles.card_container}>
            <CardPatient />
            <CardPatient />
            <CardPatient />
            <CardPatient />
          </div>
        </section>

        <section>
          <div className={styles.divider}>
            <h1>Turnos</h1>
            <hr />
          </div>
          <div>
            <CardTurn />
          </div>
        </section>
      </section>
    </div>
  );
}
