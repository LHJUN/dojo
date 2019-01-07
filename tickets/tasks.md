    1. 
    given label of item:"apple" Quantity:1 Unit price:1  state code:"UT"
    when CashTicketIssuer  generate ticket
    then return ticket string
    
    apple     1   1.00   1.00
    
    -----------------------------------------------------
    Total without taxes                              1.00
    Discout 0.00%                                   -0.00
    Tax 6.85%                                       +0.07
    -----------------------------------------------------
    Total price                                      1.07
    
    2
    given label of item:"apple" Quantity:1 Unit price:2000  state code:"UT"
    when CashTicketIssuer  generate ticket
    then return ticket string 
    
    apple     1   2000.00   2000.00
    
    -----------------------------------------------------
    Total without taxes                              2000.00
    Discout 3.00%                                   -60.00
    Tax 6.85%                                       +137.00
    -----------------------------------------------------
    Total price                                      2077.00
    
    3
    given label of item:"apple" Quantity:1 Unit price:2000  state code:"NV"
    when CashTicketIssuer  generate ticket
    then return ticket string 
    
    apple     1   2000.00   2000.00
    
    -----------------------------------------------------
    Total without taxes                              2000.00
    Discount 3.00%                                   -60.00
    Tax 8.00%                                       +160.00
    -----------------------------------------------------
    Total price                                      2100.00