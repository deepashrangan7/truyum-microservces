package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.modal.MenuItem;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem, Long> {

}
