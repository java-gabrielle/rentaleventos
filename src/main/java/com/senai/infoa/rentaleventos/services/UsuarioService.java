package com.senai.infoa.rentaleventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rentaleventos.models.Usuario;
import com.senai.infoa.rentaleventos.repositories.UsuarioRepository;
@Service
public class UsuarioService {


  @Autowired
  private UsuarioRepository ur;

    public Usuario salvar(Usuario usuario){
        if(usuario != null) {
        return ur.save(usuario);
        }
        return null;
    }


/* 
    public Usuario login(String email, String senha){
        Usuario usuario = ur.findByUsuario(email, senha);
            if(usuario != null && senha.equals(usuario.getSenha())){
                return usuario;
            }
        return null;
    }
*/
    public Usuario atualizar(Usuario usuario, Integer id) {
    // 1. Busca no banco pelo ID (Integer)
    Usuario usuarioBanco = ur.findById(id).orElse(null);

    // 2. Se encontrar, atualiza os dados e salva no banco usando o 'ur'
    if (usuarioBanco != null) {
        usuarioBanco.setNome(usuario.getNome());
        usuarioBanco.setSenha(usuario.getSenha());
        return ur.save(usuarioBanco);
    }
    return null;
}

    public Usuario buscarPorId(Integer id) {
        return ur.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado: " + id));
    }

    public boolean apagar(Integer id) {
        Usuario usuario = ur.findById(id).get();
        if(usuario != null){
            ur.deleteById(id);
            return true;
        }
        return false;
    }


    
}
