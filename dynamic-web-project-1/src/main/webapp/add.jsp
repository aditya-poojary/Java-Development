<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body bgcolor="aqua">
    <% int i = Integer.parseInt(request.getParameter("num1")); int j =
    Integer.parseInt(request.getParameter("num2")); int k = i + j; 
    
    out.println("Output : " + k);
    
    %>
  </body>
</html>
