CREATE TABLE items(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    description VARCHAR(400) NOT NULL,
    category VARCHAR(180) NOT NULL,
    status VARCHAR(100) NOT NULL,
    create_date DATETIME NOT NULL,
    update_date DATETIME,
    delete_date DATETIME,
    PRIMARY KEY(id)
);
