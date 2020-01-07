INSERT INTO `etin`.`custom_user` (`account_non_expired`, `account_non_locked`, `credentials_non_expired`, `email`, `enabled`, `password`, `username`) VALUES ('T', 'T', 'T', 'louiiuol@live.fr', 'T', '$2a$10$VdQQpPC9NPCf4AF96aedIOpQ6/5NYoyBzX4a.ncqyanBcS5joxNWi', 'louiiuol');

INSERT INTO `etin`.`role` VALUES (1,'ROLE_USER','T'), (2,'ROLE_ADMIN','F');

COMMIT;

INSERT INTO `etin`.`user_role` VALUES (1,2);

COMMIT;