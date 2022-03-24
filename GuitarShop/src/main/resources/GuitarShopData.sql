drop table if exists guitar_models CASCADE;
CREATE TABLE guitar_models (
    id BIGINT AUTO_INCREMENT,
    body VARCHAR(30) NOT NULL,
    good_for_metal BOOLEAN NOT NULL,
    model VARCHAR(30) NOT NULL,
    pickup_config VARCHAR(30) NOT NULL,
    pickups VARCHAR(30) NOT NULL,
    price FLOAT NOT NULL,
    rose_wood BOOLEAN NOT NULL,
    strings INTEGER NOT NULL,
    year INTEGER NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO `guitar_models` (`strings`, `year`, `price`, `model`, `body`, `pickups`, `pickup_config`, `good_for_metal`, `rose_wood`) VALUES (6, 1998, 770.00, 'tele', 'maple', 'singlecoil', 'SH', false, true); 
INSERT INTO `guitar_models` (`strings`, `year`, `price`, `model`, `body`, `pickups`, `pickup_config`, `good_for_metal`, `rose_wood`) VALUES (7, 2012, 900.00, 'superstrat', 'mahogany', 'humbucker', 'HH', true, false); 

