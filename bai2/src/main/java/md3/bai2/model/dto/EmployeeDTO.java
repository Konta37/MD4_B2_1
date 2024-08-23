package md3.bai2.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    @NotBlank(message = "full name can't blank")
    @NotNull(message = "full name can't null")
    @NotEmpty(message = "full name can't empty")
    private String fullName;
    @NotBlank(message = "phone can't blank")
    @NotNull(message = "phone can't null")
    @NotEmpty(message = "phone can't empty")
    private String phone;
    @NotNull(message = "status can't null")
    private Boolean status;


    private Integer departmentId;

}
