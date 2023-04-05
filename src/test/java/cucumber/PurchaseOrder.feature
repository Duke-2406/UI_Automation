Feature: Purchase the order from Ecommerce Website

  Background:
    Given I landed on Ecommerce Page

 Scenario Outline: Positive Test of submitting the order
   Given Logged in with username <name> and password <password>
   When I add product <productName> to cart
   And Checkout <productname> and submit the order
   Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

   Examples:
   |name                         | password          | productName |
   |deepaksihare891@gmail.com    | Deepak@2406       | ZARA COAT 3 |