CREATE DATABASE receptek_db;

USE receptek_db;

drop table recipe;
drop table user;

CREATE TABLE user (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE recipe (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    ingredients TEXT,
    steps TEXT,
    author_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES user(id) on delete cascade
);

INSERT INTO user (username, password) VALUES
    ('Alice', '$2a$10$Vic36aKvCgqfOVwLXeHNruEHRl9R8rUlGQ2mRQHdj2lwADSa.3rSS'),
    ('Bob', '$2a$10$ITZqc4TJa1SsgA9O1a2Zc.WpRheYTQ0i4K3xJM41kFECvhy7BQVMW'),
    ('Charlie', '$2a$10$TQoiCsUI1woZ9pbuaYl1w.oT2Jjumzw1rG1JHN5A3j7KqpBgPk.fW'),
    ('Dave', '$2a$10$WflmHPMZr4LS2FOCycBlGOLuqS3jt7nVgEVm/bUa7Hfvg1Q26FeOS'),
    ('Eve', '$2a$10$U77eTu4wqKcnx5r41skoSeM3eia7Rs80e1oMbknrcrNgRfzvVA1Ge');

INSERT INTO recipe (name, ingredients, steps, author_id) VALUES
    ('Spaghetti Bolognese', 'spaghetti, ground beef, tomatoes, onion, garlic', '1. Cook spaghetti. 2. Brown ground beef with onion and garlic. 3. Add tomatoes and cook for 10 minutes. 4. Serve sauce over spaghetti.', 1),
    ('Chicken Parmesan', 'chicken breast, breadcrumbs, Parmesan cheese, marinara sauce, mozzarella cheese', '1. Preheat oven to 375°F. 2. Coat chicken in breadcrumbs and Parmesan cheese. 3. Bake for 20 minutes. 4. Top with marinara and mozzarella cheese. 5. Bake for an additional 10 minutes. 6. Serve.', 2),
    ('Beef Stroganoff', 'beef sirloin, mushrooms, onion, garlic, sour cream, egg noodles', '1. Cook egg noodles. 2. Brown beef with mushrooms, onion, and garlic. 3. Add sour cream and cook for 10 minutes. 4. Serve over egg noodles.', 3),
    ('Chocolate Cake', 'flour, sugar, cocoa powder, eggs, milk, vegetable oil', '1. Preheat oven to 350°F. 2. Mix dry ingredients. 3. Mix in wet ingredients. 4. Pour batter into cake pan. 5. Bake for 30 minutes. 6. Let cool. 7. Serve.', 4),
    ('Apple Pie', 'pie crust, apples, sugar, cinnamon, nutmeg, butter', '1. Preheat oven to 375°F. 2. Slice apples and mix with sugar, cinnamon, and nutmeg. 3. Put apple mixture in pie crust. 4. Top with butter. 5. Bake for 45 minutes. 6. Serve.', 1);
