package br.ifpe.pg.contatos.contato;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

	@Autowired
	private ContactService service;
	
	public ContactController (ContactService cs) {
		this.service = cs;
	}
	
	@GetMapping("/listarContatos")
	public ModelAndView list() {		
		return showContactList(new Contact());
	}
		
	@GetMapping("/exibirEdicao/{codigo}")
	public ModelAndView exibirEdicao(@PathVariable("codigo") long codigo) {
		Contact cont = service.findById(codigo);
		return showContactList(cont);
	}
	
	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") long codigo) {
		service.delete(codigo);
		return list();
	}

	private ModelAndView showContactList(Contact contAux) {
		ModelAndView mv = new ModelAndView("contatos-list");
		mv.addObject("lista", service.listAllContacts());
		mv.addObject("contato", contAux);
		return mv;
	}

	@PostMapping("/salvarContato")
	public String save(@Valid @ModelAttribute Contact contact, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return "/listarContatos";
		}
		service.save(contact);
		return "redirect:/listarContatos";
	}
	
	
}
