package org.enote.config.db;

import javax.sql.DataSource;
import java.util.Properties;

public interface DataConfig {
    DataSource dataSource();

    Properties hibernateProperties();
}
