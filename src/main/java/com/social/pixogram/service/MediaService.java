package com.social.pixogram.service;

import java.util.List;

import com.social.pixogram.model.Media;
import com.social.pixogram.model.User;

public interface MediaService {

	public List<Media> getUsersMedia(int userId);

	public Media postMedia(Media m);
	
	public List<Media> getFollowingsMedia(long id);
	
	public List<User> getUserName(long id);
}
