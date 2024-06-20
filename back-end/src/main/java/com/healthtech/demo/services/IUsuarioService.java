package com.healthtech.demo.services;

import com.healthtech.demo.entities.Usuario;

import java.util.List;

public interface IUsuarioService {

    //metodo para traer a todos los usuarios
    public List<Usuario> getUsuario();

    //metodo para dar de alta un usuario
    public void saveUsuario(Usuario usuario);

    //metodo para dar de baja un usuario
    public void deleteUsuario(Long id);

}
