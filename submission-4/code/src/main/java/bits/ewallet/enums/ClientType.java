/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bits.ewallet.enums;

/**
 *
 * @author amit
 */
public enum ClientType {

	EMPLOYEE("employee"),
	MERCHANT("merchant"),
	ADMIN("admin");
	;

		private final String userFriendlyName;

	private ClientType() {
		this.userFriendlyName = null;
	}

	private ClientType(String userFriendlyName) {
		this.userFriendlyName = userFriendlyName;
	}

	@Override
	public String toString() {
		return this.userFriendlyName;
	}

}
