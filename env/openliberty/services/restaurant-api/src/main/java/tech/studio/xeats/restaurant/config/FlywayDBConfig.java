package tech.studio.xeats.restaurant.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.BEAN)
public class FlywayDBConfig {

  @Resource(lookup = "jdbc/myDB")
  private DataSource dataSource;

  private final Logger logger = LogManager.getLogger(FlywayDBConfig.class);

  @PostConstruct
  public void initFlyway() {
    logger.info("Starting to migrate the database schema with Flyway");
    Flyway flyway = Flyway.configure()
        .dataSource(dataSource)
        .schemas("xeats")
        .locations("db/migration")

        .load();
    flyway.migrate();
    logger.info("Successfully applied latest schema changes");
  }


}
