package com.capgemini.repository;

import com.capgemini.domain.Organization;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Organization entity.
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query(value = "select distinct organization from Organization organization left join fetch organization.isLocatedOns",
        countQuery = "select count(distinct organization) from Organization organization")
    Page<Organization> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct organization from Organization organization left join fetch organization.isLocatedOns")
    List<Organization> findAllWithEagerRelationships();

    @Query("select organization from Organization organization left join fetch organization.isLocatedOns where organization.id =:id")
    Optional<Organization> findOneWithEagerRelationships(@Param("id") Long id);
}
