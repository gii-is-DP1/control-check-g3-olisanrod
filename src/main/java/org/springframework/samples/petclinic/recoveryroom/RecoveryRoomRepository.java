package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
	
	@Query("SELECT room FROM RecoveryRoom room")
    List<RecoveryRoom> findAll();
    
    @Query("SELECT type FROM RecoveryRoomType type")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT type FROM RecoveryRoomType type WHERE type.name =?1")
    RecoveryRoomType getRecoveryRoomType(String name);
    
    @Query("SELECT room FROM RecoveryRoom room WHERE room.size =?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);
    
    

}
