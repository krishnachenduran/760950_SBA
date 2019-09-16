package com.social.pixogram.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.social.pixogram.model.Media;
import com.social.pixogram.model.User;

public interface MediaRepo extends CrudRepository<Media, Long> {
	@Query(value="Select m from Media m where m.userId in (select f.followId from Follow f where f.userId = ?1)")
	public List<Media> getFollowingsMedia(long Id);

	@Query(value="select u from User u where u.id =?1")
	public List<User> getUserName(long id);

}
