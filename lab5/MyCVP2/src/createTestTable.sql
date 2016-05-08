DROP DATABASE IF EXISTS `shoestring`;
CREATE DATABASE `shoestring`; 
USE `shoestring`;

CREATE TABLE `Address` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `line1` varchar(255) default NULL,
  `line2` varchar(255) default NULL,
  `line3` varchar(255) default NULL,
  `line4` varchar(255) default NULL,
  `country` varchar(150) default NULL,
  `postcode` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
);


CREATE TABLE `Person` (
  `firstName` varchar(255) default NULL,
  `lastName` varchar(255) default NULL,
  `addressId` int(10) unsigned default NULL,
  `title` varchar(45) default NULL,
  `gender` varchar(20) default NULL,
  `dateOfBirth` datetime default NULL,
  `suffix` varchar(45) default NULL,
  `daytimePhone` varchar(45) default NULL,
  `eveningPhone` varchar(45) default NULL,
  `webSite` varchar(255) default NULL,
  `maritalStatus` varchar(20) default NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  `password` varchar(64) NOT NULL,
  `email` varchar(255) NOT NULL,
  `localeLanguage` varchar(2) default NULL,
  `localeCountry` varchar(2) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `FK_person_2` (`email`),
  KEY `FK_person_1` (`addressId`)
);

ALTER TABLE `Person`
  ADD FOREIGN KEY (`addressId`) REFERENCES `Address` (`id`);

