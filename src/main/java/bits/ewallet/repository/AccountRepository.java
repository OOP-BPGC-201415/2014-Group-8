/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.repository;

import bits.ewallet.entity.Account;
import bits.ewallet.entity.Client;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author amit
 */
public interface AccountRepository extends JpaRepository<Account,Long>{

/**
 *
 * @return object containing sequence value integer.
 */
	@Query(nativeQuery = true, value = "SELECT last_value FROM account_acc_seq_seq")
	public Object[] findSequenceValue();
/**
 *
 * @param accountNumber account number for the account
 * @param sort sort parameter
 * @return account from database
 */
	public Account findByAccountNumber(String accountNumber, Sort sort);
/**
 *
 * @param accountNumber accountNumber account number for the account
 * @param sort sort parameter
 * @return all accounts from database containing given string in their account numbers
 */
	public List<Account> findByAccountNumberContainingIgnoreCase(String accountNumber, Sort sort);
/**
 *
 * @param client client who owns the account
 * @param sort sort parameter
 * @return list list of all accounts owned by the client
 */
	public List<Account> findByClient(Client client, Sort sort);
}
