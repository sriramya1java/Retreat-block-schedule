package com.vaurology.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaurology.dao.IPhysicianDAO;
import com.vaurology.entity.Physicians;
@Service
public class PhysicianService implements IPhysicianService {
	@Autowired
	private IPhysicianDAO physicianDAO;
	@Override
	public Physicians getPhysicianById(int physicianId) {
		Physicians obj = physicianDAO.getPhysicianById(physicianId);
		return obj;
	}	
	@Override
	public List<Physicians> getAllPhysicians(){
		return physicianDAO.getAllPhysicians();
	}
	@Override
	public synchronized boolean addPhysician(Physicians physician){
       if (physicianDAO.physicianExists(physician.getLastName(), physician.getEmpId())) {
    	   return false;
       } else {
    	   physicianDAO.addPhysician(physician);
    	   return true;
       }
	}
	@Override
	public void updatePhysician(Physicians article) {
		physicianDAO.updatePhysician(article);
	}
	@Override
	public void deletePhysician(int physicianId) {
		physicianDAO.deletePhysician(physicianId);
	}
}