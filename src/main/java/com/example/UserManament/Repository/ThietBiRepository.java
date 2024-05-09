package com.example.UserManament.Repository;

import com.example.UserManament.Entity.Thietbi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThietBiRepository extends JpaRepository<Thietbi, Integer> {

}
