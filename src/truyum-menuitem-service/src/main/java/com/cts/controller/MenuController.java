package com.cts.controller;

import java.util.List;
import java.util.ListResourceBundle;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.modal.MenuItem;
import com.cts.modal.Status;
import com.cts.modal.TempStore;
import com.cts.modal.Users;
import com.cts.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@PostMapping("/add")
	public MenuItem addMenu(@RequestBody MenuItem menu) {
		if (menu != null)
			return menuService.addMenuItem(menu);
		return null;
	}

	@PutMapping("/edit/{id}")
	public MenuItem editMenu(@RequestBody MenuItem menu, @PathVariable Long id) {
		if (menu != null)
			return menuService.editMenuItem(menu, id);
		return null;
	}

	@GetMapping("/all")
	public List<MenuItem> getAllMenuItems() {
		return menuService.getAllMenu();
	}

	@PostMapping("/login")
	public Status gettoken(@RequestBody Users user, HttpSession session) {
//		System.out.println("inside loginnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		TempStore.username=user.getUsername();
		
//		System.out.println(" user in controller "+TempStore.username);
		Status status = menuService.getToken(user);
//		if (status.getValidUser())
		return status;
	}
}
