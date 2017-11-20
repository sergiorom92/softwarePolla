/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.vista;

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

import com.usa.pollasoftwareweb.entidad.Equipo;
import com.usa.pollasoftwareweb.entidad.Partido;

/**
 *
 * @author sergio
 */
@Stateless
public class EquipoJpaController implements Serializable {

    @PersistenceContext(unitName = "co.com_polla_war_1.0PU")
    private EntityManager em;

    public EquipoJpaController() {
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void create(Equipo equipo) throws RollbackFailureException, Exception {
        if (equipo.getPartidoList() == null) {
            equipo.setPartidoList(new ArrayList<Partido>());
        }
        if (equipo.getPartidoList1() == null) {
            equipo.setPartidoList1(new ArrayList<Partido>());
        }
        EntityManager em = null;
        try {
            em.getTransaction().begin();
            em = getEntityManager();
            List<Partido> attachedPartidoList = new ArrayList<Partido>();
            for (Partido partidoListPartidoToAttach : equipo.getPartidoList()) {
                partidoListPartidoToAttach = em.getReference(partidoListPartidoToAttach.getClass(), partidoListPartidoToAttach.getIdPartido());
                attachedPartidoList.add(partidoListPartidoToAttach);
            }
            equipo.setPartidoList(attachedPartidoList);
            List<Partido> attachedPartidoList1 = new ArrayList<Partido>();
            for (Partido partidoList1PartidoToAttach : equipo.getPartidoList1()) {
                partidoList1PartidoToAttach = em.getReference(partidoList1PartidoToAttach.getClass(), partidoList1PartidoToAttach.getIdPartido());
                attachedPartidoList1.add(partidoList1PartidoToAttach);
            }
            equipo.setPartidoList1(attachedPartidoList1);
            em.persist(equipo);
            for (Partido partidoListPartido : equipo.getPartidoList()) {
                Equipo oldIdEquipoLocalOfPartidoListPartido = partidoListPartido.getIdEquipoLocal();
                partidoListPartido.setIdEquipoLocal(equipo);
                partidoListPartido = em.merge(partidoListPartido);
                if (oldIdEquipoLocalOfPartidoListPartido != null) {
                    oldIdEquipoLocalOfPartidoListPartido.getPartidoList().remove(partidoListPartido);
                    oldIdEquipoLocalOfPartidoListPartido = em.merge(oldIdEquipoLocalOfPartidoListPartido);
                }
            }
            for (Partido partidoList1Partido : equipo.getPartidoList1()) {
                Equipo oldIdEquipoVisitanteOfPartidoList1Partido = partidoList1Partido.getIdEquipoVisitante();
                partidoList1Partido.setIdEquipoVisitante(equipo);
                partidoList1Partido = em.merge(partidoList1Partido);
                if (oldIdEquipoVisitanteOfPartidoList1Partido != null) {
                    oldIdEquipoVisitanteOfPartidoList1Partido.getPartidoList1().remove(partidoList1Partido);
                    oldIdEquipoVisitanteOfPartidoList1Partido = em.merge(oldIdEquipoVisitanteOfPartidoList1Partido);
                }
            }
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

    public void edit(Equipo equipo) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em.getTransaction().begin();
            em = getEntityManager();
            Equipo persistentEquipo = em.find(Equipo.class, equipo.getIdEquipo());
            List<Partido> partidoListOld = persistentEquipo.getPartidoList();
            List<Partido> partidoListNew = equipo.getPartidoList();
            List<Partido> partidoList1Old = persistentEquipo.getPartidoList1();
            List<Partido> partidoList1New = equipo.getPartidoList1();
            List<String> illegalOrphanMessages = null;
            for (Partido partidoListOldPartido : partidoListOld) {
                if (!partidoListNew.contains(partidoListOldPartido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Partido " + partidoListOldPartido + " since its idEquipoLocal field is not nullable.");
                }
            }
            for (Partido partidoList1OldPartido : partidoList1Old) {
                if (!partidoList1New.contains(partidoList1OldPartido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Partido " + partidoList1OldPartido + " since its idEquipoVisitante field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Partido> attachedPartidoListNew = new ArrayList<Partido>();
            for (Partido partidoListNewPartidoToAttach : partidoListNew) {
                partidoListNewPartidoToAttach = em.getReference(partidoListNewPartidoToAttach.getClass(), partidoListNewPartidoToAttach.getIdPartido());
                attachedPartidoListNew.add(partidoListNewPartidoToAttach);
            }
            partidoListNew = attachedPartidoListNew;
            equipo.setPartidoList(partidoListNew);
            List<Partido> attachedPartidoList1New = new ArrayList<Partido>();
            for (Partido partidoList1NewPartidoToAttach : partidoList1New) {
                partidoList1NewPartidoToAttach = em.getReference(partidoList1NewPartidoToAttach.getClass(), partidoList1NewPartidoToAttach.getIdPartido());
                attachedPartidoList1New.add(partidoList1NewPartidoToAttach);
            }
            partidoList1New = attachedPartidoList1New;
            equipo.setPartidoList1(partidoList1New);
            equipo = em.merge(equipo);
            for (Partido partidoListNewPartido : partidoListNew) {
                if (!partidoListOld.contains(partidoListNewPartido)) {
                    Equipo oldIdEquipoLocalOfPartidoListNewPartido = partidoListNewPartido.getIdEquipoLocal();
                    partidoListNewPartido.setIdEquipoLocal(equipo);
                    partidoListNewPartido = em.merge(partidoListNewPartido);
                    if (oldIdEquipoLocalOfPartidoListNewPartido != null && !oldIdEquipoLocalOfPartidoListNewPartido.equals(equipo)) {
                        oldIdEquipoLocalOfPartidoListNewPartido.getPartidoList().remove(partidoListNewPartido);
                        oldIdEquipoLocalOfPartidoListNewPartido = em.merge(oldIdEquipoLocalOfPartidoListNewPartido);
                    }
                }
            }
            for (Partido partidoList1NewPartido : partidoList1New) {
                if (!partidoList1Old.contains(partidoList1NewPartido)) {
                    Equipo oldIdEquipoVisitanteOfPartidoList1NewPartido = partidoList1NewPartido.getIdEquipoVisitante();
                    partidoList1NewPartido.setIdEquipoVisitante(equipo);
                    partidoList1NewPartido = em.merge(partidoList1NewPartido);
                    if (oldIdEquipoVisitanteOfPartidoList1NewPartido != null && !oldIdEquipoVisitanteOfPartidoList1NewPartido.equals(equipo)) {
                        oldIdEquipoVisitanteOfPartidoList1NewPartido.getPartidoList1().remove(partidoList1NewPartido);
                        oldIdEquipoVisitanteOfPartidoList1NewPartido = em.merge(oldIdEquipoVisitanteOfPartidoList1NewPartido);
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
                Integer id = equipo.getIdEquipo();
                if (findEquipo(id) == null) {
                    throw new NonexistentEntityException("The equipo with id " + id + " no longer exists.");
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
            em.getTransaction().begin();
            em = getEntityManager();
            Equipo equipo;
            try {
                equipo = em.getReference(Equipo.class, id);
                equipo.getIdEquipo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Partido> partidoListOrphanCheck = equipo.getPartidoList();
            for (Partido partidoListOrphanCheckPartido : partidoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Equipo (" + equipo + ") cannot be destroyed since the Partido " + partidoListOrphanCheckPartido + " in its partidoList field has a non-nullable idEquipoLocal field.");
            }
            List<Partido> partidoList1OrphanCheck = equipo.getPartidoList1();
            for (Partido partidoList1OrphanCheckPartido : partidoList1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Equipo (" + equipo + ") cannot be destroyed since the Partido " + partidoList1OrphanCheckPartido + " in its partidoList1 field has a non-nullable idEquipoVisitante field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(equipo);
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

    public List<Equipo> findEquipoEntities() {
        return findEquipoEntities(true, -1, -1);
    }

    public List<Equipo> findEquipoEntities(int maxResults, int firstResult) {
        return findEquipoEntities(false, maxResults, firstResult);
    }

    private List<Equipo> findEquipoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Equipo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            
        }
    }

    public Equipo findEquipo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Equipo.class, id);
        } finally {
            
        }
    }

    public int getEquipoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Equipo> rt = cq.from(Equipo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            
        }
    }

}
