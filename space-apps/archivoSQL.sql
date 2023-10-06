CREATE TYPE ORGANIZADOR_TIPOS AS ENUM (
	'Universidad',
	'Gobierno',
	'Centro de Investigacion',
	'Empresa',
	'Organizacion no gubernamental',
	'Otro'
);
CREATE TYPE PROYECTO_TIPOS AS ENUM (
	'Cientifica',
	'Clinica',
	'Social',
	'Educativa',
	'Mercado',
	'Otro'
);
CREATE TYPE PROYECTO_ESTADO AS ENUM ('Completada', 'Suspendida', 'Iniciada', 'Activa');
CREATE TYPE COLABORADOR_ESTADOS AS ENUM ('Activo', 'Inactivo');
CREATE TYPE HABILIDAD_ESTADOS AS ENUM ('Visible', 'No visible');
CREATE TYPE HABILIDAD_NIVELES AS ENUM (
	'Aficionado',
	'Principiante',
	'Básico',
	'Intermedio',
	'Avanzado',
	'Profesional'
);
CREATE TABLE ORGANIZADOR(
	ORGANIZADOR_ID SERIAL,
	ORGANIZADOR_NOMBRE VARCHAR,
	ORGANIZADOR_TIPO ORGANIZADOR_TIPOS,
	ORGANIZADOR_PAIS VARCHAR,
	ORGANIZADOR_EMAIL VARCHAR,
	ORGANIZADOR_TELEFONO VARCHAR,
	CONSTRAINT PK_ORGANIZADOR PRIMARY KEY (ORGANIZADOR_ID)
);
CREATE TABLE PROYECTO(
	PROYECTO_ID SERIAL,
	PROYECTO_ORGANIZADOR SERIAL,
	PROYECTO_NOMBRE VARCHAR,
	PROYECTO_TIPO PROYECTO_TIPOS,
	PROYECTO_DESCRIPCION VARCHAR,
	PROYECTO_ESTADO PROYECTO_ESTADO,
	PROYECTO_EXTRA VARCHAR,
	CONSTRAINT PK_PROYECTO PRIMARY KEY (PROYECTO_ID),
	CONSTRAINT FK_PROYECTO_ORGANIZADOR_ID FOREIGN KEY (PROYECTO_ORGANIZADOR) REFERENCES ORGANIZADOR(ORGANIZADOR_ID)
);
CREATE TABLE PERFIL(
	PERFIL_ID SERIAL,
	PERFIL_TITULO VARCHAR,
	PERFIL_DESCRIPCION VARCHAR,
	CONSTRAINT PK_PERFIL PRIMARY KEY (PERFIL_ID)
);
CREATE TABLE PROYECTOPERFIL(
	PROYECTOPERFIL_ID SERIAL,
	PROYECTOPERFIL_PROYECTO_ID SERIAL,
	PROYECTOPERFIL_PERFIL_ID SERIAL,
	CONSTRAINT PK_PROYECTOPERFIL PRIMARY KEY (PROYECTOPERFIL_ID),
	CONSTRAINT UQ_PROYECTOPERFIL UNIQUE(
		PROYECTOPERFIL_PROYECTO_ID,
		PROYECTOPERFIL_PERFIL_ID
	),
	CONSTRAINT FK_PROYECTOPERFIL_PROYECTO_ID FOREIGN KEY (PROYECTOPERFIL_PROYECTO_ID) REFERENCES PROYECTO(PROYECTO_ID),
	CONSTRAINT FK_PROYECTOPERFIL_PERFIL_ID FOREIGN KEY (PROYECTOPERFIL_PERFIL_ID) REFERENCES PERFIL(PERFIL_ID)
);
CREATE TABLE ETIQUETA(
	ETIQUETA_ID SERIAL,
	ETIQUETA_DESCRIPCION VARCHAR,
	CONSTRAINT PK_ETIQUETA PRIMARY KEY (ETIQUETA_ID)
);
CREATE TABLE PERFILETIQUETA(
	PERFILETIQUETA_ID SERIAL,
	PERFILETIQUETA_PERFIL_ID SERIAL,
	PERFILETIQUETA_ETIQUETA_ID SERIAL,
	CONSTRAINT PK_PERFILETIQUETA PRIMARY KEY (PERFILETIQUETA_ID),
	CONSTRAINT FK_PERFILETIQUETA_PERFIL_ID FOREIGN KEY (PERFILETIQUETA_PERFIL_ID) REFERENCES PERFIL(PERFIL_ID),
	CONSTRAINT FK_PERFILETIQUETA_ETIQUETA_ID FOREIGN KEY (PERFILETIQUETA_ETIQUETA_ID) REFERENCES ETIQUETA(ETIQUETA_ID),
	CONSTRAINT UQ_PERFILETIQUETA UNIQUE(
		PERFILETIQUETA_PERFIL_ID,
		PERFILETIQUETA_ETIQUETA_ID
	)
);
CREATE TABLE COLABORADOR(
	COLABORADOR_ID SERIAL,
	COLABORADOR_CURRICULUM_ID SERIAL,
	COLABORADOR_NOMBRE VARCHAR,
	COLABORADOR_APELLIDOS VARCHAR,
	COLABORADOR_EMAIL VARCHAR,
	COLABORADOR_PERFILIMG VARCHAR,
	COLABORADOR_CONTRASENA VARCHAR,
	COLABORADOR_PAIS VARCHAR,
	COLABORADOR_ESTADO COLABORADOR_ESTADOS,
	CONSTRAINT PK_COLABORADOR PRIMARY KEY (COLABORADOR_ID)
);
CREATE TABLE CURRICULUM(
	CURRICULUM_ID SERIAL,
	CURRICULUM_COLABORADOR_ID SERIAL,
	CURRICULUM_DESCRIPCION VARCHAR,
	CURRICULUM_EXTRA VARCHAR,
	CONSTRAINT PK_CURRICULUM PRIMARY KEY (CURRICULUM_ID)
);
ALTER TABLE COLABORADOR
ADD CONSTRAINT FK_COLABORADOR FOREIGN KEY (COLABORADOR_CURRICULUM_ID) REFERENCES CURRICULUM(CURRICULUM_ID);
ALTER TABLE CURRICULUM
ADD CONSTRAINT FK_CURRICULUM FOREIGN KEY (CURRICULUM_COLABORADOR_ID) REFERENCES COLABORADOR(COLABORADOR_ID);
CREATE TABLE SKILL(
	SKILL_ID SERIAL,
	SKILL_TITULO VARCHAR,
	SKILL_ESTADO HABILIDAD_ESTADOS,
	CONSTRAINT PK_SKILL PRIMARY KEY (SKILL_ID)
);
CREATE TABLE IDIOMA(
	IDIOMA_ID SERIAL,
	IDIOMA_TITULO VARCHAR,
	IDIOMA_ESTADO HABILIDAD_ESTADOS,
	CONSTRAINT PK_IDIOMA PRIMARY KEY (IDIOMA_ID)
);
CREATE TABLE SKILLCV(
	SKILLCV_ID SERIAL,
	SKILLCV_SKILL_ID SERIAL,
	SKILLCV_CURRICULUM_ID SERIAL,
	SKILLCV_NIVEL HABILIDAD_NIVELES,
	CONSTRAINT PK_SKILLCV PRIMARY KEY (SKILLCV_ID),
	CONSTRAINT FK_SKILLCV_SKILL_ID FOREIGN KEY (SKILLCV_SKILL_ID) REFERENCES SKILL(SKILL_ID),
	CONSTRAINT FK_SKILLCV_CURRICULUM_ID FOREIGN KEY (SKILLCV_CURRICULUM_ID) REFERENCES CURRICULUM(CURRICULUM_ID),
	CONSTRAINT UQ_SKILLCV UNIQUE (SKILLCV_SKILL_ID, SKILLCV_CURRICULUM_ID)
);
CREATE TABLE IDIOMACV(
	IDIOMACV_ID SERIAL,
	IDIOMACV_IDIOMA_ID SERIAL,
	IDIOMACV_CURRICULUM_ID SERIAL,
	IDIOMACV_NIVEL HABILIDAD_NIVELES,
	CONSTRAINT PK_IDIOMACV PRIMARY KEY (IDIOMACV_ID),
	CONSTRAINT FK_IDIOMACV_IDIOMA_ID FOREIGN KEY (IDIOMACV_IDIOMA_ID) REFERENCES IDIOMA(IDIOMA_ID),
	CONSTRAINT FK_IDIOMACV_CURRICULUM_ID FOREIGN KEY (IDIOMACV_CURRICULUM_ID) REFERENCES CURRICULUM(CURRICULUM_ID),
	CONSTRAINT UQ_IDIOMACV UNIQUE (IDIOMACV_IDIOMA_ID, IDIOMACV_CURRICULUM_ID)
);
CREATE TABLE SOLICITUD(
	SOLICITUD_ID SERIAL,
	SOLICITUD_PROYECTO_ID SERIAL,
	SOLICITUD_COLABORADOR_ID SERIAL,
	CONSTRAINT PK_SOLICITUD PRIMARY KEY (SOLICITUD_ID),
	CONSTRAINT FK_SOLICITUD_PROYECTO_ID FOREIGN KEY (SOLICITUD_PROYECTO_ID) REFERENCES PROYECTO(PROYECTO_ID),
	CONSTRAINT FK_SOLICITUD_COLABORADOR_ID FOREIGN KEY (SOLICITUD_COLABORADOR_ID) REFERENCES COLABORADOR(COLABORADOR_ID),
	CONSTRAINT UQ_SOLICITUD UNIQUE (SOLICITUD_PROYECTO_ID, SOLICITUD_COLABORADOR_ID)
);
