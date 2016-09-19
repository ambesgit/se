
package business.customersubsystem;

import java.sql.ResultSet;
import java.sql.SQLException;

import business.externalinterfaces.ICustomerProfile;
import middleware.DatabaseException;
import middleware.DbConfigProperties;
import middleware.externalinterfaces.DbConfigKey;
import middleware.externalinterfaces.IDbClass;

class DbClassCreditCard implements IDbClass {
	private final String READ = "Read";
	private ICustomerProfile custProfile;
	String query;
	private String queryType;

	public void buildQuery() {
		if (queryType.equals(READ)) {
			buildReadQuery();
		}
	}

	void buildReadQuery() {
		// IMPLEMENT
		query = "SELECT * FROM creditcard cc inner join customer c ON cc.customerId = c.customerId WHERE c.customerId = '"
				+ custProfile.getCustId()+"'";
	}

	public void populateEntity(ResultSet resultSet) throws DatabaseException {
		// IMPLEMENT
		try {
			while (resultSet.next()) {
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getDbUrl() {
		DbConfigProperties props = new DbConfigProperties();
		return props.getProperty(DbConfigKey.ACCOUNT_DB_URL.getVal());

	}

	public String getQuery() {
		return query;

	}

}
