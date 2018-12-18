package br.ifpe.pg.contatos.contato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repository;

	public ContactService(ContactRepository repository) {
		super();
		this.repository = repository;
	}

	public <S extends Contact> S save(S entity) {
		return repository.save(entity);
	}

	public List<Contact> listAllContacts() {
		return repository.findAll();
	}

	public Contact findById(long id) {
		return repository.findById(id).orElse(null);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

	
}
