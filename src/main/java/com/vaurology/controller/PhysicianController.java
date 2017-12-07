package com.vaurology.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.vaurology.entity.Physicians;
import com.vaurology.service.IPhysicianService;

@Controller
@RequestMapping("user")
public class PhysicianController {
	@Autowired
	private IPhysicianService physicianService;
	@GetMapping("physician/{id}")
	public ResponseEntity<Physicians> getPhysicianById(@PathVariable("id") Integer id) {
		Physicians physician = physicianService.getPhysicianById(id);
		return new ResponseEntity<Physicians>(physician, HttpStatus.OK);
	}
	@GetMapping("physicians")
	public ResponseEntity<List<Physicians>> getAllPhysicians() {
		List<Physicians> list = physicianService.getAllPhysicians();
		return new ResponseEntity<List<Physicians>>(list, HttpStatus.OK);
	}
	@PostMapping("physician")
	public ResponseEntity<Void> addPhysician(@RequestBody Physicians physician, UriComponentsBuilder builder) {
        boolean flag = physicianService.addPhysician(physician);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/physician/{id}").buildAndExpand(physician.getPhysicianId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("physician")
	public ResponseEntity<Physicians> updatePhysician(@RequestBody Physicians physician) {
		physicianService.updatePhysician(physician);
		return new ResponseEntity<Physicians>(physician, HttpStatus.OK);
	}
	@DeleteMapping("physician/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		physicianService.deletePhysician(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 