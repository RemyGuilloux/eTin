package dev.louiiuol.etin.controllers.dtos.responses;


import dev.louiiuol.etin.controllers.utils.EntityIdDto;

public class MemberViewDto {

    EntityIdDto member;

    EntityIdDto tinee;

    public MemberViewDto() {  }

    public EntityIdDto getMember() { return member; }

    public void setMember(EntityIdDto member) { this.member = member; }

    public EntityIdDto getTinee() { return tinee; }
    
    public void setTinee(EntityIdDto tinee) { this.tinee = tinee; }

}