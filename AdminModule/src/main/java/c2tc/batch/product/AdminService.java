package c2tc.batch.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService
{
	@Autowired
	private AdminRepository repository;

	public Admin get(Integer id) {
	return repository.findById(id).get();
	}

	public void delete(Integer id) {
		repository.deleteById(id);

	}

	public void save(Admin Admin) {
		repository.save(Admin);

	}

	public List<Admin> listAll() {
		return repository.findAll();
	}

}