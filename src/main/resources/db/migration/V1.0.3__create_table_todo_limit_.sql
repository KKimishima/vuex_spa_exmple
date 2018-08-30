CREATE TABLE todo_limit(
  id SERIAL PRIMARY KEY NOT NULL,
  limit_date DATE NOT NULL ,
  limit_time TIME NOT NULL ,
  updated_time timestamp NOT NULL default current_timestamp,
  created_time timestamp  NOT NULL default current_timestamp
);

INSERT INTO todo_limit(limit_date,limit_time) VALUES ('2018/01/01','09:01:01');

ALTER TABLE todo_list ADD COLUMN todo_limit_id INT;
UPDATE todo_list SET todo_limit_id = 1 WHERE id = 1;
ALTER TABLE todo_list ALTER COLUMN todo_limit_id SET NOT NULL;

ALTER TABLE todo_list ADD FOREIGN KEY (todo_limit_id) REFERENCES todo_limit(id)