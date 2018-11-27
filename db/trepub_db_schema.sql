-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema trepub
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema trepub
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trepub` DEFAULT CHARACTER SET utf8 ;
USE `trepub` ;

-- -----------------------------------------------------
-- Table `trepub`.`oauth_client_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trepub`.`oauth_client_details` (
  `client_id` VARCHAR(255) NOT NULL,
  `resource_ids` VARCHAR(255) NULL DEFAULT NULL,
  `client_secret` VARCHAR(255) NULL DEFAULT NULL,
  `scope` VARCHAR(255) NULL DEFAULT NULL,
  `authorized_grant_types` VARCHAR(255) NULL DEFAULT NULL,
  `web_server_redirect_uri` VARCHAR(255) NULL DEFAULT NULL,
  `authorities` VARCHAR(255) NULL DEFAULT NULL,
  `access_token_validity` INT(11) NULL DEFAULT NULL,
  `refresh_token_validity` INT(11) NULL DEFAULT NULL,
  `additional_information` VARCHAR(4096) NULL DEFAULT NULL,
  `autoapprove` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trepub`.`permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trepub`.`permission` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` BIGINT(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trepub`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trepub`.`role` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` BIGINT(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trepub`.`permission_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trepub`.`permission_role` (
  `permission_id` BIGINT(20) UNSIGNED NOT NULL,
  `role_id` BIGINT(20) UNSIGNED NOT NULL,
  `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` BIGINT(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY (`permission_id`, `role_id`),
  INDEX `permission_role_fk2` (`role_id` ASC),
  CONSTRAINT `permission_role_fk1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `trepub`.`permission` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `permission_role_fk2`
    FOREIGN KEY (`role_id`)
    REFERENCES `trepub`.`role` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trepub`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trepub`.`user` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(24) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `enabled` BIT(1) NOT NULL,
  `account_expired` BIT(1) NOT NULL,
  `credentials_expired` BIT(1) NOT NULL,
  `account_locked` BIT(1) NOT NULL,
  `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` BIGINT(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_ix1` (`username` ASC),
  UNIQUE INDEX `user_ix2` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trepub`.`role_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trepub`.`role_user` (
  `role_id` BIGINT(20) UNSIGNED NOT NULL,
  `user_id` BIGINT(20) UNSIGNED NOT NULL,
  `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` BIGINT(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY (`role_id`, `user_id`),
  INDEX `role_user_fk2` (`user_id` ASC),
  CONSTRAINT `role_user_fk1`
    FOREIGN KEY (`role_id`)
    REFERENCES `trepub`.`role` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `role_user_fk2`
    FOREIGN KEY (`user_id`)
    REFERENCES `trepub`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
