package com.cva.proyecto.model.entidad;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_usuarios;
        private String username;
        private String password;
        private Boolean enabled;

        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "id_usuarios")
        private List<Rol> roles;

        public Long getId_usuarios() {
                return id_usuarios;
        }

        public void setId_usuarios(Long id_usuarios) {
                this.id_usuarios = id_usuarios;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Boolean getEnabled() {
                return enabled;
        }

        public void setEnabled(Boolean enabled) {
                this.enabled = enabled;
        }

        public List<Rol> getRoles() {
                return roles;
        }

        public void setRoles(List<Rol> roles) {
                this.roles = roles;
        }



}
