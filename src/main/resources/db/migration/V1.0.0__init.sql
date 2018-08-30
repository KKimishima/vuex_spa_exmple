CREATE TABLE todo_list(
  id SERIAL PRIMARY KEY NOT NULL,
  title VARCHAR(255)  NOT NULL,
  describe  VARCHAR(255),
  updated_time timestamp NOT NULL default current_timestamp,
  created_time timestamp  NOT NULL default current_timestamp
);

INSERT INTO todo_list(title,describe) values('サンプルタイトル','サンプル説明');