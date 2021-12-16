package com.david.pokenac.repository;

import com.david.pokenac.model.EvoChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvoChainRepository extends JpaRepository<EvoChain, Long> {
}
