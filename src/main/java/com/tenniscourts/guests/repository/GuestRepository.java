package com.tenniscourts.guests.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenniscourts.guests.Guest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

	Guest findByName(String name);

	Guest findByGuestid(Long id);

}

