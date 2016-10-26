-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Projeto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Projeto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Projeto` DEFAULT CHARACTER SET utf8 ;
USE `Projeto` ;

-- -----------------------------------------------------
-- Table `Projeto`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto`.`Produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `quantidade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Projeto`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto`.`Cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `telefone` VARCHAR(50) NOT NULL,
  `sexo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Projeto`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projeto`.`venda` (
  `Produto_id` INT NOT NULL,
  `Cliente_id` INT NOT NULL,
  `dataDaVenda` DATETIME NULL DEFAULT now(),
  PRIMARY KEY (`Produto_id`, `Cliente_id`),
  INDEX `fk_Produto_has_Cliente_Cliente1_idx` (`Cliente_id` ASC),
  INDEX `fk_Produto_has_Cliente_Produto_idx` (`Produto_id` ASC),
  CONSTRAINT `fk_Produto_has_Cliente_Produto`
    FOREIGN KEY (`Produto_id`)
    REFERENCES `Projeto`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_has_Cliente_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `Projeto`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
