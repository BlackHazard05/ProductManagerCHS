# ProductManagerCHS
Proyecto de Prueba para VISE

------ SCRIPT INICIAL -----------
CREATE TABLE `ProductManager`.`Producto` (
  `PRO_Id` INT NOT NULL AUTO_INCREMENT,
  `PRO_Nombre` VARCHAR(45) NOT NULL,
  `PRO_Marca` VARCHAR(45) NOT NULL,
  `PRO_Elaborado` VARCHAR(45) NOT NULL,
  `PRO_Precio` FLOAT NOT NULL,
  PRIMARY KEY (`PRO_Id`));
