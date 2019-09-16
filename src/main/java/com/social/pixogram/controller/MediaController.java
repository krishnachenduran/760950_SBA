package com.social.pixogram.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.social.pixogram.model.Media;
import com.social.pixogram.model.User;
import com.social.pixogram.service.MediaService;
import com.social.pixogram.service.StorageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MediaController {

	@Autowired
	MediaService mediaService;
	
	@Autowired
	StorageService storageService;
	
	List<String> files = new ArrayList<String>();

	@GetMapping(path = "/media/{userId}")
	public List<Media> getUsersMedia(@PathVariable int userId) {
		//////System.out.println("Get all media for the user " + userId);
		List<Media> medias = mediaService.getUsersMedia(userId);
		List<Media> _medias = new ArrayList<>();
		
		//////System.out.println(userId);
		//////System.out.println(medias);
		for (Media media : medias) {
			if (media.getUserId() == userId) {
				_medias.add(media);
			}
		}
		//////System.out.println(_medias);
		return _medias;
	}
	
	@GetMapping(path="/media/followings/{userId}")
	public List<Media> getFollowMeidas(@PathVariable long userId){
		//////System.out.println("get followings media "+userId);
		return mediaService.getFollowingsMedia(userId);
	}
	@GetMapping(path="/media/getuser/{mediaId}")
		public List<User> getUserName(@PathVariable("mediaId") long id) {
		//////System.out.println("get user name");
			return mediaService.getUserName(id);	
		}
	

	
}