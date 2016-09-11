package boot.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import boot.domain.User;

@Repository
public class UserRepository extends AbstractJdbcDaoSupport{

	private String querySql = "SELECT r.password FROM zh_user r WHERE r.username=?";

	private String insertSql = "insert into zh_user(username,password) values(?,?)";

	public String getPassword(final String username) {
		String passwd = jdbcTemplate.query(querySql, new Object[] { username }, new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					return rs.getString("password");
				}
				return null;
			}
		});
		return passwd;
	}

	public void saveUser(final User user) {

		jdbcTemplate.update(insertSql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
			}
		});
	}

}
