package com.teomaik.demospring.themes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeServices {

	@Autowired ThemeRepository repository;

	// TODO add method getWithID

	public List<Theme> getAllThemes() {
		return repository.findAll();
	}

	public List<Theme> addTheme(Theme theme) {
		repository.save(theme);
		return repository.findAll();
	}

	public List<Theme> removeTheme(Integer id) {
		repository.deleteById(id);
		return repository.findAll();
	}

	public Theme getThemeByName(String name) {
		return repository.findByName(name);

	}
	
	public Theme updateTheme(int id, String name, String description) {
		Optional<Theme> optionalTheme = repository.findById(id);

		if (optionalTheme.isPresent()) {
			Theme existingTheme = optionalTheme.get();

			// Update fields if new values are provided
			if (name != null && !name.isEmpty()) {
				existingTheme.setName(name);
			}
			if (description != null && !description.isEmpty()) {
				existingTheme.setDescription(description);
			}

			// Save and return the updated author
			return repository.save(existingTheme);
		} else {
			throw new RuntimeException("Theme with ID " + id + " not found");
		}
	}
}
