package com.sigabem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigabem.model.Output;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Output, Long> {

}
