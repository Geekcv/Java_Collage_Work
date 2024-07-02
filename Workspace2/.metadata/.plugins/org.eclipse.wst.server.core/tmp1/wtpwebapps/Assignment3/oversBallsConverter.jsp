<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Overs to Balls & Balls to Overs Converter</title>
</head>
<body>
    <h2>Overs to Balls & Balls to Overs Converter</h2>
    
    <form method="post">
        <label>Conversion Type:</label>
        <select name="conversionType">
            <option value="1">Overs to Balls</option>
            <option value="2">Balls to Overs</option>
        </select>
        <br><br>
        
        <label>Enter Value:</label>
        <input type="text" name="inputValue">
        <br><br>
        
        <input type="submit" value="Convert">
    </form>
    
    <hr>
    
    <%-- Perform conversion based on user input --%>
    <% 
        // Check if form is submitted
        if (request.getMethod().equalsIgnoreCase("post")) {
            try {
                // Get parameters from request
                String conversionTypeStr = request.getParameter("conversionType");
                int conversionType = Integer.parseInt(conversionTypeStr);
                String inputValueStr = request.getParameter("inputValue");
                double inputValue = Double.parseDouble(inputValueStr);
                
                double result = 0.0;
                String resultUnit = "";
                
                // Perform conversion based on selected type
                switch (conversionType) {
                    case 1: // Overs to Balls
                        result = inputValue * 6;
                        resultUnit = "balls";
                        break;
                    case 2: // Balls to Overs
                        result = inputValue / 6.0;
                        resultUnit = "overs";
                        break;
                    default:
                        out.println("<p>Invalid conversion type selected.</p>");
                        break;
                }
                
                // Display the result
                out.println("<p>Result: " + inputValue + " " + (conversionType == 1 ? "overs" : "balls") + " is equal to " + result + " " + resultUnit + ".</p>");
                
            } catch (NumberFormatException e) {
                out.println("<p>Error: Please enter a valid number.</p>");
            }
        }
    %>
</body>
</html>
