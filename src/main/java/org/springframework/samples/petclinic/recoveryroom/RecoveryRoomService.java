package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	@Autowired
	private RecoveryRoomRepository rep;
	
    public List<RecoveryRoom> getAll(){
        return this.rep.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return this.rep.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return this.rep.getRecoveryRoomType(typeName);
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return this.rep.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
		return this.rep.save(p);	     
    }

    
}
