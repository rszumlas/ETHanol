INSERT INTO vodka (id, name, flavour, bottle_size, voltage) VALUES
(1, 'Soplica', NULL, 100, 40),
(2, 'Soplica', NULL, 200, 40),
(3, 'Soplica', 'Malina', 200, 40),
(4, 'Soplica', NULL, 500, 40),
(5, 'Soplica', NULL, 700, 40),
(6, 'Soplica', NULL, 1000, 40),
(7, 'Żubrówka', NULL, 100, 40),
(8, 'Żubrówka', NULL, 200, 40),
(9, 'Żubrówka', NULL, 500, 40),
(10, 'Żubrówka', 'Mięta', 500, 40),
(11, 'Żubrówka', 'Bison Grass', 500, 40),
(12, 'Żubrówka', NULL, 700, 40),
(13, 'Żubrówka', NULL, 1000, 40),
(14, 'Stock', NULL, 500, 40),
(15, 'Stock', NULL, 700, 40),
(16, 'Stock', NULL, 1000, 40),
(17, 'Bocian', NULL, 500, 40),
(18, 'Bocian', NULL, 500, 40),
(19, 'Absolut', NULL, 700, 40),
(20, 'Absolut', 'Kurant', 700, 40),
(21, 'Absolut', 'Grapefruit', 700, 40)
ON CONFLICT DO NOTHING;
