/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.vista;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.usa.pollasoftwareweb.exceptions.NonexistentEntityException;
import com.usa.pollasoftwareweb.exceptions.PreexistingEntityException;
import com.usa.pollasoftwareweb.exceptions.RollbackFailureException;

import com.usa.pollasoftwareweb.entidad.Apuesta;
import com.usa.pollasoftwareweb.entidad.ApuestaPK;
import com.usa.pollasoftwareweb.entidad.Jugador;
import com.usa.pollasoftwareweb.entidad.Partido;

/**
 *
 * @author sergio
 */
@Stateless
public class ApuestaJpaController implements Serializable {

    @PersistenceContext(unitName = "co.com_polla_war_1.0PU")
    private EntityManager em;

    public ApuestaJpaController() {
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void create(Apuesta apuesta) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (apuesta.getApuestaPK() == null) {
            apuesta.setApuestaPK(new ApuestaPK());
        }
        apuesta.getApuestaPK().setIdPartido(apuesta.getPartido().getIdPartido());
        apuesta.getApuestaPK().setIdJugador(apuesta.getJugador().getIdJugador());
        EntityManager em = null;
        try {
            em = getEntityManager();
            Jugador jugador = apuesta.getJugador();
            if (jugador != null) {
                jugador = em.getReference(jugador.getClass(), jugador.getIdJugador());
                apuesta.setJugador(jugador);
            }
            Partido partido = apuesta.getPartido();
            if (partido != null) {
                partido = em.getReference(partido.getClass(), partido.getIdPartido());
                apuesta.setPartido(partido);
            }
            em.persist(apuesta);
            if (jugador != null) {
                jugador.getApuestaList().add(apuesta);
                jugador = em.merge(jugador);
            }
            if (partido != null) {
                partido.getApuestaList().add(apuesta);
                partido = em.merge(partido);
            }
        } catch (Exception ex) {
            try {
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findApuesta(apuesta.getApuestaPK()) != null) {
                throw new PreexistingEntityException("Apuesta " + apuesta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                
            }
        }
    }

    public void edit(Apuesta apuesta) throws NonexistentEntityException, RollbackFailureException, Exception {
        apuesta.getApuestaPK().setIdPartido(apuesta.getPartido().getIdPartido());
        apuesta.getApuestaPK().setIdJugador(apuesta.getJugador().getIdJugador());
        EntityManager em = null;
        try {
            em = getEntityManager();
            Apuesta persistentApuesta = em.find(Apuesta.class, apuesta.getApuestaPK());
            Jugador jugadorOld = persistentApuesta.getJugador();
            Jugador jugadorNew = apuesta.getJugador();
            Partido partidoOld = persistentApuesta.getPartido();
            Partido partidoNew = apuesta.getPartido();
            if (jugadorNew != null) {
                jugadorNew = em.getReference(jugadorNew.getClass(), jugadorNew.getIdJugador());
                apuesta.setJugador(jugadorNew);
            }
            if (partidoNew != null) {
                partidoNew = em.getReference(partidoNew.getClass(), partidoNew.getIdPartido());
                apuesta.setPartido(partidoNew);
            }
            apuesta = em.merge(apuesta);
            if (jugadorOld != null && !jugadorOld.equals(jugadorNew)) {
                jugadorOld.getApuestaList().remove(apuesta);
                jugadorOld = em.merge(jugadorOld);
            }
            if (jugadorNew != null && !jugadorNew.equals(jugadorOld)) {
                jugadorNew.getApuestaList().add(apuesta);
                jugadorNew = em.merge(jugadorNew);
            }
            if (partidoOld != null && !partidoOld.equals(partidoNew)) {
                partidoOld.getApuestaList().remove(apuesta);
                partidoOld = em.merge(partidoOld);
            }
            if (partidoNew != null && !partidoNew.equals(partidoOld)) {
                partidoNew.getApuestaList().add(apuesta);
                partidoNew = em.merge(partidoNew);
            }
        } catch (Exception ex) {
            try {
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ApuestaPK id = apuesta.getApuestaPK();
                if (findApuesta(id) == null) {
                    throw new NonexistentEntityException("The apuesta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                
            }
        }
    }

    public void destroy(ApuestaPK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Apuesta apuesta;
            try {
                apuesta = em.getReference(Apuesta.class, id);
                apuesta.getApuestaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The apuesta with id " + id + " no longer exists.", enfe);
            }
            Jugador jugador = apuesta.getJugador();
            if (jugador != null) {
                jugador.getApuestaList().remove(apuesta);
                jugador = em.merge(jugador);
            }
            Partido partido = apuesta.getPartido();
            if (partido != null) {
                partido.getApuestaList().remove(apuesta);
                partido = em.merge(partido);
            }
            em.remove(apuesta);
        } catch (Exception ex) {
            try {
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                
            }
        }
    }

    public List<Apuesta> findApuestaEntities() {
        return findApuestaEntities(true, -1, -1);
    }

    public List<Apuesta> findApuestaEntities(int maxResults, int firstResult) {
        return findApuestaEntities(false, maxResults, firstResult);
    }

    private List<Apuesta> findApuestaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Apuesta.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            
        }
    }

    public Apuesta findApuesta(ApuestaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Apuesta.class, id);
        } finally {
            
        }
    }

    public int getApuestaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Apuesta> rt = cq.from(Apuesta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            
        }
    }

}
