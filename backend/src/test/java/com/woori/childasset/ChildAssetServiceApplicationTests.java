package com.woori.childasset;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@Tag("integration")
class ChildAssetServiceApplicationTests {

	@Autowired
	Flyway flyway;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void appliesBaselineMigrationAndValidatesHistory() {
		assertThat(flyway.info().current().getVersion().getVersion()).isEqualTo("1");
		assertThat(flyway.info().pending()).isEmpty();
		flyway.validate();
	}

	@Test
	void usesMySql84WithInnoDbAndUtf8mb4() {
		assertThat(jdbcTemplate.queryForObject("SELECT VERSION()", String.class)).startsWith("8.4.");
		assertThat(jdbcTemplate.queryForObject("SELECT @@default_storage_engine", String.class))
				.isEqualToIgnoringCase("InnoDB");
		assertThat(jdbcTemplate.queryForObject("SELECT @@character_set_database", String.class))
				.isEqualTo("utf8mb4");
	}

}
