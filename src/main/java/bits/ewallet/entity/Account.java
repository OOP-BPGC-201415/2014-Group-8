/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.entity;

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

	@OneToMany( mappedBy = "toAccount", orphanRemoval = true)
	private List<TransactionRecord> toTransactions;

	@OneToMany( mappedBy = "fromAccount", orphanRemoval = true)
	private List<TransactionRecord> fromTransactions;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Long getAccSeq() {
		return accSeq;
	}

	public void setAccSeq(Long accSeq) {
		this.accSeq = accSeq;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<TransactionRecord> getToTransactions() {
		return toTransactions;
	}

	public void setToTransactions(List<TransactionRecord> toTransactions) {
		this.toTransactions = toTransactions;
	}

	public void addToTransaction(TransactionRecord tr){
		this.toTransactions.add(tr);
	}

	public List<TransactionRecord> getFromTransactions() {
		return fromTransactions;
	}

	public void setFromTransactions(List<TransactionRecord> fromTransactions) {
		this.fromTransactions = fromTransactions;
	}

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
