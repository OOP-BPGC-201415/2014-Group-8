/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.entity;

import bits.ewallet.enums.ClientType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author amit
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "unique_pin")
	private String uniquePin;

	@Column(name = "change_date")
	private Date changeDate;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private ClientType type;

	@JsonIgnore
	@OneToMany( mappedBy = "client", orphanRemoval = true)
	private List<Account> accounts;
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
 * @return username of the client
 */
	public String getUsername() {
		return username;
	}
/**
 *
 * @param username set username for client
 */
	public void setUsername(String username) {
		this.username = username;
	}
/**
 *
 * @return password of the client
 */
	public String getPassword() {
		return password;
	}
/**
 *
 * @param password set password for the client
 */
	public void setPassword(String password) {
		this.password = password;
	}
/**
 *
 * @return identification key similar to password
 */
	public String getUniquePin() {
		return uniquePin;
	}
/**
 *
 * @param uniquePin set identification key
 */
	public void setUniquePin(String uniquePin) {
		this.uniquePin = uniquePin;
	}
/**
 *
 * @return get last change date for password
 */
	public Date getChangeDate() {
		return changeDate;
	}
/**
 *
 * @param changeDate set change date of password
 */
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
/**
 *
 * @return client type enum
 */
	public ClientType getType() {
		return type;
	}
/**
 *
 * @param type set client type
 */
	public void setType(ClientType type) {
		this.type = type;
	}
/**
 *
 * @return all accounts that belong to client
 */
	public List<Account> getAccounts() {
		return accounts;
	}
/**
 *
 * @param accounts set accounts that belong to client
 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
/**
 *
 * @param account add account to existing account list
 */
	public void addAccount(Account account){
		this.accounts.add(account);
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
		if (!(object instanceof Client)) {
			return false;
		}
		Client other = (Client) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "bits.ewallet.entity.User[ id=" + id + " ]";
	}

}
