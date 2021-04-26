package com.volapp.charity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.volapp.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/charity")
public class CharityController {

	@Autowired
	private CharityRepository charityRepo;

	@Autowired
	private MySQLUserDetailsService mySQLUserDetailsService;

	@GetMapping
	public List<Charity> getAllCharities() {
		return charityRepo.findAll();
	}

	@PostMapping
	public ResponseEntity<Charity> createCharity(@Valid @RequestBody Charity charity) throws Exception {
		mySQLUserDetailsService.Save(charity);
		return ResponseEntity.ok(charity);
	}

	@GetMapping("/login/{id}")
	public ResponseEntity<Charity> getCharityById(@PathVariable long id) {
		Charity foundCharity = charityRepo.findById(id)
				.orElseThrow(() -> new Exceptions("Charity doesnt exist"));
		return ResponseEntity.ok(foundCharity);
	}

	@PutMapping("/profile/{id}")
	public ResponseEntity<Charity> updateCharity(@PathVariable Long id, @Valid @RequestBody Charity charity) {
		// Saving to DB using an instance of the repo interface.
		Charity charityUser = charityRepo.findById(id)
				.orElseThrow(() -> new Exceptions("Charity doesnt exit"));

			charityUser.setId(charityUser.getId());
			charityUser.setUsername(charityUser.getUsername());
			charityUser.setPassword(charityUser.getPassword());
			charityUser.setCharityCat(charityUser.getCharityCat());
			charityUser.setCharityName(charityUser.getCharityName());
			charityUser.setCharityAddress(charityUser.getCharityAddress());
			charityUser.setCharityPhone(charityUser.convertPhone(charityUser.getCharityPhone()));
			mySQLUserDetailsService.Save(charityUser);
		return ResponseEntity.ok(charityUser);
	}

    @DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
		Charity charity = charityRepo.findById(id)
				.orElseThrow(() -> new Exceptions("Charity doesnt exist"));
			charityRepo.delete(charity);
			Map<String, Boolean> response = new HashMap<>();
			response.put("delete", Boolean.TRUE);
			mySQLUserDetailsService.Save(charity);
		return ResponseEntity.ok(response);
	}
}
