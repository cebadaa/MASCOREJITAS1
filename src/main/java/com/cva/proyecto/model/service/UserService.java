package com.cva.proyecto.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cva.proyecto.model.dao.IUsuarioDao;
import com.cva.proyecto.model.entidad.Rol;
import com.cva.proyecto.model.entidad.Usuario;

@Service("UserService")
public class UserService implements UserDetailsService{
    
    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        
        Usuario usuario = usuarioDao.findByUsername(username);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no existe");
        }

        List<GrantedAuthority> listaRoles = new ArrayList<GrantedAuthority>();
        for(Rol item: usuario.getRoles()){
            listaRoles.add(new SimpleGrantedAuthority(item.getAuthority()));
        }
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), 
        true, true, true, listaRoles);
    }
}
