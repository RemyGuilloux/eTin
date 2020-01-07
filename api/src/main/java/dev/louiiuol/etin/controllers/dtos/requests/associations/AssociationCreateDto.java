package dev.louiiuol.etin.controllers.dtos.requests.associations;

import javax.validation.constraints.Size;

import dev.louiiuol.etin.controllers.utils.validators.name.UniqueName;

public class AssociationCreateDto {

    @UniqueName
    @Size(min = 6, max = 20)
    private String name; 

    @Size(max = 255)
    private String description;

    private String avatar;
    
    protected AssociationCreateDto() {}

    public String getName() { return name; }

    public String getDescription() { return description; }

    public String getAvatar() { return avatar; }

}