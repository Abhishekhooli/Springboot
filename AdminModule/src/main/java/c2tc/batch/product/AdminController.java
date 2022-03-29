package c2tc.batch.product;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController
{
	@Autowired
	private AdminService service;
	
	@GetMapping("/admin")
	public List<Admin> list()
	{
		return service.listAll();
	
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> get(@PathVariable Integer id)
	{
		try
		{
		Admin Admin = service.get(id);
		return new ResponseEntity<Admin>(Admin, HttpStatus.OK);
		}
		 catch (NoSuchElementException e) 
		 {
		 return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		 } 
		}
	
	//CREATE a row in database
	@PostMapping("/admin")
	public void add(@RequestBody Admin Admin)
	{
		service.save(Admin);
	}
	
	//update operation - record in database
	@PutMapping("/admin/{id}")
	public ResponseEntity<?>update(@RequestBody Admin Admin, @PathVariable Integer id)
	{
		try
		{
		Admin existAdmin = service.get(id);
		service.save(Admin);
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete operation
	@DeleteMapping("/admin/{id}")
	public void delete(@PathVariable Integer id)
	{
		service.delete(id);
	}
	}
