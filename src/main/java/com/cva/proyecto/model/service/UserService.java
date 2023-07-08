package com.cva.proyecto.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cva.proyecto.model.dao.IUsuarioDao;

import jakarta.transaction.Transactional;

public class UserService implements UserDetailsService{
    
    @Autowired
    private IUsuarioDao usuarioDao;

    

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        
    }
}
