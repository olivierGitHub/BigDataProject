package bigdata.userInterface.connexion.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
        @NamedQuery(name = "Login.findById", query = "SELECT l FROM Login l WHERE l.id = :id"),
        @NamedQuery(name = "Login.findByUsername", query = "SELECT l FROM Login l WHERE l.username = :username"),
        @NamedQuery(name = "Login.findByPassword", query = "SELECT l FROM Login l WHERE l.password = :password")})

public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    //@Column(name = "username")
    private String username;
    @Basic(optional = false)
    //@Column(name = "password")
    private String password;

    public Login() {
    }

    public Login(Integer id) {
        this.id = id;
    }

    public Login(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Login other = (Login) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.username, other.username)
                && Objects.equals(this.password, other.password);
    }

    @Override
    public String toString() {
        return "com.Login_1[ id=" + id + " ]";
    }


}
