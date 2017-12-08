package org.enote.config.db;

import javax.sql.DataSource;
import java.util.Properties;

public interface DBConfig {
    DataSource dataSource();
    Properties hibernateProperties();
}
