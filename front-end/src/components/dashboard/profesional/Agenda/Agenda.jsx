import Sidebar from "../Sidebar/Sidebar"
import styles from "./Agenda.module.css";

export const AgendaProfessional = () => {

  return (
    <div className={styles.section}>

      <Sidebar/>

      <section>
        <div className={styles.divider}>
          <h1>Agenda</h1>
          <hr />
        </div>

        <div className={styles.agenda_container}>
          <h1>Hoy</h1>
          <div className={styles.turn_container}>
            <div className={styles.hour_container}>
              <span className={styles.start_time}>
                08:00
              </span>
              <span className={styles.end_time}>
                09:00
              </span>
            </div>
            <hr />
            <span className={styles.patient}>
              Juan Perez
            </span>
          </div>
          
        </div>
      </section>
    </div>
  );
}
