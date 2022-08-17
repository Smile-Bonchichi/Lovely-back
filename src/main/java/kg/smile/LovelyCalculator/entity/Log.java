package kg.smile.LovelyCalculator.entity;

import kg.smile.LovelyCalculator.entity.base.BaseEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    @Column(name = "method_name", nullable = false)
    String methodName;

    @Column(name = "http_response_code")
    Long httpResponseCode;

    @Column(name = "request_body", nullable = false)
    String requestBody;

    @Column(name = "response_body")
    String responseBody;
}
