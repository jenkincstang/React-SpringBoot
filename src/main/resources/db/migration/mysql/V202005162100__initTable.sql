CREATE TABLE IF NOT EXISTS `movie_list`  (
`id` bigint NOT NULL AUTO_INCREMENT,
`movie_id` bigint NOT NULL,
`title` text NOT NULL,
`rating` float NULL,
`movie_year` int NULL,
`image_large` text NULL,
`url` text NULL,
`casts` text NULL,
`directors` text NULL,
`genres` text NULL,
`summary` longtext NULL,
`countries` text NULL,
`viewed` tinyint NULL,
`star` tinyint NULL,
`update_time` timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
`movie_type` tinytext NOT NULL,
PRIMARY KEY (`id`),
INDEX `movie_type_index`(`movie_type`(20)) USING BTREE,
UNIQUE INDEX `movie_id_index`(`movie_id`) USING BTREE
);