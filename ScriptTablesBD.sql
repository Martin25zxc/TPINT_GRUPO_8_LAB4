create database BancoIntegrador;
use BancoIntegrador;
create table TiposUsuarios
( 
 TipoUsuarioID int NOT NULL AUTO_INCREMENT,
 Nombre nvarchar(60) NOT NULL,
 Descripcion nvarchar(160) NOT NULL,
 CONSTRAINT pk_TiposUsuarios PRIMARY KEY (TipoUsuarioID)
);
create table Usuarios
( 
 UsuarioID int NOT NULL AUTO_INCREMENT,
 NombreUsuario nvarchar(60) NOT NULL,
 Contrasenia nvarchar(60) NOT NULL,
 Email nvarchar(60) NOT NULL,
 Descripcion nvarchar(160) NULL,
 TipoUsuarioID int NOT NULL,
 Activo bit not null,
 CONSTRAINT pk_Usuarios PRIMARY KEY (UsuarioID),
 constraint fk_Usuarios_TiposUsuarios FOREIGN KEY (TipoUsuarioID) REFERENCES TiposUsuarios(TipoUsuarioID)
);
create table Permisos
( 
 PermisoID int NOT NULL AUTO_INCREMENT,
 Nombre nvarchar(60) NOT NULL,
 Descripcion nvarchar(160) NOT NULL,
 Tags nvarchar(160) NULL,
 CONSTRAINT pk_Permisos PRIMARY KEY (PermisoID)
);
create table PermisosUsuarios
( 
 PermisoUsuarioID int NOT NULL AUTO_INCREMENT,
 UsuarioID int NOT NULL,
 PermisoID int NOT NULL,
 CONSTRAINT pk_PEU PRIMARY KEY (PermisoUsuarioID),
 constraint fk_PEU_Usuarios FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID)  ON DELETE CASCADE,
 constraint fk_PEU_Permisos FOREIGN KEY (PermisoID) REFERENCES Permisos(PermisoID)  ON DELETE CASCADE
);
create table TiposMovimientos
( 
 TipoMovimientoID int NOT NULL AUTO_INCREMENT,
 Nombre nvarchar(60) NOT NULL,
 Descripcion nvarchar(160) NOT NULL,
 CONSTRAINT pk_TiposMovimientos PRIMARY KEY (TipoMovimientoID)
);
create table Movimientos
( 
 MovimientoID int NOT NULL AUTO_INCREMENT,
 Importe decimal(15,2) NOT NULL, -- Siempre positivo
 Detalle nvarchar(160) NOT NULL,
 TipoMovimientoID int NOT NULL,
 CONSTRAINT pk_Movimientos PRIMARY KEY (MovimientoID),
 constraint fk_Movimientos_TiposMovimientos FOREIGN KEY (TipoMovimientoID) REFERENCES TiposMovimientos(TipoMovimientoID)
);
create table ResultadosMovimientos
( 
 ResultadoMovimientoID int NOT NULL AUTO_INCREMENT,
 Importe decimal(15,2) NOT NULL, -- Cambia el signo dependiente el movimiento
 Detalle nvarchar(160) NOT NULL,
 MovimientoID  int NOT NULL,
 UsuarioID int not null, 
 CONSTRAINT pk_ResultadosMovimientos PRIMARY KEY (ResultadoMovimientoID),
 constraint fk_ResultadosMovimientos_Movimientos FOREIGN KEY (MovimientoID) REFERENCES Movimientos(MovimientoID)  ON DELETE CASCADE,
 constraint fk_ResultadosMovimientos_Usuarios FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID)  ON DELETE CASCADE
);
create table Clientes
( 
 ClienteID int NOT NULL AUTO_INCREMENT,
 FechaNacimiento Date not null,
 FechaAlta DateTime not null,
 Nombre nvarchar(160) NOT NULL,
 Apellido nvarchar(160) NOT NULL,
 Nacionalidad nvarchar(160) NOT NULL,
 Direccion nvarchar(160) NOT NULL,
 Localidad nvarchar(160) NOT NULL,
 Provincia nvarchar(160) NOT NULL,
 Email nvarchar(60) NOT NULL,
 NroDocumento nvarchar(20) NOT NULL,
 Telefono1 nvarchar(60) NOT NULL,
 Telefono2 nvarchar(60) NOT NULL,
 UsuarioID int not null,
 Activo bit not null,
 CONSTRAINT pk_Clientes PRIMARY KEY (ClienteID),
 constraint fk_Clientes_Usuarios FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID) 
);
create table TiposCuentas
( 
 TipoCuentaID int NOT NULL AUTO_INCREMENT,
 Nombre nvarchar(60) NOT NULL,
 Descripcion nvarchar(160)  NULL,
 CONSTRAINT pk_TiposCuentas PRIMARY KEY (TipoCuentaID)
);
create table Bancos
( 
 BancoID int NOT NULL AUTO_INCREMENT,
 Nombre nvarchar(60) NOT NULL,
 Descripcion nvarchar(160) NOT NULL,
 CONSTRAINT pk_Bancos PRIMARY KEY (BancoID)
);
create table Cuentas
( 
 CuentaID int NOT NULL AUTO_INCREMENT,
 ClienteID int not null,
 FechaAlta Datetime not null,
 NumeroDeCuenta nvarchar(24) NOT NULL,
 CBU nvarchar(22) NOT NULL,
 Alias nvarchar(20 ) NOT NULL, -- 6 y 20 ,
 BancoID int not null,
 TipoCuentaID int not null,
 Activo bit not null,
 constraint pk_Cuentas PRIMARY KEY (CuentaID),
 constraint fk_Cuentas_Clientes FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID) ON DELETE CASCADE,
 constraint fk_Cuentas_Bancos FOREIGN KEY (BancoID) REFERENCES Bancos(BancoID) ,
 constraint fk_Cuentas_TiposCuentas FOREIGN KEY (TipoCuentaID) REFERENCES TiposCuentas(TipoCuentaID) 
);
create table Prestamos
( 
 PrestamoID int NOT NULL AUTO_INCREMENT,
 ClienteID int not null,
 FechaAlta DateTime not null,
 ImporteAPagarcliente decimal(15,2) NOT NULL,
 ImportePedidoCliente decimal(15,2) NOT NULL,
 MontoPorCuota decimal(15,2) NOT NULL,
 Plazo int NOT NULL,
 CONSTRAINT pk_Prestamos PRIMARY KEY (PrestamoID),
 constraint fk_Prestamos_Clientes FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID) ON DELETE CASCADE
);
create table Cuotas
( 
 CuotaID int not null,
 Importe decimal(15,2) NOT NULL,
 FechaAlta DateTime not null,
 FechaPago DateTime null,
 NroCuota int not null,
 PrestamoID int not null,
 CONSTRAINT pk_Cuotas PRIMARY KEY (CuotaID),
 constraint fk_Cuotas_Prestamos FOREIGN KEY (PrestamoID) REFERENCES Prestamos(PrestamoID) ON DELETE CASCADE
);
create table EstadosRevisionesPrestamos
( 
 EstadoRevisionPrestamoID int not null AUTO_INCREMENT,
 Nombre nvarchar(24) NOT NULL,
 Descripcion nvarchar(150) NOT NULL,
 CONSTRAINT pk_ResultadosRevisionesPrestamos PRIMARY KEY (EstadoRevisionPrestamoID)
);
create table RevisionesPrestamos
( 
 RevisionPrestamoID int NOT NULL AUTO_INCREMENT,
 UsuarioIDRevision int not null,
 EstadoRevisionPrestamoID int NOT NULL,
 PrestamoID int NOT NULL,
 Fecha DateTime not null,
 CONSTRAINT pk_RevisionesPrestamos PRIMARY KEY (RevisionPrestamoID),
 constraint fk_Prestamos FOREIGN KEY (PrestamoID) REFERENCES Prestamos(PrestamoID),
 constraint fk_RevisionesPrestamos_EstadosRevisionesPrestamos FOREIGN KEY (EstadoRevisionPrestamoID) REFERENCES EstadosRevisionesPrestamos(EstadoRevisionPrestamoID),
 constraint fk_RevisionesPrestamos_Usuarios FOREIGN KEY (UsuarioIDRevision) REFERENCES Usuarios(UsuarioID) ON DELETE CASCADE
);