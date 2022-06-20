==================================================================================================================================================
==================================================================================================================================================

Functional
============================================

Facts
===========
o   MicroService - InventoryManagement
o	Admin would be maintaining the inventory. To maintian, Admin would have privileges for Adding and Removing the Stock (Cars in this case).
o	Admin can have look of Available stocks and Stock Summary too.

o   MicroService - SalesManagement
o	Buyer would have a display to check all available cars and details.
o	Buyer can place order as per choice and availability.

o   Once Buyer buys a product or Once a product sold, it would be reduced from Inventory.

Assumption
===========
o   Admin can put car price as any number.
o	Buyer can buy multiple cars.
o   Once number of quantity of particular car reduces to Zero, it would be displaying as OUT_OF_STOCK else IN_STOCK.


Technical
============================================
o  For load balancing i have used native API Gateway.
o  We have 4 MicroServices - API GATEWAY, Eureka Server, InventoryManagement and  SalesManagement.

o  InventoryManagement and SalesManagement, both services can be operated from Swagger UI.
   InventoryManagement -> http://localhost:8085/swagger-ui.html
   SalesManagement     -> http://localhost:8080/swagger-ui.html

o  We have used h2 databases. InventoryManagement Service has it's database with stock_details Table and SalesManagement is having it's database with order_details.
o  Both tables are having composite primary key of ProductCategory+ProductColor+ProductName.


==================================================================================================================================================
==================================================================================================================================================