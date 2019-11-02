USE hostel;

DROP TABLE IF EXISTS `hostel`.`room`;
CREATE TABLE `hostel`.`room` (
  `roomno` VARCHAR(45) NOT NULL,
   `nop`   INT NULL,
  `cstatus` INT NOT NULL,
  PRIMARY KEY (`roomno`));