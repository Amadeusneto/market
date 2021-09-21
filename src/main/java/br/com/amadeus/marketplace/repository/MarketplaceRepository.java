package br.com.amadeus.marketplace.repository;

import br.com.amadeus.marketplace.model.Marketplace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketplaceRepository extends JpaRepository<Marketplace, Long> {
    Page<Marketplace> findAll(Specification<Marketplace> spec, Pageable pageable);
}
