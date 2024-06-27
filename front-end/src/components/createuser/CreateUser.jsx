import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import brain from "../../assets/brain.png";
import logo from "../../assets/logo.webp";
import styles from './CreateUser.module.css';

export const CreateUser = () => {
  const [newUser, setNewUser] = useState({
    nombre: '',
    apellido: '',
    email: '',
    telefono: '',
    documento: '',
    usuario: {
      usuario: '',
      contrasenia: ''
    }
  });
  const [csrfToken, setCsrfToken] = useState('');

  useEffect(() => {
    const fetchToken = async () => {
      try {
        const res = await fetch('http://localhost:8080/csrf-token', {
          method: 'GET',
          credentials: 'include'
        });
        const data = res.json();
        setCsrfToken(data.token);
      } catch (error) {
        console.error('Error al obtener el token CSRF:', error);
      }
    };
    fetchToken();
  }, []);

  const catchInputs = (e) => {
    const { name, value } = e.target;
    setNewUser((prevState) => ({
      ...prevState,
      [name]: value
    }));
  };

  const catchUserInputs = (e) => {
    const { name, value } = e.target;
    setNewUser((prevState) => ({
      ...prevState,
      usuario: {
        ...prevState.usuario,
        [name]: value
      }
    }));
  };

  const Enviar = async (e) => {
    e.preventDefault();
    try {
      const res = await fetch('https://c18-36-ft-java-react.onrender.com/auth/sign-up', {
        method: POST,
        headers: {
          'Content-Type': 'application.json',
          'X-XSRF-TOKEN': csrfToken
        },
        credentials: 'include',
        body: JSON.stringify(newUser)
      })

      if (!res.ok) {
        throw new Error('Network response was not ok')
      }

      const data = await res.json();
      console.log(data);
    } catch (error) {
      console.error('Error al crear el usuario:', error);
    };
  };

  return (
    <>
      <img className={styles.brain} src={brain} alt="cerebro" />
      <div className={styles.wave1} />
      <div className={styles.wave2} />
      <div className={styles.wave3} />
      <div className={styles.card}>
        <Link to="/">
          <img className={styles.logo} src={logo} alt="logo" />
        </Link>
        <h1>Crear una cuenta</h1>
        <form onSubmit={Enviar} className={styles.form}>
          <div className={styles.input_container}>
            <input className={styles.input} placeholder="Nombre" type="text" name="nombre" onChange={catchInputs} />
            <input className={styles.input} placeholder="Apellido" type="text" name="apellido" onChange={catchInputs} />
            <input className={styles.input} placeholder="E-mail" type="email" name="email" onChange={catchInputs} />
            <input className={styles.input} placeholder="Teléfono" type="number" name="telefono" onChange={catchInputs} />
            <input className={styles.input} placeholder="DNI" type="number" name="documento" onChange={catchInputs} />
          </div>
          <h1>Nuevo usuario</h1>
          <div className={styles.input_container}>
            <input className={styles.input} placeholder="Nombre de usuario" type="text" name="usuario" onChange={catchUserInputs} />
            <input className={styles.input} placeholder="Contraseña" type="password" name="contrasenia" onChange={catchUserInputs} />
          </div>
          <button className={styles.button}>Crear</button>
        </form>
        <span>
          Ya tienes cuenta? <Link className={styles.link} to="/login">Ingresa</Link>
        </span>
      </div>
    </>
  );
};