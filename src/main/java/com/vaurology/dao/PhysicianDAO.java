package com.vaurology.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vaurology.dao.IPhysicianDAO;
import com.vaurology.entity.Physicians;
@Transactional
@Repository
public class PhysicianDAO implements IPhysicianDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Physicians getPhysicianById(int physiciansId) {
		return entityManager.find(Physicians.class, physiciansId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Physicians> getAllPhysicians() {
		String hql = "FROM Physicians as phy ORDER BY phy.physicianId";
		return (List<Physicians>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addPhysician(Physicians physician) {
		entityManager.persist(physician);
	}
	@Override
	public void updatePhysician(Physicians physician) {
		Physicians phy =  getPhysicianById(physician.getPhysicianId());
		phy.setFirstName(physician.getFirstName());
		phy.setMiddleInitial(physician.getMiddleInitial());
		phy.setLastName(physician.getLastName());
		phy.setEmpId(physician.getEmpId());
		entityManager.flush();
	}
	@Override
	public void deletePhysician(int physiciansId) {
		entityManager.remove(getPhysicianById(physiciansId));
	}
	@Override
	public boolean physicianExists(String lastName, int empId) {
		String hql = "FROM physicians as phy WHERE phy.lastName = ? and phy.empId = ?";
		int count = entityManager.createQuery(hql).setParameter(1, lastName)
		              .setParameter(2, empId).getResultList().size();
		return count > 0 ? true : false;
	}
}

