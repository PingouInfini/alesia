package com.capgemini.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Organization.
 */
@Entity
@Table(name = "organization")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Lob
    @Column(name = "piece_jointe")
    private byte[] pieceJointe;

    @Column(name = "piece_jointe_content_type")
    private String pieceJointeContentType;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "organization_is_located_on",
               joinColumns = @JoinColumn(name = "organization_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "is_located_on_id", referencedColumnName = "id"))
    private Set<Location> isLocatedOns = new HashSet<>();

    @ManyToMany(mappedBy = "belongsTos")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<Person> people = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Organization name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Organization description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public Organization address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPieceJointe() {
        return pieceJointe;
    }

    public Organization pieceJointe(byte[] pieceJointe) {
        this.pieceJointe = pieceJointe;
        return this;
    }

    public void setPieceJointe(byte[] pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public String getPieceJointeContentType() {
        return pieceJointeContentType;
    }

    public Organization pieceJointeContentType(String pieceJointeContentType) {
        this.pieceJointeContentType = pieceJointeContentType;
        return this;
    }

    public void setPieceJointeContentType(String pieceJointeContentType) {
        this.pieceJointeContentType = pieceJointeContentType;
    }

    public Set<Location> getIsLocatedOns() {
        return isLocatedOns;
    }

    public Organization isLocatedOns(Set<Location> locations) {
        this.isLocatedOns = locations;
        return this;
    }

    public Organization addIsLocatedOn(Location location) {
        this.isLocatedOns.add(location);
        location.getOrganizations().add(this);
        return this;
    }

    public Organization removeIsLocatedOn(Location location) {
        this.isLocatedOns.remove(location);
        location.getOrganizations().remove(this);
        return this;
    }

    public void setIsLocatedOns(Set<Location> locations) {
        this.isLocatedOns = locations;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public Organization people(Set<Person> people) {
        this.people = people;
        return this;
    }

    public Organization addPerson(Person person) {
        this.people.add(person);
        person.getBelongsTos().add(this);
        return this;
    }

    public Organization removePerson(Person person) {
        this.people.remove(person);
        person.getBelongsTos().remove(this);
        return this;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Organization)) {
            return false;
        }
        return id != null && id.equals(((Organization) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Organization{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", address='" + getAddress() + "'" +
            ", pieceJointe='" + getPieceJointe() + "'" +
            ", pieceJointeContentType='" + getPieceJointeContentType() + "'" +
            "}";
    }
}
