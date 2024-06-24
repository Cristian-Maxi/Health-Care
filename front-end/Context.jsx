import React, {createContext, useState} from "react";
import { useEffect } from "react";

export const Context = createContext();

export const CustomeProvider = ({children}) => {

  const [authState, setAuthState] = useState({
    user: null,
    token: null,
    isAuthenticated: false,
  });

  // Recuperar el token y los datos del usuario del almacenamiento local cuando el componente se monta
  useEffect(() => {
    const token = localStorage.getItem('jwtToken');
    const user = JSON.parse(localStorage.getItem('user'));
    if (token && user) {
      setAuthState({ user, token, isAuthenticated: true });
    }
  }, []);

  const login = (user, token) => {
    localStorage.setItem('jwtToken', token);
    localStorage.setItem('user', JSON.stringify(user));
    setAuthState({ user, token, isAuthenticated: true });
  };

  const logout = () => {
    localStorage.removeItem('jwtToken');
    localStorage.removeItem('user');
    setAuthState({ user: null, token: null, isAuthenticated: false });
  };

  return(
    <Context.Provider value={{authState, login, logout}}>
      {children}
    </Context.Provider>
  )
}