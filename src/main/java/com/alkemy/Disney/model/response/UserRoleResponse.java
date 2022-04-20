
package com.alkemy.Disney.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleResponse {
    private Long id;   
    private String firt_name;    
    private boolean modified_role=true;
}
