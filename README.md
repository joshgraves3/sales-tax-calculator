# sales-tax-calculator

Liferay Sales Tax Coding Challenge
Josh Graves

- OVERVIEW -

-This application calculates sales tax for input given in a text file.
-Each group of items must be separated by "**" to be able to differentiate between separate orders.

-The application will catch the input of a user if it is not correct. It assumes that the input given will be like the input given in the challenge prompt.

-The application is based off of key words given in the challenge prompt, if I were to make it more flexible I could make a dictionary with all possible words associated with books, food, and medical supplies and check that when figuring out the sales tax for each item of an order. This dictionary could be made using words provided by the customer or by upper management, whatever the requirements are I could change it so it is more flexible.

- FORMAT OF USER PROVIDED DATA -

*ITEMS*
The user can make their own text file to use as data for the application as long as it is in the correct format as shown below:
General format - quantity(int) + description(String) + price(double)
Specific example - 1 imported bottle of perfume at 47.50

*ORDERS* - Group of items
If there are multiple orders the format is as follows:
General format -
quantity(int) + description(String) + price(double)
quantity(int) + description(String) + price(double)
**
quantity(int) + description(String) + price(double)
quantity(int) + description(String) + price(double)
**

Specific Example -
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 imported box of chocolates at 11.25
**
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50
**

*TRANSACTIONS* - Group of orders
Transactions will be automatically created, one per text file that the user wants to use.

- NOTES -
-input2.txt was included as a test file for varying invalid inputs
