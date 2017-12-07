package com.vaurology.dao;
import java.util.List;
import com.vaurology.entity.Physicians;
public interface IPhysicianDAO {
	List<Physicians> getAllPhysicians();
	Physicians getPhysicianById(int physiciansId);
	void addPhysician(Physicians physician);
	void updatePhysician(Physicians physician);
	void deletePhysician(int physiciansId);
	boolean physicianExists(String lastName, int empId);
}