CREATE TABLE person (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE project (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE project_member (
    project_id BIGINT NOT NULL,
    person_id BIGINT NOT NULL,
    PRIMARY KEY (project_id, person_id),
    FOREIGN KEY (project_id) REFERENCES project (id),
    FOREIGN KEY (person_id) REFERENCES person (id)
);