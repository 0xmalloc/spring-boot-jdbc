package boot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractJdbcDaoSupport {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

}
