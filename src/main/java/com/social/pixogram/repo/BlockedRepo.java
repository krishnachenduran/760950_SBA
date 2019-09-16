package com.social.pixogram.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.social.pixogram.model.Blocked;

public interface BlockedRepo extends CrudRepository<Blocked, Long>{

		@Transactional
		@Modifying
		@Query(value="Delete from Blocked b where b.userId like ?1 and b.blockedId like ?2")
		void unblockUser(long id,long blockedId);
}
