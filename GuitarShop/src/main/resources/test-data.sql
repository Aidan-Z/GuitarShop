DROP TABLE IF EXISTS `guitar_models`;

CREATE TABLE guitar_models(
id long AUTO_INCREMENT, 
strings int NOT NULL,
_year int NOT NULL,
price float NOT NULL,
model VARCHAR(30) NOT NULL,
body VARCHAR(30) NOT NULL,
pickups VARCHAR(30) NOT NULL,
pickupConfig VARCHAR(30) NOT NULL,
goodForMetal boolean NOT NULL,
roseWood boolean NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO `guitar_models` (`strings`, `year`, `price`, `model`, `body`, `pickups`, `pickup_Config`, `good_For_Metal`, `roseWood`) VALUES (6, 1998, 770.00, 'tele', 'maple', 'singlecoil', 'SH', false, true); 
INSERT INTO `guitar_models` (`strings`, `year`, `price`, `model`, `body`, `pickups`, `pickup_Config`, `good_For_Metal`, `roseWood`) VALUES (7, 2012, 900.00, 'superstrat', 'mahogany', 'humbucker', 'HH', true, false); 
INSERT INTO `guitar_models` (`strings`, `year`, `price`, `model`, `body`, `pickups`, `pickup_Config`, `good_For_Metal`, `roseWood`) VALUES (6, 1960, 2300.00, 'tele', 'maple', 'singlecoil', 'SH', false, true); 
INSERT INTO `guitar_models` (`strings`, `year`, `price`, `model`, `body`, `pickups`, `pickup_Config`, `good_For_Metal`, `roseWood`) VALUES (6, 1954, 4520.00, 'lespaul', 'mahogany', 'humbucker', 'HH', true, true); 
INSERT INTO `guitar_models` (`strings`, `year`, `price`, `model`, `body`, `pickups`, `pickup_Config`, `good_For_Metal`, `roseWood`) VALUES (6, 1983, 1345.00, 'strat', 'alder', 'singlecoil', 'SSS', false, true); 
INSERT INTO `guitar_models` (`strings`, `year`, `price`, `model`, `body`, `pickups`, `pickup_Config`, `good_For_Metal`, `roseWood`) VALUES (6, 1999, 500.00, '335', 'mahogany', 'humbucker', 'HH', false, true); 
INSERT INTO `guitar_models` (`strings`, `year`, `price`, `model`, `body`, `pickups`, `pickup_Config`, `good_For_Metal`, `roseWood`) VALUES (8, 2005, 824.00, 'superstrat', 'maple', 'humbucker', 'HSH', true, false); 
INSERT INTO `guitar_models` (`strings`, `year`, `price`, `model`, `body`, `pickups`, `pickup_Config`, `good_For_Metal`, `roseWood`) VALUES (9, 2020, 3000.00, 'boden', 'maple', 'coiltap', 'HH', true, false); 
INSERT INTO `guitar_models` (`strings`, `year`, `price`, `model`, `body`, `pickups`, `pickup_Config`, `good_For_Metal`, `roseWood`) VALUES (5, 2008, 300.00, 'hellokitty', 'plywood', 'singlecoil', 'S', false, false); 
