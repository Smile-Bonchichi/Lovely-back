package kg.smile.LovelyCalculator.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LovelyRequestDto {
    @NotNull
    @NotEmpty
    @Size(min = 2)
    String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 2)
    String secondName;
}
