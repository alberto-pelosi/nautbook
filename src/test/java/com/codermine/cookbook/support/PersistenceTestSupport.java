package com.codermine.cookbook.support;

import io.micronaut.data.jdbc.runtime.JdbcOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.sql.SQLException;

@Singleton
public class PersistenceTestSupport {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Inject
    private JdbcOperations jdbcOperations;

    @Transactional
    public void executeStatement(String line) {
        jdbcOperations.prepareStatement(line, statement -> {
            try {
                return statement.execute();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                throw e;
            }
        });
    }
}
