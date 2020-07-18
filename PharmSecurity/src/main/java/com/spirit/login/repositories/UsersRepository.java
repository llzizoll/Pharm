package com.spirit.login.repositories;
import com.spirit.login.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
/**
*
* @author Zizo
*/
@Repository
 
public interface UsersRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users>{
 
//	@Transactional
//	@Modifying
//	@Query(value = "SELECT COUNT(*) FROM users", nativeQuery = true)    
//  public Integer getlastID ();    
//      
    
	 
	//NamedQuery
    Users findByUsername(String username);
	
	List<Users>	findByEmail(String email);
     
}
