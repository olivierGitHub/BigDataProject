package userInterface.connexion.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by Herve on 18/02/2015.
 */

@Entity
// @Table(name = "login")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
        @NamedQuery(name = "Login.findById", query = "SELECT l FROM Login l WHERE l.id = :id"),
        @NamedQuery(name = "Login.findByUsername", query = "SELECT l FROM Login l WHERE l.username = :username"),
        @NamedQuery(name = "Login.findByPassword", query = "SELECT l FROM Login l WHERE l.password = :password")})

public class Login implements Serializable  {

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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Login_1[ id=" + id + " ]";
    }


}
