CREATE TABLE Users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                       phone VARCHAR(20),
                       address TEXT,
                       is_admin BOOLEAN DEFAULT FALSE,
                       created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE Guest_Checkout (
                                guest_id INT AUTO_INCREMENT PRIMARY KEY,
                                name VARCHAR(255) NOT NULL,
                                email VARCHAR(255),
                                phone VARCHAR(20),
                                address TEXT,
                                created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE Categories (
                            category_id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description TEXT,
                            parent_category_id INT,
                            FOREIGN KEY (parent_category_id) REFERENCES Categories(category_id) ON DELETE SET NULL
);
CREATE TABLE Products (
                          product_id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          price DECIMAL(10, 2) NOT NULL,
                          stock INT NOT NULL,
                          image_url VARCHAR(255),
                          category_id INT NOT NULL,
                          created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (category_id) REFERENCES Categories(category_id) ON DELETE CASCADE
);
CREATE TABLE Orders (
                        order_id INT AUTO_INCREMENT PRIMARY KEY,
                        user_id INT, -- Nullable for guest users
                        guest_id INT, -- Nullable for registered users
                        order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                        status ENUM('Pending', 'Shipped', 'Delivered', 'Cancelled') DEFAULT 'Pending',
                        total_amount DECIMAL(10, 2) NOT NULL,
                        FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE SET NULL,
                        FOREIGN KEY (guest_id) REFERENCES Guest_Checkout(guest_id) ON DELETE SET NULL
);
CREATE TABLE Order_Items (
                             order_item_id INT AUTO_INCREMENT PRIMARY KEY,
                             order_id INT NOT NULL,
                             product_id INT NOT NULL,
                             quantity INT NOT NULL,
                             price DECIMAL(10, 2) NOT NULL,
                             FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE,
                             FOREIGN KEY (product_id) REFERENCES Products(product_id) ON DELETE CASCADE
);
CREATE TABLE Reviews (
                         review_id INT AUTO_INCREMENT PRIMARY KEY,
                         product_id INT NOT NULL,
                         user_id INT, -- Nullable for guest users
                         guest_id INT, -- Nullable for registered users
                         rating INT NOT NULL CHECK (rating BETWEEN 1 AND 5),
                         comment TEXT,
                         created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (product_id) REFERENCES Products(product_id) ON DELETE CASCADE,
                         FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE SET NULL,
                         FOREIGN KEY (guest_id) REFERENCES Guest_Checkout(guest_id) ON DELETE SET NULL
);
CREATE TABLE Wishlist (
                          wishlist_id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT NOT NULL,
                          product_id INT NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
                          FOREIGN KEY (product_id) REFERENCES Products(product_id) ON DELETE CASCADE
);
CREATE TABLE Admin_Activities (
                                  activity_id INT AUTO_INCREMENT PRIMARY KEY,
                                  admin_id INT NOT NULL, -- Refers to the user_id of an admin
                                  action_type ENUM('Add', 'Update', 'Delete', 'View', 'Other') NOT NULL,
                                  target_table VARCHAR(50), -- E.g., 'Products', 'Orders', 'Users'
                                  target_id INT, -- ID of the item affected (e.g., product_id, order_id)
                                  description TEXT, -- A brief description of the action
                                  timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
                                  FOREIGN KEY (admin_id) REFERENCES Users(user_id) ON DELETE CASCADE
);