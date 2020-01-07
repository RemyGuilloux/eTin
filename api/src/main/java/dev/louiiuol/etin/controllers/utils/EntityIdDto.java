package dev.louiiuol.etin.controllers.utils;

/** <p> A DTO representing the {@code id} of an entity. </p> */
public class EntityIdDto {

    /** <p> The id of the given entity. </p> */
    private Long id;

    /** <p> Default empty no-arg constructor. </p> */
    public EntityIdDto() {}

    public EntityIdDto(Long id) { this.id = id;}

    /** <p> Overriding method to return JSON naturally. </p> */
    @Override
    public String toString() { return "{id=" + id + "}"; }
    
    /** <p> Returns dto's id. </p> */
    public Long getId() { return id; }

     /** <p> Returns dto's id. </p> */
    public void setId(Long id) {  this.id = id; }
    
}