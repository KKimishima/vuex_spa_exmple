DELETE FROM todo_list;
ALTER TABLE todo_list DROP COLUMN todo_limit_id;
ALTER TABLE todo_list ADD COLUMN limit_date DATE;
ALTER TABLE todo_list ADD COLUMN limit_time TIME;

INSERT INTO todo_list(title,describe,progress_id,user_id,limit_date,limit_time) VALUES ('サンプルタイトル1','サンプル1説明',1,1,'2018/01/01','09:01:01');
INSERT INTO todo_list(title,describe,progress_id,user_id,limit_date,limit_time) VALUES ('サンプルタイトル2','サンプル1説明',2,1,'2018/01/02','10:01:01');
INSERT INTO todo_list(title,describe,progress_id,user_id,limit_date,limit_time) VALUES ('サンプルタイトル3','サンプル1説明',3,1,'2018/01/03','11:01:01');

DROP TABLE IF EXISTS todo_limit;