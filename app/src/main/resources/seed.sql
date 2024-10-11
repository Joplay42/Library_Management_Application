-- CREATE TABLE users (
--     id INT NOT NULL AUTO_INCREMENT,
--     username VARCHAR(20) NOT NULL UNIQUE,
--     email VARCHAR(50) NOT NULL UNIQUE,
--     password VARCHAR(100) NOT NULL,
--     phone VARCHAR(15) NOT NULL UNIQUE,
--     permission ENUM('admin', 'user') NOT NULL,
--     account_created DATE NOT NULL,
--     PRIMARY KEY (id)
-- );


-- CREATE TABLE books (
--     book_id INT PRIMARY KEY AUTO_INCREMENT,
--     title VARCHAR(255) NOT NULL,
--     author VARCHAR(255) NOT NULL,
--     isbn VARCHAR(13) NOT NULL,
--     published_year INT NOT NULL,
--     is_available BOOLEAN NOT NULL
-- );

-- INSERT INTO books (title, author, isbn, published_year, is_available) VALUES
--     ('To Kill a Mockingbird', 'Harper Lee', '9780060935467', 1960, TRUE),
--     ('1984', 'George Orwell', '9780451524935', 1949, TRUE),
--     ('Pride and Prejudice', 'Jane Austen', '9780141439518', 1813, TRUE),
--     ('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', 1925, TRUE),
--     ('Moby Dick', 'Herman Melville', '9781503280786', 1851, TRUE),
--     ('War and Peace', 'Leo Tolstoy', '9781400079988', 1869, TRUE),
--     ('The Catcher in the Rye', 'J.D. Salinger', '9780316769488', 1951, TRUE),
--     ('The Hobbit', 'J.R.R. Tolkien', '9780547928227', 1937, TRUE),
--     ('Brave New World', 'Aldous Huxley', '9780060850524', 1932, TRUE),
--     ('The Lord of the Rings', 'J.R.R. Tolkien', '9780618640157', 1954, TRUE),
--     ('The Brothers Karamazov', 'Fyodor Dostoevsky', '9780374528379', 1880, TRUE),
--     ('The Adventures of Huckleberry Finn', 'Mark Twain', '9780486280615', 1884, TRUE),
--     ('Crime and Punishment', 'Fyodor Dostoevsky', '9780486415871', 1866, TRUE),
--     ('The Odyssey', 'Homer', '9780140268867', -800, TRUE),
--     ('One Hundred Years of Solitude', 'Gabriel Garcia Marquez', '9780060883287', 1967, TRUE),
--     ('Ulysses', 'James Joyce', '9780199535675', 1922, TRUE),
--     ('Wuthering Heights', 'Emily Brontë', '9780141439556', 1847, TRUE),
--     ('Don Quixote', 'Miguel de Cervantes', '9780060934347', 1605, TRUE),
--     ('Frankenstein', 'Mary Shelley', '9780486282114', 1818, TRUE),
--     ('The Divine Comedy', 'Dante Alighieri', '9780142437223', 1320, TRUE),
--     ('The Iliad', 'Homer', '9780140447941', -762, TRUE),
--     ('The Picture of Dorian Gray', 'Oscar Wilde', '9780141439570', 1890, TRUE),
--     ('Les Misérables', 'Victor Hugo', '9780451419439', 1862, TRUE),
--     ('Anna Karenina', 'Leo Tolstoy', '9780143035008', 1877, TRUE),
--     ('The Scarlet Letter', 'Nathaniel Hawthorne', '9780486280486', 1850, TRUE),
--     ('The Count of Monte Cristo', 'Alexandre Dumas', '9780140449266', 1844, TRUE),
--     ('Great Expectations', 'Charles Dickens', '9780141439563', 1861, TRUE),
--     ('Fahrenheit 451', 'Ray Bradbury', '9781451673319', 1953, TRUE),
--     ('Dracula', 'Bram Stoker', '9780486411095', 1897, TRUE),
--     ('The Old Man and the Sea', 'Ernest Hemingway', '9780684801223', 1952, TRUE);

