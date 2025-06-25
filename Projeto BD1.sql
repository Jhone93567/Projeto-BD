CREATE SCHEMA IF NOT EXISTS `Projeto_BD` DEFAULT CHARACTER SET utf8;
USE `Projeto_BD`;

CREATE TABLE IF NOT EXISTS `Competições` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Lugar` VARCHAR(45) NOT NULL,
  `Data` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `Nome_UNIQUE` (`Nome` ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS `Capitães` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `Nome_UNIQUE` (`Nome` ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS `Coordenadores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS `Categorias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Capitães_id` INT NOT NULL,
  `Coordenadores_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Categorias_Capitães_idx` (`Capitães_id` ASC) VISIBLE,
  INDEX `fk_Categorias_Coordenadores1_idx` (`Coordenadores_id` ASC) VISIBLE,
  CONSTRAINT `fk_Categorias_Capitães`
    FOREIGN KEY (`Capitães_id`)
    REFERENCES `Capitães` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Categorias_Coordenadores1`
    FOREIGN KEY (`Coordenadores_id`)
    REFERENCES `Coordenadores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `Membros` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Periodo` INT NOT NULL,
  `Curso` VARCHAR(45) NOT NULL,
  `Categorias_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `Nome_UNIQUE` (`Nome` ASC) VISIBLE,
  INDEX `fk_Membros_Categorias1_idx` (`Categorias_id` ASC) VISIBLE,
  CONSTRAINT `fk_Membros_Categorias1`
    FOREIGN KEY (`Categorias_id`)
    REFERENCES `Categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `Robos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Categorias_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Robos_Categorias1_idx` (`Categorias_id` ASC) VISIBLE,
  CONSTRAINT `fk_Robos_Categorias1`
    FOREIGN KEY (`Categorias_id`)
    REFERENCES `Categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `Competições_has_Categorias` (
  `Competições_id` INT NOT NULL,
  `Categorias_id` INT NOT NULL,
  PRIMARY KEY (`Competições_id`, `Categorias_id`),
  INDEX `fk_Competições_has_Categorias_Categorias1_idx` (`Categorias_id` ASC) VISIBLE,
  INDEX `fk_Competições_has_Categorias_Competições1_idx` (`Competições_id` ASC) VISIBLE,
  CONSTRAINT `fk_Competições_has_Categorias_Competições1`
    FOREIGN KEY (`Competições_id`)
    REFERENCES `Competições` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Competições_has_Categorias_Categorias1`
    FOREIGN KEY (`Categorias_id`)
    REFERENCES `Categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    INSERT INTO Competições (Nome,Lugar,Data) VALUES ('RSM', 'Mogi', '01/05');
    INSERT INTO Competições (Nome,Lugar,Data) VALUES ('RCX', 'Brasilia', '19/06');
    INSERT INTO Competições (Nome,Lugar,Data) VALUES ('Ironcup', 'Inatel', '19/06');
    INSERT INTO Competições (Nome,Lugar,Data) VALUES ('teste', 'teste', '19/06');
    
    UPDATE Competições SET Lugar = 'Santa Rita' where Nome = 'Ironcup';
    UPDATE Competições SET Data = '14/02' where Nome = 'Ironcup';
    
    DELETE FROM Competições where Nome = 'Ironcup';
    DELETE FROM Competições where Nome = 'teste';
        
    INSERT INTO Capitães (Nome) VALUES ('Pedro Paulo');
    INSERT INTO Capitães (Nome) VALUES ('Silas');
    INSERT INTO Capitães (Nome) VALUES ('Saldanha');
    INSERT INTO Capitães (Nome) VALUES ('teste');
    
    UPDATE Capitães SET Nome = 'Ewel' where Nome = 'Saldanha';
    UPDATE Capitães SET Nome = 'Leticia' where Nome = 'teste';
    
    DELETE FROM Capitães where Nome = 'Ewel';
    DELETE FROM Capitães where Nome = 'Leticia';
    
    INSERT INTO Coordenadores (Nome) VALUES ('Baratella');
    INSERT INTO Coordenadores (Nome) VALUES ('Saldanha');
    INSERT INTO Coordenadores (Nome) VALUES ('Eugenio');
    INSERT INTO Coordenadores (Nome) VALUES ('teste');
    
	UPDATE Coordenadores SET Nome = 'Luiz' where Nome = 'Eugenio';
    UPDATE Coordenadores SET Nome = 'Eugenio' where Nome = 'teste';
   
    DELETE FROM Coordenadores where Nome = 'Luiz';
    DELETE FROM Coordenadores where Nome = 'Eugenio';
   
    INSERT INTO Categorias (Nome, Capitães_id, Coordenadores_id) VALUES ('Sumo 3Kg', 2, 2);
    INSERT INTO Categorias (Nome, Capitães_id, Coordenadores_id) VALUES ('Sumo Lego', 1, 2);
    INSERT INTO Categorias (Nome, Capitães_id, Coordenadores_id) VALUES ('Drone', 1, 2);
    INSERT INTO Categorias (Nome, Capitães_id, Coordenadores_id) VALUES ('Marketing', 1, 2);
    
    UPDATE Categorias SET Nome = 'Sumo Mini' where Nome = 'Drone';
    UPDATE Categorias SET Nome = 'Trekking' where Nome = 'Marketing';
   
    DELETE FROM Categorias where Nome = 'Sumo Mini';
    DELETE FROM Categorias where Nome = 'Trekking';
   
    INSERT INTO Membros (Nome, Periodo, Curso, Categorias_id) VALUES ('Joao', 5, 'GEC', 1);
    INSERT INTO Membros (Nome, Periodo, Curso, Categorias_id) VALUES ('Samile', 5, 'GES', 2);
    INSERT INTO Membros (Nome, Periodo, Curso, Categorias_id) VALUES ('Silas', 5, 'GES', 2);
    INSERT INTO Membros (Nome, Periodo, Curso, Categorias_id) VALUES ('Maria', 5, 'GES', 2);
    
    UPDATE Membros SET Curso = 'GEA' where Nome = 'Maria';
    UPDATE Membros SET Periodo = 7 where Nome = 'Silas';

	DELETE FROM Membros where Nome = 'Silas';
    DELETE FROM Membros where Nome = 'Maria';
   
    INSERT INTO Robos (Nome, Categorias_id) VALUES ('Bullbasauro', 1);
    INSERT INTO Robos (Nome, Categorias_id) VALUES ('Nebulloso', 2);
    INSERT INTO Robos (Nome, Categorias_id) VALUES ('Excallibull', 1);
    INSERT INTO Robos (Nome, Categorias_id) VALUES ('Bullnita', 2);
    
    UPDATE Robos SET Nome = 'Zabullza' where Nome = 'Excallibull';
    UPDATE Robos SET Nome = 'Bullratella' where Nome = 'Bullnita';

	DELETE FROM Robos where Nome = 'Zabullza';
    DELETE FROM Robos where Nome = 'Bullratella';
    
    INSERT INTO Competições_has_Categorias (Competições_id, Categorias_id) VALUES (1,1),(1,2),(2,1),(2,2);
    
    UPDATE Competições_has_Categorias SET Competições_id = 2 where Competições_id = 3;
    UPDATE Competições_has_Categorias SET Competições_id = 1 where Competições_id = 3;
        
    DELETE FROM Competições_has_Categorias where Competições_id = 3;
    DELETE FROM Competições_has_Categorias where Competições_id = 2;
    
    SELECT Membros.Nome AS Nome_Membro, Categorias.Nome AS Nome_Categoria, Coordenadores.Nome AS Nome_Coordenador
FROM Membros
JOIN Categorias ON Membros.Categorias_id = Categorias.id
JOIN Coordenadores ON Categorias.Coordenadores_id = Coordenadores.id;

	SELECT  Robos.Nome AS Nome_Robo, Categorias.Nome AS Nome_Categoria, Capitães.Nome AS Nome_Capitao
FROM Robos
JOIN Categorias ON Robos.Categorias_id = Categorias.id
JOIN Capitães ON Categorias.Capitães_id = Capitães.id;

SELECT Competições.Nome AS Nome_Competicao, Categorias.Nome AS Nome_Categoria, Coordenadores.Nome AS Nome_Coordenador
FROM Competições
JOIN Competições_has_Categorias ON Competições.id = Competições_has_Categorias.Competições_id
JOIN Categorias ON Competições_has_Categorias.Categorias_id = Categorias.id
JOIN Coordenadores ON Categorias.Coordenadores_id = Coordenadores.id;

-- View que facilita relatórios com dados completos dos membros, incluindo a categoria, capitão e coordenador.
CREATE VIEW vw_Membros_Detalhes AS
SELECT 
  M.id AS Membro_ID,
  M.Nome AS Nome_Membro,
  M.Periodo,
  M.Curso,
  C.Nome AS Nome_Categoria,
  Cp.Nome AS Nome_Capitao,
  Co.Nome AS Nome_Coordenador
FROM 
  Membros M
JOIN 
  Categorias C ON M.Categorias_id = C.id
JOIN 
  Capitães Cp ON C.Capitães_id = Cp.id
JOIN 
  Coordenadores Co ON C.Coordenadores_id = Co.id;

SELECT * FROM vw_Membros_Detalhes;

-- Trigger que garante que nenhum membro seja inserido com um valor inválido no campo Periodo.
DELIMITER $$

CREATE TRIGGER trg_VerificaPeriodo
BEFORE INSERT ON Membros
FOR EACH ROW
BEGIN
  IF NEW.Periodo <= 0 THEN
	-- Gera um erro personalizado
    SIGNAL SQLSTATE '45000'
    -- Mensagem do erro
    SET MESSAGE_TEXT = 'O período do membro deve ser maior que zero.';
  END IF;
END $$

DELIMITER ;