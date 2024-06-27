import { MdContentPasteSearch, MdOutlinePersonSearch, MdAppRegistration } from "react-icons/md";
import { HiOutlineClipboardDocumentList } from "react-icons/hi2";

import Navbar from "./navbar/Navbar"

import main from '../assets/home-page.webp'

import styles from './Home.module.css'

export const Home = () => {

  const articleItems = [
    { icon: <MdContentPasteSearch />, text: 'Obten consultas', subtext: 'Psicólogos listos para ayudarte' },
    { icon: <HiOutlineClipboardDocumentList />, text: 'Material de apoyo', subtext: 'Recursos útiles para tu bienestar' },
    { icon: <MdOutlinePersonSearch />, text: 'Encuentra los mejores profesionales', subtext: 'Expertos a tu disposición siempre' },
    { icon: <MdAppRegistration />, text: 'Registro de emociones', subtext: 'Controla y analiza tus sentimientos' }
  ]
  return (
    <main className={styles.container}>
      <Navbar />
      <section className={styles.section_container}>
        <article className={styles.article}>
          <h1>Tu guía hacia una mente
            equilibrada y plena</h1>
          <div className={styles.item_container}>
            {articleItems.map((item) => {
              return <li key={item.text}>
                <span>
                  {item.icon}
                </span>
                <div className={styles.items_text}>
                  <h3>{item.text}</h3>
                  <p>{item.subtext}</p>
                </div>
              </li>
            })}
          </div>
        </article>
        <img className={styles.image}
          src={main}
          alt="women at videocall" />
      </section>
    </main>
  )
}