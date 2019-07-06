CREATE TABLE POINT(
	pointseq INT,
	allpoint INT,
	mbrpoint INT,
	userid VARCHAR(20) NOT NULL,
	PRIMARY KEY (pointseq)
);

INSERT INTO POINT
(pointseq, allpoint, mbrpoint, userid)
VALUES(1, 10000, 0, 'danah');

ALTER TABLE POINT add COLUMN replycnt INT DEFAULT 0;