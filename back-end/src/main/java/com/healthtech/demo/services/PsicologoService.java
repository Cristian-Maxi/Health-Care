package com.healthtech.demo.services;

import com.healthtech.demo.dto.ActualizarPsicologoDTO;
import com.healthtech.demo.dto.CrearPsicologoDTO;
import com.healthtech.demo.entities.Psicologo;
import com.healthtech.demo.entities.Usuario;
import com.healthtech.demo.manejoErrores.ValidacionDeIntegridad;
import com.healthtech.demo.repositories.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class PsicologoService implements IPsicologoService {

    @Autowired
    private PsicologoRepository psicologoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Psicologo> getPsicologos() {
        List<Psicologo> listaPsicologos = this.psicologoRepository.findAll();
        return listaPsicologos;
    }

    @Override
    public Psicologo savePsicologo(CrearPsicologoDTO psicologo) {
        boolean existe = this.psicologoRepository.existsByDocumento(psicologo.documento());
        if (existe) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El psicologo ya existe");
        } else {
            Usuario usuario = new Usuario(psicologo.usuario());
            usuario.setContrasenia(passwordEncoder.encode(psicologo.usuario().contrasenia()));
            Psicologo psicologoGuardado = new Psicologo(psicologo);
            psicologoGuardado.setUsuario(usuario);
            return psicologoRepository.save(psicologoGuardado);
        }
    }

    @Override
    public void deletePsicologo(Long id) {
        psicologoRepository.deleteById(id);
    }

    @Override
    public Psicologo modificarPsicologo(ActualizarPsicologoDTO psicologoDTO) {
        if (!psicologoRepository.findById(psicologoDTO.id()).isPresent()){
            throw new ValidacionDeIntegridad("El id del psicologo no existe");
        }
        Psicologo psicologoSeleccionado = psicologoRepository.getReferenceById(psicologoDTO.id());
        psicologoSeleccionado.ActualizarPsicologo(psicologoDTO);
        return psicologoSeleccionado;
    }

    @Override
    public Psicologo elegirPsicologo(Long id) {
        return psicologoRepository.findByUsuarioId(id)
                .orElseThrow(() -> new ValidacionDeIntegridad("El id del usuario no existe"));
    }
}
