/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author amit
 */
@Entity
@Table(name = "transaction_record")
public class TransactionRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_account_id", insertable = true, updatable = true)
	private Account toAccount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_account_id", insertable = true, updatable = true)
	private Account fromAccount;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "transaction_date")
	private Date transactionDate;
/**
 *
 * @return database generated id (primary key)
 */
	public Long getId() {
		return id;
	}
/**
 *
 * @param id primary key for record in database. Don't use with ORM
 */
	public void setId(Long id) {
		this.id = id;
	}
/**
 *
 * @return get debit account for this transaction
 */
	public Account getToAccount() {
		return toAccount;
	}
/**
 *
 * @param toAccount set debit transaction for this account
 */
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
/**
 *
 * @return get credit account for this transaction
 */
	public Account getFromAccount() {
		return fromAccount;
	}
/**
 *
 * @param fromAccount set credit transaction for this account
 */
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
/**
 *
 * @return transaction amount
 */
	public Double getAmount() {
		return amount;
	}
/**
 *
 * @param amount set amount to be transferred
 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
/**
 *
 * @return transaction date
 */
	public Date getTransactionDate() {
		return transactionDate;
	}
/**
 *
 * @param transactionDate set date for the transaction
 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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
		if (!(object instanceof TransactionRecord)) {
			return false;
		}
		TransactionRecord other = (TransactionRecord) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "bits.ewallet.entity.Transaction[ id=" + id + " ]";
	}

}
