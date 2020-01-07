package dev.louiiuol.etin.services.balance;

import java.util.Set;

import org.springframework.stereotype.Service;

import dev.louiiuol.etin.controllers.dtos.responses.MemberBalanceViewDto;
import dev.louiiuol.etin.controllers.dtos.responses.MemberViewDto;
import dev.louiiuol.etin.controllers.utils.EntityIdDto;

@Service
public interface MemberBalanceService {

    public Set<MemberBalanceViewDto> getAllBalance();

    public Set<MemberBalanceViewDto> getAllBalanceByTinee(EntityIdDto id);

    public Set<MemberBalanceViewDto> getAllBalanceByUser(EntityIdDto id);

    public MemberBalanceViewDto getBalance(EntityIdDto tinee, EntityIdDto user);

    public MemberBalanceViewDto update(EntityIdDto tinee, EntityIdDto user, Double balance);

    public Set<MemberViewDto> getAll();

    public Set<MemberViewDto> getAllByTinee(EntityIdDto id);

    public Set<MemberViewDto> getAllByUser(EntityIdDto id);

    public MemberViewDto get(EntityIdDto tinee, EntityIdDto user);

    public void create(EntityIdDto tinee, EntityIdDto user);

    public void delete(EntityIdDto tinee, EntityIdDto user);

    public boolean existsByUser(EntityIdDto id);

}