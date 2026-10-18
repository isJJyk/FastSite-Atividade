package FastSiteLogin.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@Column(nullable = false,length = 100, name = "login")
    private String login;
@Column(nullable = false,length = 100,name = "senha")
    private String senha;

public Usuario(){

}

public Usuario(String login, String senha){
    this.login = login;
    this.senha = senha;
}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString(){
    return "Login: "+login+" Senha: "+senha;
    }
}
