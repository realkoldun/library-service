INSERT INTO books (isbn, author, description, genre, title) VALUES
                                                                ('978-1-4088-9792-3', 'George Orwell', 'A dystopian social science fiction novel and cautionary tale about the dangers of totalitarianism.', 'Science Fiction', '1984'),
                                                                ('978-0-7432-7356-5', 'Dan Brown', 'A symbologist uncovers the secrets of a centuries-old society while solving the murder of the curator at the Louvre.', 'Thriller', 'The Da Vinci Code'),
                                                                ('978-0-452-28423-4', 'F. Scott Fitzgerald', 'A novel set in the Jazz Age that tells the story of Jay Gatsbys unrequited love for Daisy Buchanan.', 'Classic', 'The Great Gatsby'),
                                                                ('978-0-394-57419-7', 'Harper Lee', 'A novel of warmth and humor despite dealing with serious issues of rape and racial inequality in the Deep South.', 'Classic', 'To Kill a Mockingbird'),
                                                                ('978-0-345-39180-3', 'J.R.R. Tolkien', 'The first volume in the epic fantasy trilogy, introducing the quest to destroy the One Ring.', 'Fantasy', 'The Fellowship of the Ring'),
                                                                ('978-0-316-76948-0', 'Stephen King', 'A horror novel about a young girl with pyrokinetic abilities who is on the run from a government agency.', 'Horror', 'Firestarter'),
                                                                ('978-0-00-730260-9', 'Agatha Christie', 'A detective novel that presents the mystery of the murder of Roger Ackroyd in a small village.', 'Mystery', 'The Murder of Roger Ackroyd'),
                                                                ('978-0-316-76948-1', 'Jane Austen', 'A romantic novel that charts the emotional development of the protagonist, Elizabeth Bennet.', 'Romance', 'Pride and Prejudice'),
                                                                ('978-0-671-02735-0', 'Isaac Asimov', 'A collection of science fiction short stories that form the basis for the Three Laws of Robotics.', 'Science Fiction', 'I, Robot'),
                                                                ('978-0-385-73672-8', 'Kurt Vonnegut', 'A satirical novel about World War II experiences and journeys through time.', 'Science Fiction', 'Slaughterhouse-Five');

INSERT INTO tickets (book_id, return_date, taken_date) VALUES
                                                           (1, '2024-11-10', '2024-10-10'),
                                                           (2, '2024-11-15', '2024-10-15'),
                                                           (3, '2024-11-20', '2024-10-20'),
                                                           (4, '2024-11-25', '2024-10-25'),
                                                           (5, '2024-11-30', '2024-10-30'),
                                                           (6, '2024-12-05', '2024-11-05'),
                                                           (7, '2024-12-10', '2024-11-10'),
                                                           (8, '2024-12-15', '2024-11-15'),
                                                           (9, '2024-12-20', '2024-11-20'),
                                                           (10, '2024-12-25', '2024-11-25');
