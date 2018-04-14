/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineas;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nestor
 */
@Entity
@Table(name = "Lineas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineas.findAll", query = "SELECT l FROM Lineas l")
    , @NamedQuery(name = "Lineas.findById", query = "SELECT l FROM Lineas l WHERE l.id = :id")
    , @NamedQuery(name = "Lineas.findByName", query = "SELECT l FROM Lineas l WHERE l.name = :name")
    , @NamedQuery(name = "Lineas.findByOrigin", query = "SELECT l FROM Lineas l WHERE l.origin = :origin")
    , @NamedQuery(name = "Lineas.findByDestination", query = "SELECT l FROM Lineas l WHERE l.destination = :destination")})
public class Lineas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Origin")
    private String origin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Destination")
    private String destination;

    public Lineas() {
    }

    public Lineas(Integer id) {
        this.id = id;
    }

    public Lineas(Integer id, String name, String origin, String destination) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.destination = destination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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
        if (!(object instanceof Lineas)) {
            return false;
        }
        Lineas other = (Lineas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lineas.Lineas[ id=" + id + " ]";
    }
    
}
