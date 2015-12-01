-- MySQL Workbench Synchronization
-- Generated: 2015-12-01 01:15
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Victor

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `museu`.`atividade` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`autor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `diaN` INT(11) NULL DEFAULT NULL,
  `mesN` INT(11) NULL DEFAULT NULL,
  `anoN` INT(11) NULL DEFAULT NULL,
  `diaM` INT(11) NULL DEFAULT NULL,
  `mesM` INT(11) NULL DEFAULT NULL,
  `anoM` INT(11) NULL DEFAULT NULL,
  `diaIniAtv` INT(11) NULL DEFAULT NULL,
  `mesIniAtv` INT(11) NULL DEFAULT NULL,
  `anoIniAtv` INT(11) NULL DEFAULT NULL,
  `diaFimAtv` INT(11) NULL DEFAULT NULL,
  `mesFimAtv` INT(11) NULL DEFAULT NULL,
  `anoFimAtv` INT(11) NULL DEFAULT NULL,
  `descricao` VARCHAR(100) NULL DEFAULT NULL,
  `pais` VARCHAR(55) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '		';

CREATE TABLE IF NOT EXISTS `museu`.`autor_atividade` (
  `atividade_id` INT(11) NOT NULL,
  `autor_id` INT(11) NOT NULL,
  PRIMARY KEY (`atividade_id`, `autor_id`),
  INDEX `fk_atividade_has_Autor_Autor1_idx` (`autor_id` ASC),
  INDEX `fk_atividade_has_Autor_atividade_idx` (`atividade_id` ASC),
  CONSTRAINT `fk_atividade_has_Autor_atividade`
    FOREIGN KEY (`atividade_id`)
    REFERENCES `museu`.`atividade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_atividade_has_Autor_Autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `museu`.`autor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`obra` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL DEFAULT NULL,
  `apelido` VARCHAR(45) NOT NULL,
  `dia` INT(11) NULL DEFAULT NULL,
  `mes` INT(11) NULL DEFAULT NULL,
  `ano` INT(11) NULL DEFAULT NULL,
  `periodo` VARCHAR(45) NULL DEFAULT NULL,
  `altura` FLOAT(11) NULL DEFAULT NULL,
  `largura` FLOAT(11) NULL DEFAULT NULL,
  `profundidade` FLOAT(11) NULL DEFAULT NULL,
  `valor` DECIMAL(7,2) NULL DEFAULT NULL,
  `biografia` VARCHAR(500) NULL DEFAULT NULL,
  `autor_id` INT(11) NOT NULL,
  `instituicao_id` INT(11) NOT NULL COMMENT 'Doador',
  `categoria` VARCHAR(45) NULL DEFAULT NULL,
  `tipo` VARCHAR(45) NULL DEFAULT NULL,
  `movimento` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_obra_autor1_idx` (`autor_id` ASC),
  INDEX `fk_obra_instituicao1_idx` (`instituicao_id` ASC),
  CONSTRAINT `fk_obra_autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `museu`.`autor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_obra_instituicao1`
    FOREIGN KEY (`instituicao_id`)
    REFERENCES `museu`.`instituicao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`pais` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`estado` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `pais_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_estado_pais1_idx` (`pais_id` ASC),
  CONSTRAINT `fk_estado_pais1`
    FOREIGN KEY (`pais_id`)
    REFERENCES `museu`.`pais` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`cidade` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `estado_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cidade_estado1_idx` (`estado_id` ASC),
  CONSTRAINT `fk_cidade_estado1`
    FOREIGN KEY (`estado_id`)
    REFERENCES `museu`.`estado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`instituicao` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `endereco` VARCHAR(45) NULL DEFAULT NULL,
  `numero` VARCHAR(45) NULL DEFAULT NULL,
  `cep` VARCHAR(45) NULL DEFAULT NULL,
  `contato` VARCHAR(45) NULL DEFAULT NULL,
  `cargo` VARCHAR(45) NULL DEFAULT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `pais` VARCHAR(55) NULL DEFAULT NULL,
  `estado` VARCHAR(55) NULL DEFAULT NULL,
  `cidade` VARCHAR(55) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`emprestimo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `tituloExibicao` VARCHAR(45) NOT NULL,
  `dataEmprestimo` DATE NOT NULL,
  `dataDevolucao` DATE NOT NULL,
  `observacao` VARCHAR(45) NULL DEFAULT NULL,
  `instituicao_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_emprestimo_instituicao1_idx` (`instituicao_id` ASC),
  CONSTRAINT `fk_emprestimo_instituicao1`
    FOREIGN KEY (`instituicao_id`)
    REFERENCES `museu`.`instituicao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`emprestimo_obra` (
  `emprestimo_id` INT(11) NOT NULL,
  `obra_id` INT(11) NOT NULL,
  PRIMARY KEY (`emprestimo_id`, `obra_id`),
  INDEX `fk_obra_has_emprestimo_emprestimo1_idx` (`emprestimo_id` ASC),
  INDEX `fk_obra_has_emprestimo_obra1_idx` (`obra_id` ASC),
  CONSTRAINT `fk_obra_has_emprestimo_obra1`
    FOREIGN KEY (`obra_id`)
    REFERENCES `museu`.`obra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_obra_has_emprestimo_emprestimo1`
    FOREIGN KEY (`emprestimo_id`)
    REFERENCES `museu`.`emprestimo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`ingresso` (
  `id` INT(11) NOT NULL,
  `tituloExibicao` VARCHAR(45) NOT NULL,
  `dataInicio` DATE NOT NULL,
  `dataFim` DATE NOT NULL,
  `exibicaoEspecial` TINYINT(1) NULL DEFAULT NULL,
  `precoSemana` FLOAT(11) NULL DEFAULT NULL,
  `precoFimDeSemana` FLOAT(11) NULL DEFAULT NULL,
  `autor_id` INT(11) NOT NULL COMMENT 'Principal artista',
  `limiteIngresso` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ingresso_autor1_idx` (`autor_id` ASC),
  CONSTRAINT `fk_ingresso_autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `museu`.`autor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`visitante` (
  `id` INT(11) NOT NULL,
  `sexo` TINYINT(1) NULL DEFAULT NULL,
  `escolaridade` VARCHAR(45) NULL DEFAULT NULL,
  `locomocao` VARCHAR(45) NULL DEFAULT NULL,
  `idade` INT(11) NULL DEFAULT NULL,
  `pais` VARCHAR(55) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`venda` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `qtdInteiro` INT(11) NOT NULL,
  `qtdMeio` INT(11) NOT NULL,
  `valorTotal` FLOAT(11) NOT NULL,
  `tipoPagamento` VARCHAR(45) NOT NULL,
  `nomeExposicao` VARCHAR(45) NULL DEFAULT NULL,
  `reserva` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `museu`.`usuario` (
  `idusuario` INT(11) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `cpf` VARCHAR(45) NULL DEFAULT NULL,
  `gerente` TINYINT(1) NULL DEFAULT NULL,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `senha` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
