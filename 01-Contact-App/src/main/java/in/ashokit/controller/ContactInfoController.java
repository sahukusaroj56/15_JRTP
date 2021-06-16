package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.Contact;
import in.ashokit.service.ContactService;

@Controller
public class ContactInfoController {

	private ContactService contactService;

	@Autowired
	public ContactInfoController(ContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping("/loadform")
	public String loadForm(Model model) {
		Contact cobj = new Contact();
		model.addAttribute("contact", cobj);
		return "contact";
	}

	@PostMapping("/saveContact")
	public String handleSaveBtnclick(Contact contact, Model model) {
		boolean isSaved = contactService.SaveContact(contact);
		if (isSaved) {
			model.addAttribute("succMsg", "Contact Added Sucessfully");
		} else {
			model.addAttribute("errMsg", "Failed To Save Contact");
		}
		return "contact";
	}

	@GetMapping("/viewContacts")
	public ModelAndView handleViewAllContactsClick() {

		ModelAndView mav = new ModelAndView();
		
		List<Contact> allContacts = contactService.getAllContacts();
		
		//Setting data to model in key-value pair format
		mav.addObject("contacts", allContacts);
		
		//Setting Logical view name
		mav.setViewName("viewContacts");
		return mav;

	}

}
