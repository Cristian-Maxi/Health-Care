import React from 'react';
import { Link } from 'react-router-dom';
import './Sidebar.css'; 
import logo from "./Logo.png"

const Sidebar = () => {
  return (
    <div className="sidebar">
      <div className="logo">
        <img src={logo} alt="VitalMind Logo" />
      </div>
      <nav className="menu">
        <ul>
          <li>
            <Link to="/dashboard/paciente">Home</Link>
          </li>
          <li>
            <Link to="/dashboard/paciente/consulta">Agendar Consulta</Link>
          </li>
          <li>
            <Link to="/dashboard/paciente">Material de Apoyo</Link>
          </li>
        </ul>
      </nav>
      <div className="logout">
        <button className="button-logout" onClick={() => { /* handle logout */ }}>Log out</button>
      </div>
    </div>
  );
}

export default Sidebar;
