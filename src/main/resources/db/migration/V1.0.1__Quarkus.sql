CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE project (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE project_member (
    project_id INT NOT NULL,
    person_id INT NOT NULL,
    PRIMARY KEY (project_id, person_id),
    FOREIGN KEY (project_id) REFERENCES project (id),
    FOREIGN KEY (person_id) REFERENCES person (id)
);