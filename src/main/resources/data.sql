INSERT INTO user (id, nickname, password) VALUES ('1', 'test', 'test');
INSERT INTO user (id, nickname, password, lat, lng) VALUES ('2', 'Stephan', 'test', '47.4917816', '12.2715673');
INSERT INTO user (id, nickname, password, lat, lng) VALUES ('3', 'Robert', 'test', '47.4943406', '12.2655373');
INSERT INTO user (id, nickname, password, lat, lng) VALUES ('4', 'Valentin', 'test', '47.4943406', '12.2655373');

INSERT INTO team (id, name) VALUES ('1', 'Selches');

INSERT INTO team_members (team_id, member_id) VALUES ('1', '2');
INSERT INTO team_members (team_id, member_id) VALUES ('1', '3');
INSERT INTO team_members (team_id, member_id) VALUES ('1', '4');