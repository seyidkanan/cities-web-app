# cities-web-app


This project use cities data from this url([Imported data source] (https://www.maxmind.com/ru/free-world-cities-database)).
In project used to GSON, Spring MVC, RestFul, for MySql connection JDBS(mysql-connector-java).

##APIs in this project:

1. Get cities data<br/>
URL: **http://localhost:XXXX/getCitiesData**<br/>
Method: **GET**<br/>
Result:<br/>
<code>[
  {
    "id": 1,
    "countryCode": "ad",
    "standartCityName": "aixas",
    "realCity": "Aix?s",
    "region": "6",
    "population": "",
    "latitude": "42.4833333",
    "longitude": "1.4666667"
  }]</code>
  
2. Insert new city<br/>
URL: **http://localhost:XXXX/insertCity**<br/>
Method: **POST**<br/>
Header: **Content-Type --> application/json; charset=UTF-8**<br/>
Body: <br/>
<code>
{
	"countryCode":"az",
	"standartCityName":"Gence",
	"realCity":"Gəncə",
	"region":"qf",
	"population":"500000",
	"latitude":"32.4554",
	"longitude":"23.43543"
}
</code><br/>
Result:<br/>
if data inserted:<br/>
<code>
{
  "info": "Data was inserted"
}
</code>
<br/>
if data not inserted:<br/>
<code>
{
  "error": "Data was not inserted"
}
</code>


##Get Cities list with table
URL: **http://localhost:XXXX/** or **http://localhost:XXXX/citiesWebList**
