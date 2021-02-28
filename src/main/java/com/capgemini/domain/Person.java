package com.capgemini.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.capgemini.domain.enumeration.Color;

/**
 * A Person.
 */
@Entity
@Table(name = "person")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "size")
    private Double size;

    @Column(name = "date_of_birth")
    private Instant dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "hair_color")
    private Color hairColor;

    @Column(name = "shoe_size")
    private Integer shoeSize;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "photo_content_type")
    private String photoContentType;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "person_belongs_to",
               joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "belongs_to_id", referencedColumnName = "id"))
    private Set<Organization> belongsTos = new HashSet<>();

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

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public Person nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getSize() {
        return size;
    }

    public Person size(Double size) {
        this.size = size;
        return this;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public Person dateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Person hairColor(Color hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Integer getShoeSize() {
        return shoeSize;
    }

    public Person shoeSize(Integer shoeSize) {
        this.shoeSize = shoeSize;
        return this;
    }

    public void setShoeSize(Integer shoeSize) {
        this.shoeSize = shoeSize;
    }

    public String getDescription() {
        return description;
    }

    public Person description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public Person photo(byte[] photo) {
        this.photo = photo;
        return this;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public Person photoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
        return this;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public Set<Organization> getBelongsTos() {
        return belongsTos;
    }

    public Person belongsTos(Set<Organization> organizations) {
        this.belongsTos = organizations;
        return this;
    }

    public Person addBelongsTo(Organization organization) {
        this.belongsTos.add(organization);
        organization.getPeople().add(this);
        return this;
    }

    public Person removeBelongsTo(Organization organization) {
        this.belongsTos.remove(organization);
        organization.getPeople().remove(this);
        return this;
    }

    public void setBelongsTos(Set<Organization> organizations) {
        this.belongsTos = organizations;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        return id != null && id.equals(((Person) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Person{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", nickname='" + getNickname() + "'" +
            ", size=" + getSize() +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", hairColor='" + getHairColor() + "'" +
            ", shoeSize=" + getShoeSize() +
            ", description='" + getDescription() + "'" +
            ", photo='" + getPhoto() + "'" +
            ", photoContentType='" + getPhotoContentType() + "'" +
            "}";
    }
}
