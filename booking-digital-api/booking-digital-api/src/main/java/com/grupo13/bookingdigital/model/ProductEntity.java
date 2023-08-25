package com.grupo13.bookingdigital.model;

import com.grupo13.bookingdigital.auth.model.UserEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.Hibernate;
import org.hibernate.annotations.SQLDelete;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description_card", columnDefinition = "text")
  private String descriptionCard;

  @Column(name = "description_page", columnDefinition = "text")
  private String descriptionPage;

  @Column(name = "score")
  private Integer score;

  @Column(name = "price")
  private Integer price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  @Exclude
  private CategoryEntity category;

  @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
  @JoinColumn(name = "policy_id")
  @Exclude
  private PolicyEntity policy;


  @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
  @JoinColumn(name = "characteristic_id")
  @Exclude
  private CharacteristicEntity characteristic;


  @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  @JoinColumn(name = "location_id")
  private LocationEntity location;

  @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  @JoinColumn(name = "images_id")
  private ImageEntity image;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "usuario_id")
  private UserEntity user;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  private List<BookingEntity> bookings;

  @OneToMany(mappedBy = "product")
  private List<LikeEntity> likes = new ArrayList<>();

  private boolean deleted = Boolean.FALSE;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    ProductEntity entity = (ProductEntity) o;
    return id != null && Objects.equals(id, entity.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
