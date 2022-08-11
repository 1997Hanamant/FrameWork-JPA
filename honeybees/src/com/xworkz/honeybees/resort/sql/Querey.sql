CREATE SCHEMA `resorts` ;
CREATE TABLE `resorts`.`resorts_info` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `checkintime` VARCHAR(45) NULL,
  `checkouttime` VARCHAR(45) NULL,
  `createby` VARCHAR(45) NULL,
  `createdate` DATE NULL,
  `updatedate` DATE NULL,
  `priceperday` DOUBLE NULL,
  ADD COLUMN `owner` VARCHAR(45) NOT NULL AFTER `priceperday`;
  PRIMARY KEY (`id`));