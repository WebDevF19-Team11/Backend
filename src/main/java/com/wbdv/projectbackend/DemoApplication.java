package com.wbdv.projectbackend;

import com.google.common.collect.Sets;
import com.wbdv.projectbackend.auth.AuthoritiesConstants;
import com.wbdv.projectbackend.auth.Constants;
import com.wbdv.projectbackend.model.Category;
import com.wbdv.projectbackend.model.Item;
import com.wbdv.projectbackend.model.Offer;
import com.wbdv.projectbackend.model.User;
import com.wbdv.projectbackend.repository.CategoryRepository;
import com.wbdv.projectbackend.repository.ItemRepository;
import com.wbdv.projectbackend.repository.OfferRepository;
import com.wbdv.projectbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;
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
	private ItemRepository itemRepository;
	@Autowired
	private OfferRepository offerRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void addData() {
		User bob = new User();
		User alice = new User();
		User charlie = new User();
		User dan = new User();

		/**
		User user = new User();
		user.setFirstName("demo user firstname");
		user.setLastName("demo user lastname");
		user.setUsername("demo-user");
		user.setPassword(new BCryptPasswordEncoder().encode("demo-password"));
		HashSet<GrantedAuthority> roles = new HashSet<>();
		roles.add(new SimpleGrantedAuthority(AuthoritiesConstants.USER));
		user.setRoles(roles);

		User admin = new User();
		admin.setFirstName("demo admin firstname");
		admin.setLastName("demo admin lastname");
		admin.setUsername("demo-admin");
		admin.setPassword(new BCryptPasswordEncoder().encode("demo-password"));
		HashSet<GrantedAuthority> adminRoles = new HashSet<>();
		adminRoles.add(new SimpleGrantedAuthority(AuthoritiesConstants.ADMIN));
		admin.setRoles(adminRoles);*/

		bob.setUsername("bob");
		alice.setUsername("alice");
		charlie.setUsername("charlie");
		dan.setUsername("dan");

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		bob.setPassword(bCryptPasswordEncoder.encode("bob"));
		alice.setPassword(bCryptPasswordEncoder.encode("alice"));
		charlie.setPassword(bCryptPasswordEncoder.encode("charlie"));
		dan.setPassword(bCryptPasswordEncoder.encode("dan"));

		bob.setFirstName("bob");
		alice.setFirstName("alice");
		charlie.setFirstName("charlie");
		dan.setFirstName("dan");

		bob.setLastName("bob");
		alice.setLastName("alice");
		charlie.setLastName("charlie");
		dan.setLastName("dan");

		Set<GrantedAuthority> userRoles = new HashSet<>();
		userRoles.add(new SimpleGrantedAuthority(AuthoritiesConstants.USER));
		Set<GrantedAuthority> adminRoles = new HashSet<>();
		adminRoles.add(new SimpleGrantedAuthority(AuthoritiesConstants.ADMIN));

		bob.setRoles(userRoles);
		alice.setRoles(userRoles);
		charlie.setRoles(userRoles);
		dan.setRoles(adminRoles);

		bob.setFollowers(Sets.newHashSet("alice", "dan"));
		alice.setFollowers(Sets.newHashSet("bob", "dan", "charlie"));
		charlie.setFollowers(Sets.newHashSet("dan"));
		dan.setFollowers(Sets.newHashSet("bob", "alice"));

		bob.setFollowing(Sets.newHashSet("alice", "dan"));
		alice.setFollowing(Sets.newHashSet("bob", "dan"));
		charlie.setFollowing(Sets.newHashSet("alice"));
		dan.setFollowing(Sets.newHashSet("charlie", "alice", "bob"));

		userRepository.save(bob);
		userRepository.save(alice);
		userRepository.save(charlie);
		userRepository.save(dan);

		Category category = new Category();
		category.setName("General");
		categoryRepository.save(category);

		Offer bobOffer = new Offer();
		bobOffer.setPrice(17.0d);
		bobOffer.setQuantity(1);
		bobOffer.setSeller(bob);
		Item bobItem = new Item();
		bobItem.setDescription("Bob Item 1 Description");
		bobItem.setTitle("Bob Item 1 Title");
		bobItem.setCategoryList(Collections.singletonList(category));
		itemRepository.save(bobItem);

		bobOffer.setItem(bobItem);
		offerRepository.save(bobOffer);

	}

}
