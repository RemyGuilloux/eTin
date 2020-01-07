package dev.louiiuol.etin.controllers.dtos.requests.balances;

import javax.validation.constraints.NotNull;

import dev.louiiuol.etin.controllers.utils.EntityIdDto;

public class MemberBalanceUpdateDto {

    @NotNull
    EntityIdDto member;

    @NotNull
    Double amount;

    @NotNull
    EntityIdDto tinee;

    public EntityIdDto getMember() { return member; }

    public Double getAmount() { return amount; }

    public void getAmount(Double amount) { this.amount = amount; }

    public EntityIdDto getTinee() { return tinee; }

    protected MemberBalanceUpdateDto() { }

    public MemberBalanceUpdateDto(Long member, Long tinee, Double balance) { }

}