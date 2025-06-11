package com.example.cashBook.Repository;

import com.example.cashBook.model.pettyCash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cashBookRepository extends JpaRepository<pettyCash, Long> {
}
