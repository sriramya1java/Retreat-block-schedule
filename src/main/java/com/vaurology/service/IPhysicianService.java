package com.vaurology.service;
import java.util.List;

import com.vaurology.entity.Physicians;

public interface IPhysicianService {
List<Physicians> getAllPhysicians();
Physicians getPhysicianById(int physiciansId);
boolean addPhysician(Physicians physician);
void updatePhysician(Physicians physician);
void deletePhysician(int physiciansId);
}