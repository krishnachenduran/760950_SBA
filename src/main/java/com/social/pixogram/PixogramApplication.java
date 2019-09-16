package com.social.pixogram;

import java.util.stream.Stream;

import javax.annotation.Resource;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.social.pixogram.model.Blocked;
import com.social.pixogram.model.Follow;
import com.social.pixogram.model.Media;
import com.social.pixogram.model.User;
import com.social.pixogram.repo.BlockedRepo;
import com.social.pixogram.repo.FollowRepo;
import com.social.pixogram.repo.MediaRepo;
import com.social.pixogram.repo.UserRepo;
import com.social.pixogram.service.StorageService;

@SpringBootApplication
public class PixogramApplication implements CommandLineRunner {

	@Resource
	StorageService storageService;
	@Resource
	MediaRepo mediaRepo;

	public static void main(String[] args) {
		SpringApplication.run(PixogramApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(UserRepo userRepo) {
		return args -> {
			Stream.of(new User("User1", "user1@gmail.com", "root"), new User("User2", "user2@gmail.com", "root"),
					new User("User3", "user3@gmail.com", "root"), new User("User4", "user4@gmail.com", "root"),
					new User("User5", "user5@gmail.com", "root"), new User("User6", "user6@gmail.com", "root"),
					new User("User7", "user7@gmail.com", "root"), new User("User8", "user8@gmail.com", "root"),
					new User("User9", "user9@gmail.com", "root"), new User("User10", "user10@gmail.com", "root"))
					.forEach(user -> {
						userRepo.save(user);
					});
			//userRepo.findAll().forEach(System.out::println);
		};
	}

	@Bean
	ApplicationRunner init1(MediaRepo mediaRepo, StorageService storageService) {
		return args -> {
			Stream.of(new Media(1, "dummy1.jpg", -1, 45, 8), new Media(1, "dummy2.jpg", -1, 56, 7),
					new Media(2, "dummy3.jpg", -1, 45, 19), new Media(2, "dummy4.jpg", -1, 12, 0),
					new Media(3, "dummy5.jpg", -1, 45, 88), new Media(3, "dummy6.jpg", -1, 77, 23),
					new Media(4, "dummy7.jpg", -1, 76, 56), new Media(4, "dummy8.jpg", -1, 12, 23),
					new Media(5, "dummy9.jpg", -1, 23, 56), new Media(5, "dummy10.jpg", -1, 67, 56),
					new Media(6, "dummy11.jpg", -1, 88, 99), new Media(6, "dummy12.jpg", -1, 12, 23),
					new Media(7, "dummy13.jpg", -1, 99, 100), new Media(7, "dummy14.jpg", -1, 11, 22),
					new Media(8, "dummy15.jpg", -1, 88, 44), new Media(8, "dummy16.jpg", -1, 67, 9),
					new Media(9, "dummy17.jpg", -1, 0, 0), new Media(9, "dummy18.jpg", -1, 98, 0)).forEach(media -> {
						mediaRepo.save(media);
					});
			//mediaRepo.findAll().forEach(System.out::println);
		};
	}

	@Bean
	ApplicationRunner init2(FollowRepo followRepo) {
		return args -> {
			Stream.of(new Follow(1, 2), new Follow(1, 3), new Follow(1, 4), new Follow(1, 10), new Follow(1, 3),
					new Follow(2, 1), new Follow(2, 5), new Follow(2, 9), new Follow(4, 5), new Follow(3, 8),
					new Follow(4, 1), new Follow(6, 7), new Follow(6, 3), new Follow(5, 3), new Follow(7, 6),
					new Follow(7, 1), new Follow(7, 2), new Follow(9, 10), new Follow(9, 4), new Follow(6, 8))
					.forEach(follow -> {
						followRepo.save(follow);
					});
			//followRepo.findAll().forEach(System.out::println);
		};
	}

	@Bean
	ApplicationRunner init3(BlockedRepo blockedRepo) {
		return args -> {
			Stream.of(new Blocked(1, 6), new Blocked(1, 3), new Blocked(2, 9), new Blocked(2, 7), new Blocked(10, 1),
					new Blocked(10, 3), new Blocked(9, 1), new Blocked(8, 10)).forEach(blocked -> {
						blockedRepo.save(blocked);
					});
			//blockedRepo.findAll().forEach(System.out::println);
		};
	}

	@Override
	public void run(String... arg) throws Exception {
		//storageService.deleteAll();
		storageService.init();
	}

}
