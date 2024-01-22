package lucaguerra.user;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "utenti")
public class User implements UserDetails {

	@Id
	@GeneratedValue
	private UUID id;
	@Column(name = "username")
	private String username;
	@Column(name = "nome")
	private String name;
	@Column(name = "cognome")
	private String surname;
	@Column(name = "email")
	private String email;
	@JsonIgnore
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name = "ruolo")
	private Role role;

	public User(String username, String name, String surname, String email, String password) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.role != null) {
			return List.of(new SimpleGrantedAuthority(role.name()));
		}

		return Collections.emptyList();
	}

	@Override
	public String getUsername() {
		return this.email;
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

}
