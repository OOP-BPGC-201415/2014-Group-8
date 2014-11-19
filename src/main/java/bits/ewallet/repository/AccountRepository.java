/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.repository;

import bits.ewallet.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author amit
 */
public interface AccountRepository extends JpaRepository<Account,Long>{

	@Query(nativeQuery = true, value = "SELECT last_value FROM account_acc_seq_seq")
	public Object[] findSequenceValue();
}
