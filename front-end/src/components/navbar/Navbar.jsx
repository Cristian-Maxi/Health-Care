import React from 'react'

import { Link } from 'react-router-dom'

import logo from '../../assets/logo.webp'

import styles from './Navbar.module.css'

const Navbar = () => {
  return (
    <header className={styles.container}>
      <img className={styles.logo}
        src={logo} alt="logo" />
      <div className={styles.button_container}>
        <Link to={'/login'}>
          <button className={styles.button_transparent}>
            Ingresar
          </button>
        </Link>
        <Link to={'/signup'}>
          <button className={styles.button}>
            Registrarme
          </button>
        </Link>
      </div>
    </header>
  )
}

export default Navbar;