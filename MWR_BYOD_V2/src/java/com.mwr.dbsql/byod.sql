SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `byod` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `byod` ;

-- -----------------------------------------------------
-- Table `byod`.`blacklistedapplications`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`blacklistedapplications` (
  `AppID` INT(11) NOT NULL AUTO_INCREMENT ,
  `AppName` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `AppCategory` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  PRIMARY KEY (`AppID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `byod`.`employee`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`employee` (
  `empID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `dateRegistered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `name` VARCHAR(45) NOT NULL ,
  `surname` VARCHAR(45) NOT NULL ,
  `idnumber` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`empID`) ,
  UNIQUE INDEX `userID_UNIQUE` (`empID` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 27
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `byod`.`device`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`device` (
  `Make` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `Model` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `DateRegistered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `MACAddress` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `UID` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `SerialNumber` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `employee_empID` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`MACAddress`, `UID`, `SerialNumber`) ,
  INDEX `fk_device_employee_idx` (`employee_empID` ASC) ,
  CONSTRAINT `fk_device_employee`
    FOREIGN KEY (`employee_empID` )
    REFERENCES `byod`.`employee` (`empID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `byod`.`devicenotregistered`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`devicenotregistered` (
  `Make` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `Model` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `DateRegistered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `MACAdress` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `AndroidID` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `SerialNumber` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `token` VARCHAR(5) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `username` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `password` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `IDNumber` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `Name` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `Surname` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  PRIMARY KEY (`MACAdress`, `AndroidID`, `SerialNumber`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `byod`.`settings`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`settings` (
  `SettingID` INT(11) NOT NULL AUTO_INCREMENT ,
  `AccessScore` INT(11) NULL DEFAULT NULL ,
  `SettingDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `OSWeight` INT(11) NOT NULL ,
  `RootedWeight` INT(11) NOT NULL ,
  `DebugWeight` INT(11) NOT NULL ,
  `UnknownSourcesWeight` INT(11) NOT NULL ,
  `LowRiskApp` INT(11) NOT NULL ,
  `MediumRiskApp` INT(11) NOT NULL ,
  `HighRiskApp` INT(11) NOT NULL ,
  `BlockedApp` INT(11) NOT NULL ,
  PRIMARY KEY (`SettingID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `byod`.`scanresults`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`scanresults` (
  `scanID` INT(11) NOT NULL AUTO_INCREMENT ,
  `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `rooted` TINYINT(1) NOT NULL ,
  `rootedScore` INT(11) NOT NULL ,
  `debuggingEnabled` TINYINT(1) NOT NULL ,
  `debuggingEnabledScore` INT(11) NOT NULL ,
  `unknownSourcesAllowed` TINYINT(1) NOT NULL ,
  `unknownSourcesScore` INT(11) NOT NULL ,
  `blacklistedApps` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `appsScore` INT(11) NOT NULL ,
  `OSVersion` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `OSScore` INT(11) NOT NULL ,
  `totalScore` INT(11) NOT NULL ,
  `accessAllowed` TINYINT(1) NOT NULL ,
  `device_MACAddress` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `device_UID` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `device_SerialNumber` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `settings_SettingID` INT(11) NOT NULL ,
  PRIMARY KEY (`scanID`) ,
  INDEX `fk_scanresults_device1_idx` (`device_MACAddress` ASC, `device_UID` ASC, `device_SerialNumber` ASC) ,
  INDEX `fk_scanresults_settings1_idx` (`settings_SettingID` ASC) ,
  CONSTRAINT `fk_scanresults_device1`
    FOREIGN KEY (`device_MACAddress` , `device_UID` , `device_SerialNumber` )
    REFERENCES `byod`.`device` (`MACAddress` , `UID` , `SerialNumber` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_scanresults_settings1`
    FOREIGN KEY (`settings_SettingID` )
    REFERENCES `byod`.`settings` (`SettingID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `byod`.`technician`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`technician` (
  `technicianID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `employeeCode` VARCHAR(60) NOT NULL ,
  `userName` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `photo` BLOB NULL DEFAULT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  `admin` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`technicianID`) ,
  UNIQUE INDEX `userID_UNIQUE` (`technicianID` ASC) ,
  UNIQUE INDEX `employeeID_UNIQUE` (`employeeCode` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `byod` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
