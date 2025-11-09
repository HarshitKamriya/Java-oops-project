# Supermarket-JAVA-Proj
This is my Third semester project built for OOPS- JAVA 

What we are doing in this we are building an system which is basically store the customer details and the product they are buying and displaying the price of that product to the user


Work flow :-> 1. Caisher class  => 1. Storing the caisher Id  # private
                                   2. Storing the caisher name # private       
                                   3. Id,name only initialized through constructor
                                   4. getters for getting the Id and name of caisher

              2. Customer class => 1. Storing the customer Id # private
                                   2. Storing the customer name # private
                                   3. Storing the customer phone no # private
                                   4. Id ,name , phone no only initialized through constructor
                                   5. getters  for getting Id, name , phone no of customer

              3. Product class =>  1. Storing the product Id  #private
                                   2. Storing the product name  #private
                                   3. Storing the product price  #private
                                   4. Storign the product Quantity #private
                                   5. Id ,name ,price and Quantity can only be initialized through constructor
                                   6. getters for getting Id, name , price and Quantity of that product obj.



         4. Super Market class  => 1. Making an Product array #private (we are making array private so that we do not want this should be accessed from another class) 
                                   2. Making an static product count variable so that we are able to count no of product . #private 
                                   3. Making an static total price variable #private
                                   4. we have five function in this and all have their individual use:


                                         1.addProduct(Product product) -> 
                                         
                                         it will basically store the product in product array and increase the product count , and also check for validity means size of product array is full or not
                                   
                                         2. removeProduct(int productId) ->
                                         
                                          we will traverse through our product array and match the id with the id of obj of product in our array if found we will remove it and update our array and shift all the rmaining element as we have to maintain the sequenece of array.
                                         and also decrease our product count.

                                         3. getProductList() -> 
                                         
                                         we will return the copy of our product array upto which it is filled

                                         4. getTotalPrice() -> 
                                             
                                         we will return the total price of all the product in our product array acording to their no of Quantity.

                                         5. getProductById(int productId) -> 
                                          
                                         we will traverse through the array and if the id matches with the product object and we will return that product object.
                                         

            5. Main class :                         
                         we have some function in this and their role is:
                              1. getCustomerDetails(Scanner scanner)=> here we are taking customer detail such as Id , name ,phone no and      
                                                                       calling customer class constructor to initialize a new customer object
                                                                       and returning it..
                              
                              2. getProductById(int productId) => we are getting the product list from our supermarket class and iterating 
                                                                  through it so that we can match the correct id in our list and if available
                                                                  return the product with that Id.
                              
                              3. calculateBill(List<Product> cart) => In this we are simply calculating the Bill of customer of the product 
                                                                      present in our product list.

                              4. getProductAttributes(Scanner scanner) => In this function I have written the logic so that we can get Product 
                                                                          from our product list with their Id and then return it.
                              5. printMainMenu() => In this I have written all the options available to caisher he can do.


            6. SupermarketManagementSystem1 class :
                        1. taking caisher details . we are looping until the valid caisher details are entered or not.
                        2. using switch case for the caiser who appered to our application as  now he/she is calculating the bill of customer
                        3. use while loop and switch case =>
                                    calling printMenu() function from Main class ->
                                                                         Printing the menu to caisher so that , 
                                                                         he can choose what he need to do.


            7. displayBill class:
                                we are using GUI in this to display the bill , it is extending the Main class
                                Here we are using awt for gui.


            
            8. displayProductList class:
                                we are using GUI in this to display the product list , it is extending the Main class
                                Here we are using awt for gui.


            9. displayTotalPrice class :
                                we are using GUI in this to display the total price , it is extending the Main class
                                Here we are using awt for gui.  
               


                        
                        







Thank you , This is short and simple application Created By Harshit, and now working to upgrade it more.

                                             

