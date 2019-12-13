package com.wbdv.projectbackend;

import com.google.common.collect.Sets;
import com.wbdv.projectbackend.model.*;
import com.wbdv.projectbackend.repository.CategoryRepository;
import com.wbdv.projectbackend.repository.ItemRepository;
import com.wbdv.projectbackend.repository.OfferRepository;
import com.wbdv.projectbackend.repository.UserRepository;
import com.wbdv.projectbackend.serives.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private LoginService loginService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void mockData() {
		User bob = new User();
		User alice = new User();
		User charlie = new User();
		User dan = new User();
		User admin = new User();

		bob.setFirstName("Bob");
		alice.setFirstName("Alice");
		charlie.setFirstName("Charlie");
		dan.setFirstName("Dan");
		admin.setFirstName("Admin");

		bob.setLastName("Bob");
		alice.setLastName("Alice");
		charlie.setLastName("Charlie");
		dan.setLastName("Dan");
		admin.setLastName("Admin");

		bob.setUsername("bob");
		alice.setUsername("alice");
		charlie.setUsername("charlie");
		dan.setUsername("dan");
		admin.setUsername("admin");

		bob.setType("seller");
		alice.setType("seller");
		charlie.setType("buyer");
		dan.setType("buyer");
		admin.setType("seller");

		BCryptPasswordEncoder bCryptPasswordEncoder = loginService.getbCryptPasswordEncoder();
		bob.setPw(bCryptPasswordEncoder.encode("bob"));
		alice.setPw(bCryptPasswordEncoder.encode("alice"));
		charlie.setPw(bCryptPasswordEncoder.encode("charlie"));
		dan.setPw(bCryptPasswordEncoder.encode("dan"));
		admin.setPw(bCryptPasswordEncoder.encode("admin"));

		Set<String> userRoles = new HashSet<>();
		userRoles.add(Roles.USER);
		Set<String> adminRoles = new HashSet<>();
		adminRoles.add(Roles.ADMIN);

		bob.setRoles(userRoles);
		alice.setRoles(userRoles);
		charlie.setRoles(userRoles);
		dan.setRoles(adminRoles);
		admin.setRoles(adminRoles);

		bob.setFollowers(Sets.newHashSet("alice", "dan"));
		alice.setFollowers(Sets.newHashSet("bob", "dan", "charlie"));
		charlie.setFollowers(Sets.newHashSet("dan"));
		dan.setFollowers(Sets.newHashSet("bob", "alice"));
		admin.setFollowers(Sets.newHashSet("bob", "alice", "charlie", "dan"));

		bob.setFollowing(Sets.newHashSet("alice", "dan"));
		alice.setFollowing(Sets.newHashSet("bob", "dan"));
		charlie.setFollowing(Sets.newHashSet("alice"));
		dan.setFollowing(Sets.newHashSet("charlie", "alice", "bob"));
		admin.setFollowing(Sets.newHashSet("alice"));

		userRepository.save(bob);
		userRepository.save(alice);
		userRepository.save(charlie);
		userRepository.save(dan);
		userRepository.save(admin);

		Category category = new Category();
		category.setName("General");
		categoryRepository.save(category);

		Offer bobOffer = new Offer();
		bobOffer.setPrice(17.0d);
		bobOffer.setQuantity(1);
		bobOffer.setSeller(bob);
		offerRepository.save(bobOffer);

		Item bobItem = new Item();
		bobItem.setDescription("Bob Item 1 Description");
		bobItem.setTitle("Bob Item 1 Title");
		bobItem.setCategoryList(Collections.singletonList(category));
		itemRepository.save(bobItem);

		Item oneByTitle = itemRepository.findOneByTitle("Bob Item 1 Title");
		bobOffer.setItem(oneByTitle);
		offerRepository.save(bobOffer);
	}
}
