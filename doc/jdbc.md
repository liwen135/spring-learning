##关键类
###newArgTypePreparedStatementSetter
org.springframework.jdbc.core.JdbcTemplate.newArgTypePreparedStatementSetter
###SimplePreparedStatementCreator
org.springframework.jdbc.core.JdbcTemplate.SimplePreparedStatementCreator

    private static class SimplePreparedStatementCreator implements PreparedStatementCreator, SqlProvider {
    		private final String sql;
    		public SimplePreparedStatementCreator(String sql) {
    			Assert.notNull(sql, "SQL must not be null");
    			this.sql = sql;
    		}
    
    		@Override
    		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
    			return con.prepareStatement(this.sql);
    		}
    
    		@Override
    		public String getSql() {
    			return this.sql;
    		}
    	}
org.springframework.jdbc.core.JdbcTemplate.execute(org.springframework.jdbc.core.PreparedStatementCreator, org.springframework.jdbc.core.PreparedStatementCallback<T>)
        //获取数据库连接
        Connection con = DataSourceUtils.getConnection(obtainDataSource());
		PreparedStatement ps = null;
		try {
		//
			ps = psc.createPreparedStatement(con);
			//应用用户设定的输入参数
			applyStatementSettings(ps);
			//回调函数
			T result = action.doInPreparedStatement(ps);
			//处理告警
			handleWarnings(ps);
			return result;
		}