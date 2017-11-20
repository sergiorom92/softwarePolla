/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "partido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p")
    , @NamedQuery(name = "Partido.findByIdPartido", query = "SELECT p FROM Partido p WHERE p.idPartido = :idPartido")
    , @NamedQuery(name = "Partido.findByHora", query = "SELECT p FROM Partido p WHERE p.hora = :hora")
    , @NamedQuery(name = "Partido.findByMarcadorLocalFinal", query = "SELECT p FROM Partido p WHERE p.marcadorLocalFinal = :marcadorLocalFinal")
    , @NamedQuery(name = "Partido.findByMarcadorVisitanteFinal", query = "SELECT p FROM Partido p WHERE p.marcadorVisitanteFinal = :marcadorVisitanteFinal")})
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_partido")
    private Integer idPartido;

    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;

    @Column(name = "marcador_local_final")
    private BigInteger marcadorLocalFinal;

    @Column(name = "marcador_visitante_final")
    private BigInteger marcadorVisitanteFinal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partido", fetch = FetchType.EAGER)
    private List<Apuesta> apuestaList;

    @JoinColumn(name = "id_equipo_local", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipoLocal;

    @JoinColumn(name = "id_equipo_visitante", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipoVisitante;

    public Partido() {
    }

    public Partido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Partido(Integer idPartido, Date hora) {
        this.idPartido = idPartido;
        this.hora = hora;
    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public BigInteger getMarcadorLocalFinal() {
        return marcadorLocalFinal;
    }

    public void setMarcadorLocalFinal(BigInteger marcadorLocalFinal) {
        this.marcadorLocalFinal = marcadorLocalFinal;
    }

    public BigInteger getMarcadorVisitanteFinal() {
        return marcadorVisitanteFinal;
    }

    public void setMarcadorVisitanteFinal(BigInteger marcadorVisitanteFinal) {
        this.marcadorVisitanteFinal = marcadorVisitanteFinal;
    }

    @XmlTransient
    public List<Apuesta> getApuestaList() {
        return apuestaList;
    }

    public void setApuestaList(List<Apuesta> apuestaList) {
        this.apuestaList = apuestaList;
    }
    
    public Equipo getIdEquipoLocal() {
        return idEquipoLocal;
    }

    public void setIdEquipoLocal(Equipo idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    public Equipo getIdEquipoVisitante() {
        return idEquipoVisitante;
    }

    public void setIdEquipoVisitante(Equipo idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartido != null ? idPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.idPartido == null && other.idPartido != null) || (this.idPartido != null && !this.idPartido.equals(other.idPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Partido{" + "idPartido=" + idPartido + ", hora=" + hora + ", marcadorLocalFinal=" + marcadorLocalFinal + ", marcadorVisitanteFinal=" + marcadorVisitanteFinal + ", idEquipoLocal=" + idEquipoLocal + ", idEquipoVisitante=" + idEquipoVisitante + '}';
    }

}
