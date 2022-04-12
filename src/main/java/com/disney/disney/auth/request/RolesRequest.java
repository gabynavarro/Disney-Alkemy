
package com.disney.disney.auth.request;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolesRequest {
    @NotNull
    private long id;
    @NotNull
    private String name;
    private String description;   
}
