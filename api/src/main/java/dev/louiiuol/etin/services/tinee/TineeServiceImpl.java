package dev.louiiuol.etin.services.tinee;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import dev.louiiuol.etin.controllers.dtos.requests.tinees.SwearCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.tinees.TineeCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.tinees.TineeUpdateDto;
import dev.louiiuol.etin.controllers.dtos.requests.tinees.rules.TineeRuleCreateDto;
import dev.louiiuol.etin.controllers.dtos.responses.MemberViewDto;
import dev.louiiuol.etin.controllers.dtos.responses.SwearViewDto;
import dev.louiiuol.etin.controllers.dtos.responses.TineeViewDto;
import dev.louiiuol.etin.controllers.utils.EntityIdDto;
import dev.louiiuol.etin.models.CustomUser;
import dev.louiiuol.etin.models.tinee.Rule;
import dev.louiiuol.etin.models.tinee.Swear;
import dev.louiiuol.etin.models.tinee.Tinee;
import dev.louiiuol.etin.repositories.TineeRepository;
import dev.louiiuol.etin.services.balance.MemberBalanceService;
import dev.louiiuol.etin.services.swear.SwearService;

/**
 * <p>
 * Concrete implementation of {@code TineeService}.
 * </p>
 */
@Service
public class TineeServiceImpl implements TineeService {

    private final ModelMapper mapper;

    private final TineeRepository repo;

    private final MemberBalanceService balanceService;

    private final SwearService swearService;

    protected TineeServiceImpl(ModelMapper mapper, TineeRepository repo, MemberBalanceService balanceService, SwearService swearService) {
        this.mapper = mapper;
        this.repo = repo;
        this.balanceService = balanceService;
        this.swearService = swearService;
    }

    @Override
    public Set<TineeViewDto> getAll() {
        return mapSetViewDto(repo.findAll());
    }

    public TineeViewDto get(Long id) {
        return mapViewDto(repo.findById(id).get());
    }

    @Override
    public TineeViewDto create(TineeCreateDto dto) {
        Tinee tinee = mapper.map(dto, Tinee.class);
        tinee.setActive(false);
        Set<Rule> rules = createRules(dto.getRules());
        tinee.setRules(rules);
        Tinee created = repo.save(tinee);
        EntityIdDto tineeId = new EntityIdDto(created.getId());
        balanceService.create(tineeId, dto.getAuthor());
        return mapViewDto(created);
    }

    @Override
    public TineeViewDto update(Long id, TineeUpdateDto dto) {
        Tinee entity = repo.findById(id).get();
        mapper.map(dto, entity);
        return mapViewDto(repo.save(entity));
    }

    @Override
    public Set<MemberViewDto> getMembers(EntityIdDto tinee) {
        return balanceService.getAllByTinee(tinee);
    }

    @Override
    public MemberViewDto addMember(EntityIdDto tinee, EntityIdDto user) {
        balanceService.create(tinee, user);
        return balanceService.get(tinee, user);
    }

    @Override
    public void removeMember(EntityIdDto tinee, EntityIdDto user) {
        balanceService.delete(tinee, user);
    }

    @Override
    public boolean isAuthor(EntityIdDto id) {
        CustomUser author = new CustomUser();
        author.setId(id.getId());
        Tinee tinee = repo.findByAuthor(author).get();
        return null != tinee;
    }

    private Set<Rule> createRules(Set<TineeRuleCreateDto> dtos) {
        Set<Rule> rules = new HashSet<>();
        dtos.forEach(c -> {
            Rule rule = mapper.map(c, Rule.class);
            rules.add(rule);
        });
        return rules;
    }

    private TineeViewDto mapViewDto(Tinee entity) {
        return mapper.map(entity, TineeViewDto.class);
    }

    private Set<TineeViewDto> mapSetViewDto(List<Tinee> entity) {
        Set<TineeViewDto> odts = new HashSet<TineeViewDto>();
        entity.forEach(c -> {
            odts.add(mapViewDto(c));
        });
        return odts;
    }

    @Override
    public SwearViewDto addSwear(EntityIdDto tineeId, SwearCreateDto dto) {
        swearService.createSwear(dto);
        Swear entity = mapper.map(dto, Swear.class);
        balanceService.update(tineeId, dto.getAuthor(), dto.getAmount());
        Tinee tinee = repo.findById(tineeId.getId()).get();
        //swearService.get();
        return null;
    }
    
}