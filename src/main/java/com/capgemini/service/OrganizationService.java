package com.capgemini.service;

import com.capgemini.domain.Organization;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Organization}.
 */
public interface OrganizationService {

    /**
     * Save a organization.
     *
     * @param organization the entity to save.
     * @return the persisted entity.
     */
    Organization save(Organization organization);

    /**
     * Get all the organizations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Organization> findAll(Pageable pageable);

    /**
     * Get all the organizations with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<Organization> findAllWithEagerRelationships(Pageable pageable);


    /**
     * Get the "id" organization.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Organization> findOne(Long id);

    /**
     * Delete the "id" organization.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
