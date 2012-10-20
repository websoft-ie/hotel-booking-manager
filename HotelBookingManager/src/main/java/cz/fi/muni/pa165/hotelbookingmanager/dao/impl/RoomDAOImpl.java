package cz.fi.muni.pa165.hotelbookingmanager.dao.impl;

import cz.fi.muni.pa165.hotelbookingmanager.dao.interfaces.RoomDAO;
import cz.fi.muni.pa165.hotelbookingmanager.entities.Room;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Implementation of RoomDAO Interface
 *
 * @author Filip Bogyai
 */
public class RoomDAOImpl implements RoomDAO{

    private EntityManagerFactory emf;

    public void setEmf(EntityManagerFactory emf) {
        if (emf == null) {
            throw new IllegalArgumentException("EntityManagerFactory cannot be null.");
        }
        this.emf = emf;
    }

    @Override
    public void create(Room room){
        if (room == null) {
            throw new IllegalArgumentException("room cannot be null!");
        }
        if (room.getHotel() == null) {
            throw new IllegalArgumentException("Hotel parameter of Room cannot be null.");
        }
        if (room != null && room.getId() != null) {
            throw new IllegalArgumentException("ID of Room is to be set automatically.");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(room);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Room get(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null!");
        }
        EntityManager em = emf.createEntityManager();
        return em.find(Room.class, id);
    }

    @Override
    public void update(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("room cannot be null!");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(room);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("room cannot be null!");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(room));
        em.merge(room.getHotel());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Room> findAllVacantRooms() {
        EntityManager em = emf.createEntityManager();
        List<Room> rooms = em.createQuery("SELECT r FROM Room r WHERE VACANT = TRUE").getResultList();
        return rooms;
    }

    @Override
    public List<Room> findAllRooms() {
        EntityManager em = emf.createEntityManager();
        List<Room> rooms = em.createQuery("SELECT r FROM Room r").getResultList();
        return rooms;
    }

}