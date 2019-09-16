package com.social.pixogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.pixogram.model.Blocked;
import com.social.pixogram.repo.BlockedRepo;

@Service
public class BlockedServiceImpl implements BlockedService{

	@Autowired
	BlockedRepo blockedRepo;

	@Override
	public List<Blocked> getAllBlocked() {
		return (List<Blocked>) blockedRepo.findAll();
	}

	@Override
	public void unblockUser(Long id,Long blockedId) {
		System.out.println("unblock");
		Blocked block=new Blocked(id,blockedId);
		blockedRepo.delete(block);
		blockedRepo.unblockUser(id,blockedId);
		
	}

	@Override
	public Blocked blockUser(Blocked block) {
		return blockedRepo.save(block);
	}
	
	
}
