SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `byod` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `byod` ;

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
AUTO_INCREMENT = 57
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `byod`.`device`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`device` (
  `Manufacturer` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `Model` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `DateRegistered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `MACAddress` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `AndroidID` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `SerialNumber` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `employee_empID` INT(10) UNSIGNED NOT NULL ,
  `Token` VARCHAR(6) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  PRIMARY KEY (`MACAddress`, `AndroidID`, `SerialNumber`) ,
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
-- Table `byod`.`activeuser`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`activeuser` (
  `ActiveID` INT(11) NOT NULL AUTO_INCREMENT ,
  `IP` VARCHAR(15) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `device_MACAddress` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `device_AndroidID` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `device_SerialNumber` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  PRIMARY KEY (`ActiveID`) ,
  INDEX `fk_activeuser_device1_idx` (`device_MACAddress` ASC, `device_AndroidID` ASC, `device_SerialNumber` ASC) ,
  CONSTRAINT `fk_activeuser_device1`
    FOREIGN KEY (`device_MACAddress` , `device_AndroidID` , `device_SerialNumber` )
    REFERENCES `byod`.`device` (`MACAddress` , `AndroidID` , `SerialNumber` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `byod`.`blacklistedapp`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`blacklistedapp` (
  `AppID` INT(11) NOT NULL AUTO_INCREMENT ,
  `AppName` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `AppCategory` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  PRIMARY KEY (`AppID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `byod`.`devicenotregistered`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`devicenotregistered` (
  `Manufacturer` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `Model` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `DateRegistered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `MACAddress` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `AndroidID` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `SerialNumber` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `token` VARCHAR(5) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `username` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `password` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `IDNumber` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `Name` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `Surname` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  PRIMARY KEY (`MACAddress`, `AndroidID`, `SerialNumber`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `byod`.`setting`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`setting` (
  `SettingID` INT(11) NOT NULL AUTO_INCREMENT ,
  `AccessScore` INT(11) NOT NULL ,
  `SettingDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `APIWeight` INT(11) NOT NULL DEFAULT '5' ,
  `RootedWeight` INT(11) NOT NULL DEFAULT '100' ,
  `DebugWeight` INT(11) NOT NULL DEFAULT '10' ,
  `UnknownSourcesWeight` INT(11) NOT NULL DEFAULT '10' ,
  `LowRiskApp` INT(11) NOT NULL DEFAULT '5' ,
  `MediumRiskApp` INT(11) NOT NULL DEFAULT '10' ,
  `HighRiskApp` INT(11) NOT NULL DEFAULT '20' ,
  `BlockedApp` INT(11) NOT NULL DEFAULT '100' ,
  PRIMARY KEY (`SettingID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `byod`.`scanresult`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `byod`.`scanresult` (
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
  `APILevel` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL ,
  `APIScore` INT(11) NOT NULL ,
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
    REFERENCES `byod`.`device` (`MACAddress` , `AndroidID` , `SerialNumber` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_scanresults_settings1`
    FOREIGN KEY (`settings_SettingID` )
    REFERENCES `byod`.`setting` (`SettingID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;




SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
