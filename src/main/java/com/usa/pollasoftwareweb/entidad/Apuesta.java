/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.entidad;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "apuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apuesta.findAll", query = "SELECT a FROM Apuesta a")
    , @NamedQuery(name = "Apuesta.findByIdJugador", query = "SELECT a FROM Apuesta a WHERE a.apuestaPK.idJugador = :idJugador")
    , @NamedQuery(name = "Apuesta.findByIdPartido", query = "SELECT a FROM Apuesta a WHERE a.apuestaPK.idPartido = :idPartido")
    , @NamedQuery(name = "Apuesta.findByMarcadorLocal", query = "SELECT a FROM Apuesta a WHERE a.marcadorLocal = :marcadorLocal")
    , @NamedQuery(name = "Apuesta.findByMarcadorVisitante", query = "SELECT a FROM Apuesta a WHERE a.marcadorVisitante = :marcadorVisitante")})
public class Apuesta implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ApuestaPK apuestaPK;

    @Basic(optional = false)
    @NotNull
    @Column(name = "marcador_local")
    private BigInteger marcadorLocal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "marcador_visitante")
    private BigInteger marcadorVisitante;

    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jugador jugador;

    @JoinColumn(name = "id_partido", referencedColumnName = "id_partido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Partido partido;

    public Apuesta() {
    }

    public Apuesta(ApuestaPK apuestaPK) {
        this.apuestaPK = apuestaPK;
    }

    public Apuesta(ApuestaPK apuestaPK, BigInteger marcadorLocal, BigInteger marcadorVisitante) {
        this.apuestaPK = apuestaPK;
        this.marcadorLocal = marcadorLocal;
        this.marcadorVisitante = marcadorVisitante;
    }

    public Apuesta(String idJugador, int idPartido) {
        this.apuestaPK = new ApuestaPK(idJugador, idPartido);
    }

    public ApuestaPK getApuestaPK() {
        return apuestaPK;
    }

    public void setApuestaPK(ApuestaPK apuestaPK) {
        this.apuestaPK = apuestaPK;
    }

    public BigInteger getMarcadorLocal() {
        return marcadorLocal;
    }

    public void setMarcadorLocal(BigInteger marcadorLocal) {
        this.marcadorLocal = marcadorLocal;
    }

    public BigInteger getMarcadorVisitante() {
        return marcadorVisitante;
    }

    public void setMarcadorVisitante(BigInteger marcadorVisitante) {
        this.marcadorVisitante = marcadorVisitante;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apuestaPK != null ? apuestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apuesta)) {
            return false;
        }
        Apuesta other = (Apuesta) object;
        if ((this.apuestaPK == null && other.apuestaPK != null) || (this.apuestaPK != null && !this.apuestaPK.equals(other.apuestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Apuesta{" + "apuestaPK=" + apuestaPK + ", marcadorLocal=" + marcadorLocal + ", marcadorVisitante=" + marcadorVisitante + ", jugador=" + jugador + ", partido=" + partido + '}';
    }

}
