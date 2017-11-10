DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM menus;
DELETE FROM votes;
DELETE FROM restaurants;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (user_id, role) VALUES
  (100000, 'ROLE_USER'),
  (100001, 'ROLE_ADMIN'),
  (100001, 'ROLE_USER');

INSERT INTO restaurants (name) VALUES
  ('Blue Lagoon'),
  ('Joe`s');

INSERT INTO votes (USER_ID, RESTAURANT_ID, DATE_TIME) VALUES
  (100000, 100002, '2015-05-30 10:00:00'),
  (100000, 100003, '2015-05-31 10:00:00'),
  (100001, 100003, '2015-05-30 15:00:00'),
  (100001, 100003, '2015-05-31 15:00:00');

INSERT INTO menus (restaurant_id) VALUES
  (100002),
  (100002),
  (100003),
  (100003);

INSERT INTO meals (menu_id, name, value) VALUES
  (100008, 'salad', 550),
  (100008, 'steak', 1600),
  (100009, 'soup', 600),
  (100009, 'coffee', 340),
  (100010, 'cake', 500),
  (100010, 'tea', 150),
  (100011, 'chicken', 800),
  (100011, 'juice', 350);