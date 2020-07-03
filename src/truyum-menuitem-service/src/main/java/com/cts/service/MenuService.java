package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.feign.AuthenticationServiceFeign;
import com.cts.modal.MenuItem;
import com.cts.modal.Status;
import com.cts.modal.Users;
import com.cts.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private AuthenticationServiceFeign asf;

	public MenuItem addMenuItem(MenuItem menu) {
		return menuRepository.save(menu);
	}

	public List<MenuItem> getAllMenu() {
		return menuRepository.findAll();
	}

	public MenuItem editMenuItem(MenuItem menu, Long id) {
		Optional<MenuItem> optional = menuRepository.findById(id);
		if (optional.isPresent()) {
			MenuItem mi = optional.get();
			mi.setCost(menu.getCost());
			mi.setName(menu.getName());
			return menuRepository.save(mi);
		}
		return null;
	}

	public Status getToken(Users user) {
		String token = asf.getToken(user);
		Status status = new Status();
		if (token != null) {
			status.setToken(token);
			status.setValidUser(true);
		} else {
			status.setToken(null);
			status.setValidUser(false);
		
		}
		return status;
	}

}
