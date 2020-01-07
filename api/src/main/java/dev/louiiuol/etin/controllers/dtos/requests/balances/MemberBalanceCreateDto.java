package dev.louiiuol.etin.controllers.dtos.requests.balances;

import javax.validation.constraints.NotNull;

import dev.louiiuol.etin.controllers.utils.EntityIdDto;

public class MemberBalanceCreateDto {

    @NotNull
    EntityIdDto member;

    @NotNull
    EntityIdDto tinee;

    Double balance;

    public MemberBalanceCreateDto() {
    }

    public Double getBalance() { return balance; }
    
    public void setBalance(double balance) { this.balance = balance; }

    public EntityIdDto getMember() { return member; }

    public void setMember(EntityIdDto member) { this.member = member;  }

    public EntityIdDto getTinee() { return tinee; }

    public void setTinee(EntityIdDto tinee) { this.tinee = tinee;  }

}