### Testing of Controllers (application deployed in application context `votinsystem`).


#### get All Votes by User
`curl -s http://localhost:8080/votingsystem/votes/100000 --user admin@gmail.com:admin`

#### get voting result
`curl -s http://localhost:8080/votingsystem/votes/result --user user@yandex.ru:password`

#### create Votes
`curl -s -X POST http://localhost:8080/votingsystem/votes?restaurantId=100002 --user user@yandex.ru:password`

#### get All Restaurants With Menu
`curl -s http://localhost:8080/votingsystem/restaurants --user user@yandex.ru:password`

#### create Restaurants
`curl -s -X POST -d '{"name":"New Restaurant"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/restaurants --user admin@gmail.com:admin`

#### get Menu By Restaurant
`curl -s http://localhost:8080/votingsystem/menus/100002 --user admin@gmail.com:admin`

#### create Meals
`curl -s -X POST -d '{"name":"New Meal","value":777}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/meals?menuId=100008 --user admin@gmail.com:admin`

#### update Meals
`curl -s -X PUT -d '{"name":"Updated Meal", "value":888}' -H 'Content-Type: application/json' http://localhost:8080/votingsystem/meals/100012 --user admin@gmail.com:admin`

#### get Meals
`curl -s http://localhost:8080/votingsystem/meals/100012 --user admin@gmail.com:admin`

#### delete Meals
`curl -s -X DELETE http://localhost:8080/votingsystem/meals/100012 --user admin@gmail.com:admin`

#### get Meals not found
`curl -s http://localhost:8080/votingsystem/meals/100045 --user admin@gmail.com:admin`

#### create Meals validate with Error 
`curl -s -X POST -d '{"name":"New Meal","value":2}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsystem/meals?menuId=100008 --user admin@gmail.com:admin`
