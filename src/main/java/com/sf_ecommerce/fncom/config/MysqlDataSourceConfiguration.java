package com.sf_ecommerce.fncom.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.sf_ecommerce.fncom.repository",
        entityManagerFactoryRef = "mysql-em",
        transactionManagerRef = "mysql-tm"
)
@EnableTransactionManagement
public class MysqlDataSourceConfiguration {

    @Value("${datasource.mysql.user}")
    private String datasourceUser;
    @Value("${datasource.mysql.password}")
    private String datasourcePassword;
    @Value("${datasource.mysql.host}")
    private String datasourceHost;
    @Value("${datasource.mysql.driver}")
    private String datasourceDriver;
    @Value("${datasource.mysql.jpa.hibernate.dialect}")
    private String hibernateDialect;

    @Bean(name = "dataSource")
    public DataSource mysqlDS() {
        return DataSourceBuilder.create()
                .username(datasourceUser)
                .password(datasourcePassword)
                .url(datasourceHost)
                .driverClassName(datasourceDriver)
                .build();
    }

//    @Bean
//    public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) {
//        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//        resourceDatabasePopulator.addScript(new ClassPathResource("/data-mysql.sql"));
//        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
//        dataSourceInitializer.setDataSource(dataSource);
//        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
//        return dataSourceInitializer;
//    }

    @Bean(name = "mysql-em")
    public LocalContainerEntityManagerFactoryBean entityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mysqlDS());
        em.setPackagesToScan(new String[]{"com.sf_ecommerce.fncom.entities"});
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        em.setJpaPropertyMap(new HashMap<String, Object>() {
            private static final long serialVersionUID = -5265602696536450190L;
            {
                put("hibernate.enable_lazy_load_no_trans", true);
                put("hibernate.dialect",hibernateDialect);
                put("show-sql", true);
                put("generate-ddl", true);
                put("hibernate.hbm2ddl.auto", "create");
            }
        });
        return em;
    }

    @Bean(name = "mysql-tm")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }
}
