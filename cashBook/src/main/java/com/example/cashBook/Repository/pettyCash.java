package com.example.cashBook.Repository;

import com.example.cashBook.model.mobilePettyCash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pettyCash extends JpaRepository<mobilePettyCash, Long> {
}
