USE dojos_and_ninjas_schema;
SELECT dojos.id, dojos.name, ninjas.id, ninjas.first_name, ninjas.last_name, ninjas.dojo_id
FROM dojos 
    LEFT JOIN ninjas 
    ON dojos.id = ninjas.dojo_id;
INSERT INTO dojos (name)
VALUES("dojo_1"), ("dojo_2"), ("dojo_3");
DELETE FROM dojos
	ORDER BY name
	LIMIT 3;
INSERT INTO dojos (name)
VALUES("dojo_4"), ("dojo_5"), ("dojo_6");
INSERT INTO ninjas (first_name, last_name, dojo_id)
VALUE ("John", "Smith", 4), ("Chuck", "Thomas", 4), ("Jean", "Sanchez", 4),
		("Tom", "Michelson", 5), ("Carly", "Stevens", 5), ("Chad", "Evens", 5),
		("Sarah", "Jackson", 6), ("Nicole", "Peters", 6), ("Eric", "Kelly", 6);
SELECT GROUP_CONCAT(ninjas.first_name," ",ninjas.last_name) AS "Full Name", dojos.name AS "Dojo Name"
FROM dojos
	LEFT JOIN ninjas
	ON dojos.id = ninjas.dojo_id
		WHERE dojos.name = "dojo_4";
SELECT GROUP_CONCAT(ninjas.first_name," ",ninjas.last_name) AS "Full Name", dojos.name AS "Dojo Name"
FROM dojos
	LEFT JOIN ninjas
	ON dojos.id = ninjas.dojo_id
		WHERE dojos.name = "dojo_6";
SELECT GROUP_CONCAT(ninjas.first_name," ",ninjas.last_name) AS "Full Name", dojos.name AS "Dojo Name", ninjas.created_at
FROM dojos
	LEFT JOIN ninjas
	ON dojos.id = ninjas.dojo_id
		WHERE ninjas.id = (SELECT MAX(id) 
							FROM ninjas)
        -- ^subquery
			GROUP BY dojos.name, ninjas.id;