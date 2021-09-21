package br.com.amadeus.marketplace.repository;

import br.com.amadeus.marketplace.dto.request.FilterMarketplaceRequest;
import br.com.amadeus.marketplace.model.Marketplace;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class MarketplaceSpecification {
    public Specification<Marketplace> getMarketplacesByFilter(FilterMarketplaceRequest request) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates = preparePredicateLike("name", request.getName(), criteriaBuilder, root, predicates);
            predicates = preparePredicateLike("region05", request.getRegion(), criteriaBuilder, root, predicates);
            predicates = preparePredicateLike("region08", request.getRegion(), criteriaBuilder, root, predicates);
            predicates = preparePredicateLike("districtName", request.getDistrict(), criteriaBuilder, root, predicates);
            predicates = preparePredicateLike("neighborhood", request.getNeighborhood(), criteriaBuilder, root, predicates);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static List<Predicate> preparePredicateLike(String fieldName, String fieldValue,
                                                       CriteriaBuilder criteriaBuilder, Root<Marketplace> root,
                                                       List<Predicate> predicates) {
        if (!Objects.isNull(fieldValue) && !fieldValue.isEmpty()) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get(fieldName)), "%" + fieldValue + "%"));
        }
        return predicates;
    }
}
