INSERT INTO user(email, password, enabled, token)
VALUES ('superAdmin@admin',
        '$2a$10$ju/OVn0M9gRaERwvsEGD3uboKU8psigrVOZ0JN8S3sdscLEdK8OUy',
        1,
        'verified'),
       ('admin@admin',
        '$2a$10$noj9xJbK1O24Qp54AEYtR.cDiQbl9/MGcMJUCGQaCFN0yO2vtbzWK',
        1,
        'verified'),
       ('user@user',
        '$2a$10$RAQmc7JXKC4VQgNr7F.cxO7dUXcdtXwriFmyC9ZdC8F18ZWiD0Mwe',
        1,
        'verified');

INSERT INTO role(name)
VALUES ('ROLE_SUPER_ADMIN'),
       ('ROLE_ADMIN'),
       ('ROLE_USER');

INSERT INTO user_roles
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 2),
       (2, 3),
       (3, 3);

INSERT INTO game(count_games,win_games,lose_games,user_id)
VALUES (0,0,0,1),(0,0,0,2),(0,0,0,3);

INSERT INTO statistics(count_all_games,registration_players)
VALUES (0,0);