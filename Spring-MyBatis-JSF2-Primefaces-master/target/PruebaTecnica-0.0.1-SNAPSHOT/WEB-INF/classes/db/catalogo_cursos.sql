-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-09-2016 a las 14:50:55
-- Versión del servidor: 10.1.10-MariaDB
-- Versión de PHP: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
Drop database if exists catalogo_cursos;
Create database if not exists catalogo_cursos;
use catalogo_cursos;
--
-- Base de datos: `catalogo_cursos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `id` int(11) NOT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `titulo` varchar(50) DEFAULT NULL,
  `nivel` varchar(50) DEFAULT NULL,
  `horas` int(11) DEFAULT NULL,
  `idProfesor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`id`, `activo`, `titulo`, `nivel`, `horas`, `idProfesor`) VALUES
(1, 1, 'Java 8', 'Intermedio', 25, 1),
(2, 1, 'Spring MVC', 'Básico', 55, 2),
(3, 1, 'JSF + Spring+ MyBatis', 'Intermedio', 75, 2),
(4, 0, 'Angular JS 2', 'Intermedio', 65, 3),
(5, 1, 'Spark 2.0', 'Avanzado', 60, 4),
(6, 1, 'Introducción a Hadoop', 'Básico', 64, 4),
(7, 1, 'Hive + Flume + Spark Core', 'Intermedio', 23, 5),
(8, 1, 'Fundamentos de Streaming Processing', 'Avanzado', 70, 6),
(9, 0, 'Spark Streaming', 'Avanzado', 14, 7),
(10, 1, 'Pulsar y Apache Apex', 'Avanzado', 40, 8),
(11, 0, 'Berkeley DB', 'Básico', 88, 9),
(12, 1, 'Lucene + Solr', 'Intermedio', 15, 10),
(13, 0, 'Arquitectura Kappa', 'Avanzado', 100, 11),
(19, 1, 'Arquitectura Lambda', 'Avanzado', 33, 13),
(20, 1, 'Programación en Scala', 'Intermedio', 70, 4),
(21, 1, 'Programación en R', 'Intermedio', 200, 2),
(26, 1, 'jQuery Mobile', 'Básico', 250, 1),
(27, 1, 'Joomla CMS', 'Avanzado', 500, 7),
(28, 0, 'NoActivo', 'Intermedio', 1, 1),
(29, 1, 'Activo', 'Básico', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`id`, `nombre`) VALUES
(1, 'ENRIQUE DE LA ROSA VILARIÑO'),
(2, 'LAURA MORANTE MATAMOROS'),
(3, 'NEREA SALAS SEVILLANO'),
(4, 'VICTOR MANUEL VAL PARADA'),
(7, 'ENRIQUE DE LA ROSA VILARIÑO'),
(8, 'LAURA MORANTE MATAMOROS'),
(9, 'NEREA SALAS SEVILLANO'),
(10, 'VICTOR MANUEL VAL PARADA'),
(11, 'MARIA CRISTINA BARROSO GRANDA'),
(12, 'MARC VELAZQUEZ BERNARDO'),
(13, 'ESTEBAN URBANO OLIVER'),
(14, 'TOMAS GIRALDEZ VARELA'),
(15, 'MARIA NIEVES CASAS DE LOS REYE'),
(16, 'LORENA MAGRO DEVESA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tema`
--

CREATE TABLE `tema` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `idCurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tema`
--

INSERT INTO `tema` (`id`, `nombre`, `idCurso`) VALUES
(1, 'Tema 1', 1),
(2, 'Tema 2', 1),
(3, 'Tema 3', 2),
(4, 'Tema 4', 2),
(5, 'Tema 5', 3),
(6, 'Tema 6', 3),
(7, 'Tema 7', 4),
(8, 'Tema 8', 5),
(9, 'Tema 9', 5),
(10, 'Tema 10', 5),
(11, 'Tema 11', 5),
(12, 'Tema 12', 5),
(13, 'Tema 13', 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tema`
--
ALTER TABLE `tema`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT de la tabla `profesor`
--
ALTER TABLE `profesor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT de la tabla `tema`
--
ALTER TABLE `tema`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
