package com.vaurology;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.vaurology.entity.Physicians;

public class RetreatScheduleApplicationTests {
    public void getPhysicianByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/physician/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Physicians> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Physicians.class, 1);
        Physicians physician = responseEntity.getBody();
        System.out.println("Id:"+physician.getPhysicianId()+", Firstname:"+physician.getFirstName()
                 +", Middleinitial:"+physician.getFirstName()+", Lastname:"+physician.getLastName()+", EmpId:"+physician.getEmpId());      
    }
	public void getAllPhysiciansDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/physicians";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Physicians[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Physicians[].class);
        Physicians[] physicians = responseEntity.getBody();
        for(Physicians physician : physicians) {
              System.out.println("Id:"+physician.getPhysicianId()+", Firstname:"+physician.getFirstName()
              +", Middleinitial:"+physician.getFirstName()+", Lastname:"+physician.getLastName()+", EmpId:"+physician.getEmpId());
        }
    }
    public void addPhysicianDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/physician";
	    Physicians objPhysician = new Physicians();
	    objPhysician.setPhysicianId(15);
	    objPhysician.setFirstName("Kint");
	    objPhysician.setMiddleInitial("L");
	    objPhysician.setLastName("Rollins");
	    objPhysician.setEmpId(1234);
        HttpEntity<Physicians> requestEntity = new HttpEntity<Physicians>(objPhysician, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updatePhysicianDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/physician";
	    Physicians objPhysician = new Physicians();
	    objPhysician.setPhysicianId(15);
	    objPhysician.setFirstName("Update: Kent");
	    objPhysician.setMiddleInitial("L");
	    objPhysician.setLastName("Rollins");
	    objPhysician.setEmpId(1234);
        HttpEntity<Physicians> requestEntity = new HttpEntity<Physicians>(objPhysician, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/physician/{id}";
        HttpEntity<Physicians> requestEntity = new HttpEntity<Physicians>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RetreatScheduleApplicationTests util = new RetreatScheduleApplicationTests();
        //util.getArticleByIdDemo();
    	util.getAllPhysiciansDemo();
    	//util.addArticleDemo();
    	//util.updateArticleDemo();
    	//util.deleteArticleDemo();
    }    
}
