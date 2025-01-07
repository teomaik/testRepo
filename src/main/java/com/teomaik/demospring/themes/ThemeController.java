package com.teomaik.demospring.themes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/themes")
public class ThemeController {

	@Autowired
	ThemeServices themeServices;

	@GetMapping("/hello")
	public String hello() {
		return "Hello from Theme controller";
	}

	@GetMapping("/all")
	public List<Theme> getAllThemes() {
		return themeServices.getAllThemes();
	}

	@PostMapping("/add")
	public List<Theme> addTheme(@RequestBody Theme theme) {
		return themeServices.addTheme(theme);
	}

	@DeleteMapping("/delete")
	public List<Theme> deleteTheme(@RequestParam Integer id) {
		return themeServices.removeTheme(id);
	}

	@GetMapping("/find")
	public Theme findThemeByName(@RequestParam String name) {
		return themeServices.getThemeByName(name);
	}
	
	@PutMapping("/update")
	public Theme updateTheme(@RequestParam Integer id, @RequestParam(required = false) String name,
			@RequestParam(required = false) String description) {
		return themeServices.updateTheme(id, name, description);
	}
}