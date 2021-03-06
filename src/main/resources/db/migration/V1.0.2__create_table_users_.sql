CREATE TABLE users(
  id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL ,
  pass VARCHAR(255) NOT NULL ,
  updated_time timestamp NOT NULL default current_timestamp,
  created_time timestamp  NOT NULL default current_timestamp,
  UNIQUE (id,name)
);

-- ハッシュ化したパスワードはdemo
INSERT INTO users (name,pass) VALUES ('user1', 'ce5f8d0c5790bf82e9b253d362feb51ba02853301ae24149b260bd30acb00f1b2a0d8b18bbff97a9');

ALTER TABLE todo_list ADD COLUMN user_id INT;
UPDATE todo_list SET user_id = 1 WHERE id = 1;
ALTER TABLE todo_list ALTER COLUMN user_id SET NOT NULL;

ALTER TABLE todo_list ADD FOREIGN KEY (user_id) REFERENCES users(id)