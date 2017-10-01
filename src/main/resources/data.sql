INSERT INTO user (id, nickname, password) VALUES ('1', 'test', '$2a$11$b3gp3TbSIacbDQGKnFamS.gLm4WBihMdl5BAfAz7MWSHulqWPhcwe');
INSERT INTO user (id, nickname, password, lat, lng) VALUES ('2', 'Stephan', '$2a$11$.u7sPdfsChA9QrKhKemLL.laQlERJvhjB/4/uU4sajBOgBSDRAWQC', '47.465210', '12.203946');
INSERT INTO user (id, nickname, password, lat, lng) VALUES ('3', 'Robert', '$2a$11$fR7kh.L9PUh/5c82o5hg5udRKLdMZOa2I9V/ZKUArUEX1cfS4zLiC', '47.480173', '12.192431');
INSERT INTO user (id, nickname, password, lat, lng) VALUES ('4', 'Valentin', '$2a$11$o6/ctPNl8HIo71PViJhBPeK.ixOMC3h3TUZjp1DCnoWwnLZ3dz8Bq', '47.456421', '12.185614');

INSERT INTO team (id, name) VALUES ('1', 'Selches');

INSERT INTO team_members (team_id, member_id) VALUES ('1', '2');
INSERT INTO team_members (team_id, member_id) VALUES ('1', '3');
INSERT INTO team_members (team_id, member_id) VALUES ('1', '4');