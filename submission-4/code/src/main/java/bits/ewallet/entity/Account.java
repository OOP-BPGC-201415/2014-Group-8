/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.ReturnInsert;

/**
 *
 * @author amit
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String prefix = "ACC";

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "acc_seq",columnDefinition="serial")
	@Basic
	@ReturnInsert(returnOnly = true)
	private Long accSeq;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "unique_id")
	private String uniqueId;

	@Column(name = "balance")
	private Double balance;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", insertable = true, updatable = true)
	private Client client;

	@JsonIgnore
	@OneToMany( mappedBy = "toAccount", orphanRemoval = true)
	private List<TransactionRecord> toTransactions;

	@JsonIgnore
	@OneToMany( mappedBy = "fromAccount", orphanRemoval = true)
	private List<TransactionRecord> fromTransactions;

/**
 *
 * @return database generated id (primary key)
 */
	public Long getId() {
		return id;
	}
/**
 *
 * @param id primary key for record in database. Don't use if using ORM
 */
	public void setId(Long id) {
		this.id = id;
	}
/**
 *
 * @return account number of entity
 */
	public String getAccountNumber() {
		return accountNumber;
	}
/**
 *
 * @return database generated sequence value assigned to the record
 */
	public Long getAccSeq() {
		return accSeq;
	}
/**
 *
 * @param accSeq to set the sequence value. Do not use explicitly with ORM
 */
	public void setAccSeq(Long accSeq) {
		this.accSeq = accSeq;
	}
/**
 *
 * @param accountNumber account number of the entity
 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
/**
 *
 * @return identification key similar to password for the entity
 */
	public String getUniqueId() {
		return uniqueId;
	}
/**
 *
 * @param uniqueId set identification key like password
 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
/**
 *
 * @return current balance in the account
 */
	public Double getBalance() {
		return balance;
	}
/**
 *
 * @param balance set balance for the entity
 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}
/**
 *
 * @return id of client this entity is assigned to
 */
	public Client getClient() {
		return client;
	}
/**
 *
 * @param client assign client for this entity
 */
	public void setClient(Client client) {
		this.client = client;
	}
/**
 *
 * @return get all debit transactions for this account
 */
	public List<TransactionRecord> getToTransactions() {
		return toTransactions;
	}
/**
 *
 * @param toTransactions set debit transactions for the account
 */
	public void setToTransactions(List<TransactionRecord> toTransactions) {
		this.toTransactions = toTransactions;
	}
/**
 *
 * @param tr add transaction to debit transactions
 */
	public void addToTransaction(TransactionRecord tr){
		this.toTransactions.add(tr);
	}
/**
 *
 * @return get all credit transactions for this account
 */
	public List<TransactionRecord> getFromTransactions() {
		return fromTransactions;
	}
/**
 *
 * @param fromTransactions set credit transactions for the account
 */
	public void setFromTransactions(List<TransactionRecord> fromTransactions) {
		this.fromTransactions = fromTransactions;
	}
/**
 *
 * @param tr add transaction to credit transactions
 */
	public void addFromTransaction(TransactionRecord tr){
		this.fromTransactions.add(tr);
	}





	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Account)) {
			return false;
		}
		Account other = (Account) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "bits.ewallet.entity.Account[ id=" + id + " ]";
	}

}
