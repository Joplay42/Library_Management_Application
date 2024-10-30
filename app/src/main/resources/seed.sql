CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL UNIQUE,
    permission ENUM('admin', 'user') NOT NULL,
    account_created DATE NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    published_year INT NOT NULL,
    is_available BOOLEAN NOT NULL
);

CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    book_id INT,
    borrow_date DATE NOT NULL,
    return_date DATE NOT NULL,
    actual_return_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES books(book_id)
);


INSERT INTO books (book_id, title, author, isbn, published_year, is_available) VALUES
    (1, 'To Kill a Mockingbird', 'Harper Lee', '9780060935467', 1960, TRUE),
    (2, '1984', 'George Orwell', '9780451524935', 1949, TRUE),
    (3, 'Pride and Prejudice', 'Jane Austen', '9780141439518', 1813, TRUE),
    (4, 'The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', 1925, TRUE),
    (5, 'War and Peace', 'Leo Tolstoy', '9781400079988', 1869, TRUE),
    (6, 'The Catcher in the Rye', 'J.D. Salinger', '9780316769488', 1951, TRUE),
    (7, 'The Hobbit', 'J.R.R. Tolkien', '9780547928227', 1937, TRUE),
    (8, 'Brave New World', 'Aldous Huxley', '9780060850524', 1932, TRUE),
    (9, 'The Lord of the Rings', 'J.R.R. Tolkien', '9780618640157', 1954, TRUE),
    (10, 'The Brothers Karamazov', 'Fyodor Dostoevsky', '9780374528379', 1880, TRUE),
    (11, 'The Adventures of Huckleberry Finn', 'Mark Twain', '9780486280615', 1884, TRUE),
    (12, 'Crime and Punishment', 'Fyodor Dostoevsky', '9780486415871', 1866, TRUE),
    (13, 'The Odyssey', 'Homer', '9780140268867', -800, TRUE),
    (14, 'One Hundred Years of Solitude', 'Gabriel Garcia Marquez', '9780060883287', 1967, TRUE),
    (15, 'Ulysses', 'James Joyce', '9780199535675', 1922, TRUE),
    (16, 'Wuthering Heights', 'Emily Brontë', '9780141439556', 1847, TRUE),
    (17, 'Don Quixote', 'Miguel de Cervantes', '9780060934347', 1605, TRUE),
    (18, 'Frankenstein', 'Mary Shelley', '9780486282114', 1818, TRUE),
    (19, 'The Divine Comedy', 'Dante Alighieri', '9780142437223', 1320, TRUE),
    (20, 'The Iliad', 'Homer', '9780140447941', -762, TRUE),
    (21, 'The Picture of Dorian Gray', 'Oscar Wilde', '9780141439570', 1890, TRUE),
    (22, 'Les Misérables', 'Victor Hugo', '9780451419439', 1862, TRUE),
    (23, 'Anna Karenina', 'Leo Tolstoy', '9780143035008', 1877, TRUE),
    (24, 'The Scarlet Letter', 'Nathaniel Hawthorne', '9780486280486', 1850, TRUE),
    (25, 'The Count of Monte Cristo', 'Alexandre Dumas', '9780140449266', 1844, TRUE),
    (26, 'Great Expectations', 'Charles Dickens', '9780141439563', 1861, TRUE),
    (27, 'Fahrenheit 451', 'Ray Bradbury', '9781451673319', 1953, TRUE),
    (28, 'Dracula', 'Bram Stoker', '9780486411095', 1897, TRUE),
    (29, 'The Old Man and the Sea', 'Ernest Hemingway', '9780684801223', 1952, TRUE);

