package com.spirit.login.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirit.login.entities.Users;
import com.spirit.login.exceptions.ResourceAlreadyExistException;
import com.spirit.login.exceptions.ResourceNotFoundException;
import com.spirit.login.services.todoServices;
import com.spirit.login.services.userServices;
import com.spirit.login.utils.Response;
import com.spirit.login.utils.handleResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author Zizo
 */

@RestController
@RequestMapping("/api/v1")
public class UsersController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private todoServices userServ;
	
	@Autowired
	private Response response ;

	
	 
	
	//@Secured("ROLE_ADMIN")
	@Secured("ROLE_USER")
 
	@GetMapping("/users") 
	public ResponseEntity<?> getAllusers() throws ResourceNotFoundException {
		List<Users> list = userServ.getAlluser();
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("There is no user in DB");
		}
		return ResponseEntity.ok(list);
	}
	
	


	

	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable(value = "id") Integer userId)
			throws ResourceNotFoundException {
		Users users = userServ.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found for this id  " +  userId +" Please check the ID"));
		return ResponseEntity.ok(users);
	}
	
	//.......................Add....................................
	

	@PostMapping("/addusers")
	public  ResponseEntity<Users> createUser( @RequestBody Users user)  {
		// save to database
		
		
		 userServ.saveUser(user);
		
		
			return ResponseEntity.ok().body(user);
	}

	//.......................update....................................
	
	@PutMapping("/edituserpassword/{id}")
	public ResponseEntity<Users> updateuser(@PathVariable(value = "id") Integer usereId,
			 @RequestBody Users u) throws ResourceNotFoundException  {
    	
    	Users current = userServ.findById(usereId)
    			.orElseThrow(() -> new ResourceNotFoundException("Users not found for this id  " +  usereId +" Please check the ID"));

	
    	current.setId(usereId);
    	current.setPassword(u.getPassword()); 

				Users x=	userServ.saveUser(current);

				return new ResponseEntity<Users>(x, HttpStatus.OK);
	}
    
    @PatchMapping(value = "/update/{Uid}")
	public Response update(@RequestBody Users u, @PathVariable(value = "Uid") int Uid) {
	
		try {
			
			Users current = userServ.findById(Uid)
		.orElseThrow(() -> new ResourceNotFoundException("Users not found for this id  " +  Uid +" Please check the ID"));
			
			
			
			current.setId(Uid);
			
			current.setPassword(u.getPassword() == null ?  current.getPassword():  u.getPassword());
			
			
			current.setUsername( u.getUsername() == null ?  current.getUsername():  u.getUsername());
			current.setEmail( u.getEmail() == null ?  current.getEmail():  u.getEmail());
			
			
			 userServ.saveUser(current);
			response=handleResponse.getResponse("1000", "updated", "updated Succesfully", new Date(), null);

		} catch (Exception e) {
			response=handleResponse.getResponse("1001", "Notupdated", e.getMessage(), new Date(), null);

		}
		return response; 

	}  
    

	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<Void> deleteuser(@PathVariable(value = "id") Integer userId)
			throws ResourceNotFoundException {
		Users user = userServ.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		userServ.deleteUser(user);
	 
		return ResponseEntity.notFound().build();
	}
	
	//.......................delete....................................
	
	@DeleteMapping("delete/{id}")
	private Response deleteUsert(@PathVariable int id) {
	
		try {
			userServ.deleteUserbyID(id);

			response=handleResponse.getResponse("1000", "deleted", "deleted Succesfully", new Date(), null);

		} catch (Exception e) {
		
			response=handleResponse.getResponse("1001", "Notdeleted", e.getMessage(), new Date(), null);

		}
		return response;
	}
	
	
	@DeleteMapping("delete2/{id}")

	 public ResponseEntity<?> deleteUser(@PathVariable("id") int Uid) throws ResourceNotFoundException {
	      
			Users current = userServ.findById(Uid)
					.orElseThrow(() -> new ResourceNotFoundException("Users not found for this id  " +  Uid +" Please check the ID"));
						
						
			userServ.deleteUserbyID(Uid);
	        return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
	    }
	 
	
}
