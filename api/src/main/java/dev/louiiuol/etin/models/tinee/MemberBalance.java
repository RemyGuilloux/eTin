package dev.louiiuol.etin.models.tinee;

import java.text.MessageFormat;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.louiiuol.etin.models.AbstractEntity;
import dev.louiiuol.etin.models.CustomUser;

/** <p> Describes a {@code CustomUser}'s balance in a specific {@code TInee} </p> */
@Entity
@Table(name="member_balance")
public class MemberBalance extends AbstractEntity {

    private static final long serialVersionUID = 8372854599080961056L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Tinee tinee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private CustomUser member;

    @Column(nullable = false)
    private Double balance;

    public MemberBalance() {/* Default constructor with empty args */ }
    
    public void setBalance(Double balance) { this.balance = balance;}

    public Double getBalance() { return balance; }
    
    public Tinee getTinee() { return tinee; }

    public CustomUser getMember() { return member; }

    public void setTinee(Tinee tinee) { this.tinee = tinee; }

    public void setMember(CustomUser member) { this.member = member;}

    @Override
    public int hashCode() { return Objects.hash(tinee, member, balance); }

    @Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if ( !(obj instanceof MemberBalance) )
			return false;
		return tinee.equals(( (MemberBalance) obj ).tinee) && member.equals(( (MemberBalance) obj ).member);
    }

    @Override
    public String toString() { return MessageFormat.format("[ tinee: {0}, member: {1}, balance: {3} ] ", tinee, member, balance); }

}
