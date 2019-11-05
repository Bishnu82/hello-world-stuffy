package com.stuffy.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stuffy.business.Stuffy;
import com.stuffy.db.StuffyRepository;

@CrossOrigin
@RestController
@RequestMapping("/stuffies")
public class StuffyController {
	@Autowired
	private StuffyRepository stuffyRepo;
	
	//list - return all stuffies
	@GetMapping("/")
	public JsonResponse listStuffies() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(stuffyRepo.findAll());
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	//demo use of a Path Variable
	@GetMapping("/{id}")
	public JsonResponse getStuffy(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(stuffyRepo.findById(id));
		}
		catch (Exception e){
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
//  demo of Request Parameters
//	@GetMapping("")
//	public Stuffy creatAStuffy(@RequestParam int id, @RequestParam String type, @RequestParam String color, @RequestParam String size, @RequestParam int limbs) {
//		Stuffy s = new Stuffy(id, type, color, size, limbs);
//		return s;
//	}
	
	//add - adds a new Stuffy
	@PostMapping("/")
	public JsonResponse addAStuffy(@RequestBody Stuffy s) {
		//add a new stuffy
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(stuffyRepo.save(s));
		}
		catch (Exception e){
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	//update - update a Stuffy
	@PutMapping("/")
	public JsonResponse updateStuffy(@RequestBody Stuffy s) {
		// update a stuffy
		JsonResponse jr = null;
		try {
			if (stuffyRepo.existsById(s.getId())) {
			jr = JsonResponse.getInstance(stuffyRepo.save(s));
		}
		else {
			jr = JsonResponse.getInstance("Error updating Stuffy. id:  "+s.getId()+"dosent exist!");
		}
		}
		catch (Exception e){
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@DeleteMapping("/{id}")
	public JsonResponse deleteStuffy(@PathVariable int id) {
		// delete a stuffy
		JsonResponse jr = null;
		
		try {
			if (stuffyRepo.existsById(id)) {
				stuffyRepo.deleteById(id);
			jr = JsonResponse.getInstance("Delete successful!");
		}
		else {
			//record dosent exist
			jr = JsonResponse.getInstance("Error deleting Stuffy. id:  "+id+"dosent exist!");
		}
		}
		catch (Exception e){
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	

}
