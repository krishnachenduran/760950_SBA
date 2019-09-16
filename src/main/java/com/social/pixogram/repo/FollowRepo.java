package com.social.pixogram.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.social.pixogram.model.Follow;
import com.social.pixogram.model.User;

public interface FollowRepo extends CrudRepository<Follow, Long>{

	
	@Query("Select u from User u where u.id in (select f.userId from Follow f where f.followId like ?1 )")
	public List<User> getFollowers(long id);
}
