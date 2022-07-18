package kg.smile.LovelyCalculator.entity;

import kg.smile.LovelyCalculator.entity.base.BaseEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "log_dbt")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Log extends BaseEntity {
    @Column(name = "controller_name", nullable = false)
    String controllerName;

    @Lob
    @Column(name = "request_body", nullable = false)
    String requestBody;

    @Lob
    @Column(name = "response_body")
    String responseBody;

    @Column(name = "http_response_code", nullable = false)
    Long httpResponseCode;
}
