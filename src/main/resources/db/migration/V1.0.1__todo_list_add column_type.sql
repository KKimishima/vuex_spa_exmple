CREATE TABLE todo_progress(
  id SERIAL PRIMARY KEY NOT NULL,
  progress_name VARCHAR(255) NOT NULL ,
  updated_time timestamp NOT NULL default current_timestamp,
  created_time timestamp  NOT NULL default current_timestamp,
  UNIQUE (id,progress_name)
);

INSERT INTO todo_progress(progress_name) values ('新規');
INSERT INTO todo_progress(progress_name) values ('開始');
INSERT INTO todo_progress(progress_name) values ('進行中');
INSERT INTO todo_progress(progress_name) values ('完了');

ALTER TABLE todo_list ADD COLUMN progress_id INT;
UPDATE todo_list SET progress_id = 1 WHERE id = 1;
ALTER TABLE todo_list ALTER COLUMN progress_id SET NOT NULL;

ALTER TABLE todo_list ADD FOREIGN KEY (progress_id) REFERENCES todo_progress(id)