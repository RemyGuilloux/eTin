package dev.louiiuol.etin.controllers.dtos.responses;

import dev.louiiuol.etin.controllers.utils.EntityIdDto;

public class MemberBalanceViewDto {

    EntityIdDto member;

    Double balance;

    EntityIdDto tinee;

    public EntityIdDto getMember() {
        return member;
    }

    public Double getBalance() {
        return balance;
    }

    public EntityIdDto getTinee() {
        return tinee;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setTinee(EntityIdDto tinee) {
        this.tinee = tinee;
    }

    public void setMember(EntityIdDto member) {
        this.member = member;
    }

    protected MemberBalanceViewDto() {
    }

}