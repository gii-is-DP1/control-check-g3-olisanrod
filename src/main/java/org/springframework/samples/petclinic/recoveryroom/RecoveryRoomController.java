package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
	
	private static final String VIEWS_ROOM_CREATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";

	private final RecoveryRoomService recService;

	@Autowired
	public RecoveryRoomController(RecoveryRoomService recService) {
		this.recService = recService;
	}

	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(ModelMap model) {
		RecoveryRoom rec = new RecoveryRoom();
		model.addAttribute("recoveryRoom", rec);
		model.addAttribute("RecoveryRoomType", rec.roomType);
		return VIEWS_ROOM_CREATE_FORM;
	}

	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom rec, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_ROOM_CREATE_FORM;
		}
		else {
			//creating owner, user and authorities
			this.recService.save(rec);
			
			return "welcome";
		}
	}
	
	
    
}
