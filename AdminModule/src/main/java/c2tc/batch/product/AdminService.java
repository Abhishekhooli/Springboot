package c2tc.batch.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class AdminService
{
	@Autowired
	private AdminRepository repository;

	public List<Admin> listAll() 
	{
		
		return repository.findAll();
	}

	public Admin get(Integer id)
	{
	
		return repository.findById(id).get();
	}

	public void save(Admin admin)
	{
		repository.save(admin);
		
	}

	public void delete(Integer id)
	{
		repository.deleteById(id);
		
	}

}
