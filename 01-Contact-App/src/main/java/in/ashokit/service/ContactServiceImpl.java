package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactRepository contactRepo;
	
	@Autowired
	public ContactServiceImpl(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	@Override
	public boolean SaveContact(Contact contact) {
		Contact savedEntity = contactRepo.save(contact);
		if(savedEntity != null && savedEntity.getContactId() !=null) {
			return true;
		}
		return false;
	}
 
	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = contactRepo.findAll();
		return contacts;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		boolean existsById = contactRepo.existsById(contactId);
		if(existsById) {
			contactRepo.deleteById(contactId);
			return true;
		}
		return false;
	}

}
