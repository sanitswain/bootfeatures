package practice.boot.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplte;

	@Override
	public void createCustomer(Customer c) {
		String custQuery = "insert into Customer (cid, cname) values (?, ?)";
		String addrQuery = "insert into Address (custid, state, country) values (?, ?, ?)";
		jdbcTemplte.update(custQuery, new Object[] { c.getCid(), c.getCname() });
		System.out.println("Customer query executed...");
		jdbcTemplte.update(addrQuery,
				new Object[] { c.getCid(), c.getAddress().getState(), c.getAddress().getCountry() });
		System.out.println("Address query executed...");
	}

}
