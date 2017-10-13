DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM menus;
DELETE FROM votes;
DELETE FROM restaurants;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'qwerty'),
  ('Admin', 'admin@gmail.com', 'zxc');

INSERT INTO user_roles (user_id, role) VALUES
  (100000, 'ROLE_USER'),
  (100001, 'ROLE_ADMIN'),
  (100001, 'ROLE_USER');

INSERT INTO restaurants (id, name) VALUES
  (100002, 'Blue Lagoon'),
  (100003, 'Joe`s');

INSERT INTO votes (USER_ID, RESTAURANT_ID, DATE_TIME) VALUES
  (100000, 100002, '2015-05-30 10:00:00'),
  (100001, 100003, '2017-10-25 15:00:00');

INSERT INTO menus (restaurant_id) VALUES
  (100002),
  (100003);

INSERT INTO meals (menu_id, name, value) VALUES
  (100004, 'salad', 550),
  (100004, 'steak', 160),
  (100005, 'soup', 600),
  (100005, 'coffee', 340);