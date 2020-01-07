package dev.louiiuol.etin.services.balance;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.louiiuol.etin.controllers.ControllerAdvice;
import dev.louiiuol.etin.controllers.dtos.requests.balances.MemberBalanceCreateDto;
import dev.louiiuol.etin.controllers.dtos.responses.MemberBalanceViewDto;
import dev.louiiuol.etin.controllers.dtos.responses.MemberViewDto;
import dev.louiiuol.etin.controllers.utils.EntityIdDto;
import dev.louiiuol.etin.models.CustomUser;
import dev.louiiuol.etin.models.tinee.MemberBalance;
import dev.louiiuol.etin.models.tinee.Tinee;
import dev.louiiuol.etin.repositories.MemberBalanceRepository;

@Service
public class MemberBalanceServiceImpl implements MemberBalanceService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvice.class);

    private final ModelMapper mapper;

    private final MemberBalanceRepository repo;

    protected MemberBalanceServiceImpl( ModelMapper mapper, MemberBalanceRepository repo ) {
        this.mapper = mapper;
        this.repo  = repo;
    }

    @Override
    public Set<MemberBalanceViewDto> getAllBalance() { return mapSetBalanceViewOdt( repo.findAll() ); }

    @Override
    public Set<MemberBalanceViewDto> getAllBalanceByTinee(EntityIdDto id) { return mapSetBalanceViewOdt( repo.findAllByTinee( mapTinee(id) ) ); }

    @Override
    public Set<MemberBalanceViewDto> getAllBalanceByUser(EntityIdDto id) { return mapSetBalanceViewOdt( repo.findAllByMember( mapUser(id) ) ); }

    @Override
    public MemberBalanceViewDto getBalance(EntityIdDto tinee, EntityIdDto user) { return mapBalanceViewOdt( getOne(tinee, user) ); }

    @Override
    public MemberBalanceViewDto update(EntityIdDto tinee, EntityIdDto user, Double balance) {
        MemberBalance userBalance = getOne(tinee, user);
        userBalance.setBalance(balance);
        return mapBalanceViewOdt( repo.save(userBalance) );
    }

    @Override
    public Set<MemberViewDto> getAll() { return mapSetViewOdt( repo.findAll() ); }

    @Override
    public Set<MemberViewDto> getAllByTinee(EntityIdDto id) { return mapSetViewOdt( repo.findAllByTinee(mapTinee(id)) ); }

    @Override
    public Set<MemberViewDto> getAllByUser(EntityIdDto id) {  return mapSetViewOdt( repo.findAllByMember(mapUser(id)) ); }
    
    @Override
    public MemberViewDto get(EntityIdDto tinee, EntityIdDto user) { return mapViewOdt(getOne(tinee, user)); }

    @Override
    public void create(EntityIdDto tinee, EntityIdDto user) {
        LOGGER.info("TINEE ID =====+> " + tinee.toString());
        MemberBalanceCreateDto dto = new MemberBalanceCreateDto();
        dto.setMember(user);
        dto.setTinee(tinee);
        dto.setBalance(0.0);
        MemberBalance balance = mapper.map(dto, MemberBalance.class);
        repo.save(balance);
    }

    @Override
    public void delete(EntityIdDto tinee, EntityIdDto user) { repo.delete(getOne(tinee, user)); }

    @Override
    public boolean existsByUser(EntityIdDto id) { return repo.existsByMemberId(id); }

    /** ADD GENERICITY  */
    private Tinee mapTinee(EntityIdDto id) { 
        Tinee tinee = new Tinee();
        tinee.setId(id.getId());
        return tinee;
    }

    private CustomUser mapUser(EntityIdDto id) { 
        CustomUser user = new CustomUser();
        user.setId(id.getId()); 
        return user;
    }

    private Set<MemberBalanceViewDto> mapSetBalanceViewOdt(List<MemberBalance> entity) {
        Set<MemberBalanceViewDto> odts = new HashSet<MemberBalanceViewDto>();
        entity.forEach(c -> { 
            MemberBalanceViewDto odt = mapBalanceViewOdt(c);
            odts.add(odt);
        });
        return odts;
    }

    private Set<MemberViewDto> mapSetViewOdt(List<MemberBalance> entity) {
        Set<MemberViewDto> odts = new HashSet<MemberViewDto>();
        entity.forEach(c -> { 
            MemberViewDto odt = mapViewOdt(c);
            odts.add(odt); 
        });
        return odts;
    }

    private MemberBalanceViewDto mapBalanceViewOdt(MemberBalance entity) { return mapper.map(entity, MemberBalanceViewDto.class); }

    private MemberViewDto mapViewOdt(MemberBalance entity) { 
        MemberViewDto odt = new MemberViewDto();
        odt.setTinee(mapIdDto(entity.getTinee().getId()));
        odt.setMember(mapIdDto(entity.getMember().getId()));
        return odt;
    }

    private MemberBalance getOne(EntityIdDto tinee, EntityIdDto userId) {
        CustomUser user = mapUser(userId);
        List<MemberBalance>  tineeBalances = repo.findAllByTinee(mapTinee(tinee));
        MemberBalance balance = new MemberBalance();
        for( MemberBalance c : tineeBalances)
            if(c.getMember().getId().equals(user.getId())) { 
                balance.setMember(c.getMember()); 
                balance.setTinee(c.getTinee());
                balance.setBalance(c.getBalance());
                balance.setId(c.getId());
            }
        return balance;
    }

    private EntityIdDto mapIdDto(Long id) { return new EntityIdDto(id); }

}