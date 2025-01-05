CREATE TABLE `forumhub` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `autor` varchar(255) DEFAULT NULL,
  `curso` varchar(255) DEFAULT NULL,
  `data_criacao` date(255) DEFAULT NULL,
  `mensagem` varchar(255) DEFAULT NULL,
  `status` bit(10) NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`));