package org.example.petproj.dao;

import org.example.petproj.entity.Sells;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellsDAO extends JpaRepository<Sells, Long> {
}
