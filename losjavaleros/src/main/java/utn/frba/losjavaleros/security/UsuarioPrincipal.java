package utn.frba.losjavaleros.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import utn.frba.losjavaleros.model.Rol;
import utn.frba.losjavaleros.model.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
    private Usuario usuario;
    public UsuarioPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getGrantedAuthorities(usuario.getRoles().stream()
                .map(Rol::getNombre).collect(Collectors.toList()));
    }

    @Override
    public String getPassword() {
        return usuario.getContrasenia();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String rol: roles) {
            authorities.add(new SimpleGrantedAuthority(rol));
        }
        return authorities;
    }
}
