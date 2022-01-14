package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	@Autowired
	private RecoveryRoomRepository recoveryRoomRepository;
	
    public List<RecoveryRoom> getAll(){
    	List<RecoveryRoom> lista = recoveryRoomRepository.findAll();
        return lista;
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
    	RecoveryRoomType rec = recoveryRoomRepository.getRecoveryRoomType(typeName);
        return rec;
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
    	List<RecoveryRoom> room = recoveryRoomRepository.findBySizeMoreThan(size);
        return room;
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return null;       
    }

    
}
