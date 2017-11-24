/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.usa.pollasoftwareweb.exceptions.IllegalOrphanException;
import com.usa.pollasoftwareweb.exceptions.NonexistentEntityException;
import com.usa.pollasoftwareweb.exceptions.PreexistingEntityException;
import com.usa.pollasoftwareweb.exceptions.RollbackFailureException;

import com.usa.pollasoftwareweb.entidad.Apuesta;
import com.usa.pollasoftwareweb.entidad.Jugador;

/**
 *
 * @author sergio
 */
@Stateless
public class JugadorJpaController implements Serializable {

    @PersistenceContext(unitName = "co.com_polla_war_1.0PU")
    private EntityManager em;

    public JugadorJpaController() {
    }

    public EntityManager getEntityManager() {
        return em;
    }

    @javax.transaction.Transactional
    public void create(Jugador jugador) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (jugador.getApuestaList() == null) {
            jugador.setApuestaList(new ArrayList<Apuesta>());
        }
        try {
            em = getEntityManager();
            List<Apuesta> attachedApuestaList = new ArrayList<Apuesta>();
            for (Apuesta apuestaListApuestaToAttach : jugador.getApuestaList()) {
                apuestaListApuestaToAttach = em.getReference(apuestaListApuestaToAttach.getClass(), apuestaListApuestaToAttach.getApuestaPK());
                attachedApuestaList.add(apuestaListApuestaToAttach);
            }
            jugador.setApuestaList(attachedApuestaList);
            em.persist(jugador);
            for (Apuesta apuestaListApuesta : jugador.getApuestaList()) {
                Jugador oldJugadorOfApuestaListApuesta = apuestaListApuesta.getJugador();
                apuestaListApuesta.setJugador(jugador);
                apuestaListApuesta = em.merge(apuestaListApuesta);
                if (oldJugadorOfApuestaListApuesta != null) {
                    oldJugadorOfApuestaListApuesta.getApuestaList().remove(apuestaListApuesta);
                    oldJugadorOfApuestaListApuesta = em.merge(oldJugadorOfApuestaListApuesta);
                }
            }
        } catch (Exception ex) {
            try {
                System.out.println("Emntra ex");
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findJugador(jugador.getIdJugador()) != null) {
                throw new PreexistingEntityException("Jugador " + jugador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {

            }
        }
    }

    public void edit(Jugador jugador) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {

        try {
            em = getEntityManager();
            Jugador persistentJugador = em.find(Jugador.class, jugador.getIdJugador());
            List<Apuesta> apuestaListOld = persistentJugador.getApuestaList();
            List<Apuesta> apuestaListNew = jugador.getApuestaList();
            List<String> illegalOrphanMessages = null;
            for (Apuesta apuestaListOldApuesta : apuestaListOld) {
                if (!apuestaListNew.contains(apuestaListOldApuesta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Apuesta " + apuestaListOldApuesta + " since its jugador field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Apuesta> attachedApuestaListNew = new ArrayList<Apuesta>();
            for (Apuesta apuestaListNewApuestaToAttach : apuestaListNew) {
                apuestaListNewApuestaToAttach = em.getReference(apuestaListNewApuestaToAttach.getClass(), apuestaListNewApuestaToAttach.getApuestaPK());
                attachedApuestaListNew.add(apuestaListNewApuestaToAttach);
            }
            apuestaListNew = attachedApuestaListNew;
            jugador.setApuestaList(apuestaListNew);
            jugador = em.merge(jugador);
            for (Apuesta apuestaListNewApuesta : apuestaListNew) {
                if (!apuestaListOld.contains(apuestaListNewApuesta)) {
                    Jugador oldJugadorOfApuestaListNewApuesta = apuestaListNewApuesta.getJugador();
                    apuestaListNewApuesta.setJugador(jugador);
                    apuestaListNewApuesta = em.merge(apuestaListNewApuesta);
                    if (oldJugadorOfApuestaListNewApuesta != null && !oldJugadorOfApuestaListNewApuesta.equals(jugador)) {
                        oldJugadorOfApuestaListNewApuesta.getApuestaList().remove(apuestaListNewApuesta);
                        oldJugadorOfApuestaListNewApuesta = em.merge(oldJugadorOfApuestaListNewApuesta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = jugador.getIdJugador();
                if (findJugador(id) == null) {
                    throw new NonexistentEntityException("The jugador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {

            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {

        try {
            em = getEntityManager();
            Jugador jugador;
            try {
                jugador = em.getReference(Jugador.class, id);
                jugador.getIdJugador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jugador with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Apuesta> apuestaListOrphanCheck = jugador.getApuestaList();
            for (Apuesta apuestaListOrphanCheckApuesta : apuestaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Jugador (" + jugador + ") cannot be destroyed since the Apuesta " + apuestaListOrphanCheckApuesta + " in its apuestaList field has a non-nullable jugador field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(jugador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {

            }
        }
    }

    public List<Jugador> findJugadorEntities() {
        return findJugadorEntities(true, -1, -1);
    }

    public List<Jugador> findJugadorEntities(int maxResults, int firstResult) {
        return findJugadorEntities(false, maxResults, firstResult);
    }

    private List<Jugador> findJugadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Jugador.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {

        }
    }

    public Jugador findJugador(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Jugador.class, id);
        } finally {

        }
    }

    public int getJugadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Jugador> rt = cq.from(Jugador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {

        }
    }

}
