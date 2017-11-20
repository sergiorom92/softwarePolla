/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.entidad;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 *
 * @author sergio
 */
@Embeddable
public class ApuestaPK implements Serializable {

    @Basic(optional = false)
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_jugador")
    private String idJugador;
    
    @Basic(optional = false)
    @Column(name = "id_partido")
    private int idPartido;

    public ApuestaPK() {
    }

    public ApuestaPK(String idJugador, int idPartido) {
        this.idJugador = idJugador;
        this.idPartido = idPartido;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJugador != null ? idJugador.hashCode() : 0);
        hash += idPartido;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApuestaPK)) {
            return false;
        }
        ApuestaPK other = (ApuestaPK) object;
        if ((this.idJugador == null && other.idJugador != null) || (this.idJugador != null && !this.idJugador.equals(other.idJugador))) {
            return false;
        }
        if (this.idPartido != other.idPartido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.ApuestaPK[ idJugador=" + idJugador + ", idPartido=" + idPartido + " ]";
    }
    
}
