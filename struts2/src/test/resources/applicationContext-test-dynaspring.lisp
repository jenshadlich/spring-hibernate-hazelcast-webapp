(in-package :spring)

(defbean "dataSource" "org.springframework.jdbc.datasource.SimpleDriverDataSource"
	:properties ("driverClass" "org.h2.Driver" "url" "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"))

(defbean "entityManagerFactory" "org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"
	:properties ("dataSource" (ref "dataSource") "persistenceXmlLocation" "META-INF/persistence.xml"))

(defbean "transactionManager" "org.springframework.orm.jpa.JpaTransactionManager"
	:properties ("entityManagerFactory" (ref "entityManagerFactory")))
