CREATE DATABASE IF NOT EXISTS hostel;
USE hostel;

DROP TABLE IF EXISTS `hostel`.`student`;
CREATE TABLE `hostel`.`student` (
  `rollno` VARCHAR(45) NOT NULL,
  `roomno` VARCHAR(45) NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NOT NULL,
  `doe` VARCHAR(35) NOT NULL,
  `doexit` VARCHAR(35) NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`rollno`));