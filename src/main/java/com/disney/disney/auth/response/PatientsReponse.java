
package com.disney.disney.auth.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientsReponse {
    private Long id;
    private String username;  
    private String firt_name;
    private String last_name;
    private String dni;    
    private String image_url;
    
}
