CREATE SCHEMA IF NOT EXISTS `weather` DEFAULT CHARACTER SET utf8 ;
USE `weather` ;

-- -----------------------------------------------------
-- Table `weather`.`weather_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `weather`.`weather_history` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `cod` INT(11) NOT NULL,
  `coord_lon` DOUBLE NOT NULL,
  `coord_lat` DOUBLE NOT NULL,
  `main_temp` DOUBLE NOT NULL,
  `main_pressure` INT(11) NOT NULL,
  `main_humidity` INT(11) NOT NULL,
  `main_temp_min` INT(11) NOT NULL,
  `main_temp_max` INT(11) NOT NULL,
  `wind_speed` DOUBLE NOT NULL,
  `wind_deg` INT(11) NOT NULL,
  `dt` DATETIME NOT NULL,
  `weather_main` VARCHAR(45) NOT NULL,
  `weather_description` VARCHAR(45) NOT NULL,
  `weather_icon` VARCHAR(45) NOT NULL,
  `rain1h` INT(11) NULL DEFAULT NULL,
  `rain3h` INT(11) NULL DEFAULT NULL,
  `snow1h` INT(11) NULL DEFAULT NULL,
  `snow3h` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 126
DEFAULT CHARACTER SET = utf8;