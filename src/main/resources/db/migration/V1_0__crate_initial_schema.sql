CREATE TABLE user
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    email           VARCHAR(50)  NOT NULL UNIQUE,
    password        VARCHAR(255) NOT NULL,
    enabled         BIT,
    token           varchar(255),
    created_account datetime DEFAULT NOW()
);

CREATE TABLE role
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE user_roles
(
    user_id BIGINT NOT NULL,
    roles_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (roles_id) REFERENCES role (id)
);

CREATE TABLE game
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    count_games INT NOT NULL,
    win_games INT NOT NULL,
    lose_games INT NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE statistics
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    count_all_games INT NOT NULL,
    registration_players INT NOT NULL
);