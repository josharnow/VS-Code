USE world;
SELECT * FROM cities;
SELECT * FROM countries;
SELECT * FROM languages;

-- 1
SELECT countries.name, languages.language, languages.percentage FROM countries
	INNER JOIN languages
    ON countries.id=languages.country_id
		WHERE languages.language = "Slovene"
			ORDER BY languages.percentage DESC;
        
-- 2
SELECT countries.name, COUNT(cities.name) AS cities FROM countries
	INNER JOIN cities
    ON countries.id=cities.country_id
		GROUP BY countries.name
			ORDER BY COUNT(cities.name) DESC;

-- 3
SELECT cities.name, cities.population, cities.country_id FROM countries
	INNER JOIN cities
    ON countries.id=cities.country_id
    WHERE countries.name = "Mexico" AND cities.population > 500000
			ORDER BY cities.population DESC;

-- 4
SELECT countries.name, languages.language, languages.percentage FROM countries
	INNER JOIN languages
    ON countries.id=languages.country_id
		WHERE languages.percentage > 0.89
			ORDER BY languages.percentage DESC, countries.name ASC;

-- 5
SELECT countries.name, countries.surface_area, countries.population FROM countries
		WHERE countries.surface_area < 501 AND countries.population > 100000;
        
-- 6
SELECT countries.name, countries.government_form, countries.capital, countries.life_expectancy FROM countries
		WHERE countries.government_form = "Constitutional Monarchy" AND countries.capital > 200 AND countries.life_expectancy > 75;

-- 7
SELECT countries.name, cities.name AS city_name, cities.district, cities.population FROM countries
	INNER JOIN cities
    ON countries.id=cities.country_id
    WHERE countries.name = "Argentina" AND cities.district = "Buenos Aires" AND cities.population > 500000
			ORDER BY cities.population DESC;


-- 8
SELECT countries.region, COUNT(countries.region) AS countries FROM countries
	GROUP BY countries.region
		ORDER BY COUNT(countries.region) DESC;