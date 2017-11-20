/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j")
    , @NamedQuery(name = "Jugador.findByIdJugador", query = "SELECT j FROM Jugador j WHERE j.idJugador = :idJugador")
    , @NamedQuery(name = "Jugador.findByAlias", query = "SELECT j FROM Jugador j WHERE j.alias = :alias")
    , @NamedQuery(name = "Jugador.findByPassword", query = "SELECT j FROM Jugador j WHERE j.password = :password")
    , @NamedQuery(name = "Jugador.findByAdministrador", query = "SELECT j FROM Jugador j WHERE j.administrador = :administrador")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_jugador")
    private String idJugador;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "alias")
    private String alias;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;

    @Basic(optional = false)
    @NotNull
    @Column(name = "administrador")
    private boolean administrador;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugador")
    private List<Apuesta> apuestaList;

    public Jugador() {
    }

    public Jugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public Jugador(String idJugador, String alias, String password, boolean administrador) {
        this.idJugador = idJugador;
        this.alias = alias;
        this.password = password;
        this.administrador = administrador;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @XmlTransient
    public List<Apuesta> getApuestaList() {
        return apuestaList;
    }

    public void setApuestaList(List<Apuesta> apuestaList) {
        this.apuestaList = apuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJugador != null ? idJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.idJugador == null && other.idJugador != null) || (this.idJugador != null && !this.idJugador.equals(other.idJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Jugador[ idJugador=" + idJugador + " ]";
    }

}
