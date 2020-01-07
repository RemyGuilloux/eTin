package dev.louiiuol.etin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.louiiuol.etin.controllers.utils.EntityIdDto;
import dev.louiiuol.etin.models.CustomUser;
import dev.louiiuol.etin.models.tinee.MemberBalance;
import dev.louiiuol.etin.models.tinee.Tinee;


/** <p> {@code JpaRepository} to handle {@code MemberBalance} persistence. </p> */
public interface MemberBalanceRepository extends JpaRepository<MemberBalance, Long> {

	/** <p> Find {@code MemberBalance} entity by their tinee's id. </p>
     * @param
     * @return List<MemberBalance> if the id matches. */
	List<MemberBalance> findAllByTinee(Tinee tineeId);

	/** <p> Find {@code MemberBalance} entity by their user's id. </p>
     * @param
     * @return List<MemberBalance> if the id matches. */
	List<MemberBalance> findAllByMember(CustomUser memberId);

	/** Return either the {@code id} exists or not. 
     * @param
     * @return {@code true} if {@code id} exists; {@code false} otherwise */
	boolean existsByMemberId(EntityIdDto memberId);

}
