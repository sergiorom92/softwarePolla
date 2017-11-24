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
import com.usa.pollasoftwareweb.exceptions.RollbackFailureException;

import com.usa.pollasoftwareweb.entidad.Apuesta;
import com.usa.pollasoftwareweb.entidad.Equipo;
import com.usa.pollasoftwareweb.entidad.Partido;

/**
 *
 * @author sergio
 */
@Stateless
public class PartidoJpaController implements Serializable {

    @PersistenceContext(unitName = "co.com_polla_war_1.0PU")
    private EntityManager em;

    public PartidoJpaController() {
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void create(Partido partido) throws RollbackFailureException, Exception {
        if (partido.getApuestaList() == null) {
            partido.setApuestaList(new ArrayList<Apuesta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            Equipo idEquipoLocal = partido.getIdEquipoLocal();
            if (idEquipoLocal != null) {
                idEquipoLocal = em.getReference(idEquipoLocal.getClass(), idEquipoLocal.getIdEquipo());
                partido.setIdEquipoLocal(idEquipoLocal);
            }
            Equipo idEquipoVisitante = partido.getIdEquipoVisitante();
            if (idEquipoVisitante != null) {
                idEquipoVisitante = em.getReference(idEquipoVisitante.getClass(), idEquipoVisitante.getIdEquipo());
                partido.setIdEquipoVisitante(idEquipoVisitante);
            }
            List<Apuesta> attachedApuestaList = new ArrayList<Apuesta>();
            for (Apuesta apuestaListApuestaToAttach : partido.getApuestaList()) {
                apuestaListApuestaToAttach = em.getReference(apuestaListApuestaToAttach.getClass(), apuestaListApuestaToAttach.getApuestaPK());
                attachedApuestaList.add(apuestaListApuestaToAttach);
            }
            partido.setApuestaList(attachedApuestaList);
            em.persist(partido);
            if (idEquipoLocal != null) {
                idEquipoLocal.getPartidoList().add(partido);
                idEquipoLocal = em.merge(idEquipoLocal);
            }
            if (idEquipoVisitante != null) {
                idEquipoVisitante.getPartidoList().add(partido);
                idEquipoVisitante = em.merge(idEquipoVisitante);
            }
            for (Apuesta apuestaListApuesta : partido.getApuestaList()) {
                Partido oldPartidoOfApuestaListApuesta = apuestaListApuesta.getPartido();
                apuestaListApuesta.setPartido(partido);
                apuestaListApuesta = em.merge(apuestaListApuesta);
                if (oldPartidoOfApuestaListApuesta != null) {
                    oldPartidoOfApuestaListApuesta.getApuestaList().remove(apuestaListApuesta);
                    oldPartidoOfApuestaListApuesta = em.merge(oldPartidoOfApuestaListApuesta);
                }
            }
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

    public void edit(Partido partido) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Partido persistentPartido = em.find(Partido.class, partido.getIdPartido());
            Equipo idEquipoLocalOld = persistentPartido.getIdEquipoLocal();
            Equipo idEquipoLocalNew = partido.getIdEquipoLocal();
            Equipo idEquipoVisitanteOld = persistentPartido.getIdEquipoVisitante();
            Equipo idEquipoVisitanteNew = partido.getIdEquipoVisitante();
            List<Apuesta> apuestaListOld = persistentPartido.getApuestaList();
            List<Apuesta> apuestaListNew = partido.getApuestaList();
            List<String> illegalOrphanMessages = null;
            for (Apuesta apuestaListOldApuesta : apuestaListOld) {
                if (!apuestaListNew.contains(apuestaListOldApuesta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Apuesta " + apuestaListOldApuesta + " since its partido field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idEquipoLocalNew != null) {
                idEquipoLocalNew = em.getReference(idEquipoLocalNew.getClass(), idEquipoLocalNew.getIdEquipo());
                partido.setIdEquipoLocal(idEquipoLocalNew);
            }
            if (idEquipoVisitanteNew != null) {
                idEquipoVisitanteNew = em.getReference(idEquipoVisitanteNew.getClass(), idEquipoVisitanteNew.getIdEquipo());
                partido.setIdEquipoVisitante(idEquipoVisitanteNew);
            }
            List<Apuesta> attachedApuestaListNew = new ArrayList<Apuesta>();
            for (Apuesta apuestaListNewApuestaToAttach : apuestaListNew) {
                apuestaListNewApuestaToAttach = em.getReference(apuestaListNewApuestaToAttach.getClass(), apuestaListNewApuestaToAttach.getApuestaPK());
                attachedApuestaListNew.add(apuestaListNewApuestaToAttach);
            }
            apuestaListNew = attachedApuestaListNew;
            partido.setApuestaList(apuestaListNew);
            partido = em.merge(partido);
            if (idEquipoLocalOld != null && !idEquipoLocalOld.equals(idEquipoLocalNew)) {
                idEquipoLocalOld.getPartidoList().remove(partido);
                idEquipoLocalOld = em.merge(idEquipoLocalOld);
            }
            if (idEquipoLocalNew != null && !idEquipoLocalNew.equals(idEquipoLocalOld)) {
                idEquipoLocalNew.getPartidoList().add(partido);
                idEquipoLocalNew = em.merge(idEquipoLocalNew);
            }
            if (idEquipoVisitanteOld != null && !idEquipoVisitanteOld.equals(idEquipoVisitanteNew)) {
                idEquipoVisitanteOld.getPartidoList().remove(partido);
                idEquipoVisitanteOld = em.merge(idEquipoVisitanteOld);
            }
            if (idEquipoVisitanteNew != null && !idEquipoVisitanteNew.equals(idEquipoVisitanteOld)) {
                idEquipoVisitanteNew.getPartidoList().add(partido);
                idEquipoVisitanteNew = em.merge(idEquipoVisitanteNew);
            }
            for (Apuesta apuestaListNewApuesta : apuestaListNew) {
                if (!apuestaListOld.contains(apuestaListNewApuesta)) {
                    Partido oldPartidoOfApuestaListNewApuesta = apuestaListNewApuesta.getPartido();
                    apuestaListNewApuesta.setPartido(partido);
                    apuestaListNewApuesta = em.merge(apuestaListNewApuesta);
                    if (oldPartidoOfApuestaListNewApuesta != null && !oldPartidoOfApuestaListNewApuesta.equals(partido)) {
                        oldPartidoOfApuestaListNewApuesta.getApuestaList().remove(apuestaListNewApuesta);
                        oldPartidoOfApuestaListNewApuesta = em.merge(oldPartidoOfApuestaListNewApuesta);
                    }
                }
            }
        } catch (Exception ex) {
            try {
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = partido.getIdPartido();
                if (findPartido(id) == null) {
                    throw new NonexistentEntityException("The partido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Partido partido;
            try {
                partido = em.getReference(Partido.class, id);
                partido.getIdPartido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The partido with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Apuesta> apuestaListOrphanCheck = partido.getApuestaList();
            for (Apuesta apuestaListOrphanCheckApuesta : apuestaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Partido (" + partido + ") cannot be destroyed since the Apuesta " + apuestaListOrphanCheckApuesta + " in its apuestaList field has a non-nullable partido field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Equipo idEquipoLocal = partido.getIdEquipoLocal();
            if (idEquipoLocal != null) {
                idEquipoLocal.getPartidoList().remove(partido);
                idEquipoLocal = em.merge(idEquipoLocal);
            }
            Equipo idEquipoVisitante = partido.getIdEquipoVisitante();
            if (idEquipoVisitante != null) {
                idEquipoVisitante.getPartidoList().remove(partido);
                idEquipoVisitante = em.merge(idEquipoVisitante);
            }
            em.remove(partido);
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

    public List<Partido> findPartidoEntities() {
        return findPartidoEntities(true, -1, -1);
    }

    public List<Partido> findPartidoEntities(int maxResults, int firstResult) {
        return findPartidoEntities(false, maxResults, firstResult);
    }

    private List<Partido> findPartidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Partido.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            
        }
    }

    public Partido findPartido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Partido.class, id);
        } finally {
            
        }
    }

    public int getPartidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Partido> rt = cq.from(Partido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            
        }
    }

}
