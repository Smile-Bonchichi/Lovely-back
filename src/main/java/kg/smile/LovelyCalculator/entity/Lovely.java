package kg.smile.LovelyCalculator.entity;

import kg.smile.LovelyCalculator.entity.base.BaseEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "lovely_dbt")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lovely extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "second_name", nullable = false)
    String secondName;

    @Column(name = "percent_lovely", nullable = false)
    BigDecimal percentLovely;
}
