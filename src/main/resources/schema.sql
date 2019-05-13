CREATE TABLE DEVELOPER(
    DEVELOPER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(16) NOT NULL
);

CREATE TABLE ISSUES(
    ISSUES_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    TITLE VARCHAR(64),
    DESCRIPTION VARCHAR(64),
    CREATION_DATE DATE,
    ASSIGNED_DEVELOPER BIGINT NOT NULL,
    TYPE VARCHAR(64)
);

CREATE TABLE STORIES(
    STORIES_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    STORIES_ISSUES_ID BIGINT NOT NULL,
    EPV VARCHAR(64),
    STATUS VARCHAR(64)

);

CREATE TABLE BUGS(
    BUGS_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    BUGS_ISSUES_ID BIGINT NOT NULL,
    PRIORITY VARCHAR(64),
    STATUS VARCHAR(64)
);

ALTER TABLE STORIES ADD FOREIGN KEY (STORIES_ISSUES_ID) REFERENCES ISSUES(ISSUES_ID);
ALTER TABLE BUGS ADD FOREIGN KEY (BUGS_ISSUES_ID) REFERENCES ISSUES(ISSUES_ID);
ALTER TABLE ISSUES ADD FOREIGN KEY (ASSIGNED_DEVELOPER) REFERENCES DEVELOPER(DEVELOPER_ID);