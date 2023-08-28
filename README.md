# Sales Management

This project is a REST API, developed in Java using Spring Boot, which aims to automate the standard process in a commercial transaction of products, such as recording sales and managing their stock.


## Index
- [1. Description](#item1)
- [2. Requirements](#item2)
- [3. E-R-D](#item3)
- [4. Tools of Development](#item4)

<a name="item1"></a>
### Description
This project will be based on the MVC (Model-View-Controller) architecture to separate the business logic, presentation, and user interaction.

For the database modeling, the following entities are considered: Customer, Sale, Sale Detail, and Product. Where each Sale is associated with one and only one Customer, each Sale Detail can have more than one Sale and more than one associated Product. 

Next, we will describe each entity and its corresponding class in the "entities" section.

1.	**Customer:** It will represent the individuals who make purchases of the offered products. Each customer would have attributes such as: name, email, dni, etc. Its representative class is **Customer**, which will have a relationship _*@OneToMany*_ with the class _*Sale*_.
2.	**Sale:** The entity will contain information related to each sales transaction. It will have attributes such as issue date, sale number, total sale amount, etc. Each Sale would be associated with a customer and would contain multiple related "Sale Detail". Modeling this in code, we will represent this entity in the **Sale** class in the "entities" layer, which will have a _*ManyToOne*_ relationship with the _*Customer*_ class and a _*OneToMany*_ relationship with the _*Sale_Detail*_ class.
3.	**Sale_Detail:** The entity "Sale Detail" will record the specific products sold in each sale. It includes attributes such as quantity, price per quantity of product, etc. Each "Sale Detail" will be related to a product and a sale. In our code architecture, within the "entities" section, this entity is represented by the class **Sale_Detail**, which will have a _*ManyToOne*_ relationship with the **Sale** class and a _*ManyToOne*_ relationship with the **Product** class.
4.	**Product:** This entity represents the items available for sale. It has attributes such as name, brand, price and available quantity. Its representative class is  **Product**, which will have a _*@OneToMany*_ relationship with the _*Sale_Detail*_ class.

The project is developed using a layered architecture:
1. **Entities:** We host the classes representing the entities in the database: _*Customer*_, _*Sale*_, Sale_Detail, and _*Product*_.
2. **Repositories:** We store interfaces that extend _JpaRepository_ for each class in _*entities*_, which provide predefined methods for performing database operations such as saving, retrieving, and deleting records.
3. **Services:** In this layer, through classes and interfaces, services are implemented for each entity. These services contain the "business logic," which is responsible for managing the interaction between the classes in the _controllers_ y _repositories_ layers.
4. **Controllers:** From this layer, we store the various "controller" classes using Spring MVC annotations. These classes handle the _*HTTP*_ requests.
5. **Validators:** In this layer, we perform unit and integration testing to ensure that all components function correctly.

<a name="item2"></a>
### Requirements
Next, we list some of the requirements that we developed in the API:

1. Complete CRUD operations for each entity.
2. Automate the update of the product _*Stock*_ whose "id" is referenced as _*id_product*_ from an instance of an object of the _Sale_Detail_ class. This update will depend on the value of the _quantity_ attribute.
3. Check if there is enough product quantity available for sale.
4. Automate the update of the _Invoice Total Amount to Pay_ each time a product is selected for sale in that sale.

<a name="item3"></a>
### E-R-D
![D-E-R  Sales_Management]()

<a name="item4"></a>
### Tools

<p align="left> 
   <a href="" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" alt="Spring Boot" width="100" height="100"/>
  <a href="" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" alt="Java" width="100" height="100"/>
    <a href="https://www.mysql.com/" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="100" height="100"/>
 
</p>
