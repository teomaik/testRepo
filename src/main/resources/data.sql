-- Drop existing tables (if any) to ensure a fresh start
DROP TABLE IF EXISTS book_themes;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS themes;
DROP TABLE IF EXISTS authors;

-- Create authors table
CREATE TABLE authors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    date_of_birth VARCHAR(10)
);

-- Create themes table
CREATE TABLE themes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT
);

-- Insert data into authors table
INSERT INTO authors (first_name, last_name, date_of_birth) VALUES 
('George', 'Orwell', '1903-06-25'),
('Jane', 'Austen', '1775-12-16'),
('J.K.', 'Rowling', '1965-07-31');


-- Insert data into themes table
INSERT INTO themes (name, description) VALUES 
('Dystopian', 'Themes exploring a society under oppressive control'),
('Romance', 'Themes focused on love and relationships'),
('Fantasy', 'Themes set in magical worlds with mythical elements');


