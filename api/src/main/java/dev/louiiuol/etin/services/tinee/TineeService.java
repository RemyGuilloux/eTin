package dev.louiiuol.etin.services.tinee;

import java.util.Set;

import dev.louiiuol.etin.controllers.dtos.requests.tinees.SwearCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.tinees.TineeCreateDto;
import dev.louiiuol.etin.controllers.dtos.requests.tinees.TineeUpdateDto;
import dev.louiiuol.etin.controllers.dtos.responses.MemberViewDto;
import dev.louiiuol.etin.controllers.dtos.responses.SwearViewDto;
import dev.louiiuol.etin.controllers.dtos.responses.TineeViewDto;
import dev.louiiuol.etin.controllers.utils.EntityIdDto;

/**  <p> Service to handle {@code Tinee} persistence.  </p> */
public interface TineeService {

  /**  <p> Returns all tinees in database </p> 
   * @param
    *  @return {@code Set<TineeViewDto>} */
  public Set<TineeViewDto> getAll();

  /**  <p> Returns tinee matching the given id </p> 
   * @param
   *  @return {@code TineeViewDto} */
  public TineeViewDto get(Long tineeId);

  /**  <p> Create a new Tinee based on {@code TineeCreateDto}. </p>
   * @param
   * @return a TineeViewDto */
  public TineeViewDto create(TineeCreateDto TineeCreateDto);

  /**  <p> Update  a new Tinee based on {@code TineeUpdtaeDto}. </p>
   * @param
   * @return a TineeViewDto */
  public TineeViewDto update(Long id, TineeUpdateDto TineeUpdateDto);

  /**  <p> Returns all Tinee's members from it's id </p>
   * @param
   * @return {@code Set<MemberViewDto>} */
  public Set<MemberViewDto> getMembers(EntityIdDto tineeId); 

  /**  <p>Adds user to specific Tinee </p>
   * @param
   * @return {@code MemberViewDto} */
  public MemberViewDto addMember(EntityIdDto tineeId, EntityIdDto userId);

  /**  <p>Removes user to specific Tinee </p>
   * @param*/
  public void removeMember(EntityIdDto tineeId, EntityIdDto userId);
  
    /**  <p> Test if the given user id matches the author </p> 
   * @param
   *  @return {@code true} if the author id matches. */
  public boolean isAuthor(EntityIdDto authorId);

	public SwearViewDto addSwear(EntityIdDto tineeId, SwearCreateDto input );

}
