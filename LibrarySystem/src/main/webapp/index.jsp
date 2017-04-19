<html>
<head>
<title>Library System</title>
</head>
<body>
    <form name = "user">
    <input type="hidden" id="user_id">
        First Name: <input type="text" id="firstname" required="required" name="first_name"><br>
        Middle Name: <input type="text" id="middlename" name="middle_name"><br>
        Last Name: <input type="text" id="lastname" required="required" name="last_name"><br>
        Age: <input type="number" id="age" required="required" name="age"><br>
        Gender:  <input type="radio" id="gender" name="gender" value="M"> Male
 				 <input type="radio" id= "gender" name="gender" value="F"> Female<br>
        Phone: <input type="number" id="phone" required="required" name="phone" maxlength=10><br>
        Zip: <input type="number" id="zip" required="required" name="zip"><br>
        <button onclick="submit();">Submit</button><br><br>
        <button onclick="getAllUsers();">getAllUsers</button><br><br>
        </form>
</body>
<script type="text/javascript">
 getAllUsers = function(){
	 $.ajax({ 
		    type: 'GET', 
		    url: 'http://users/allUsers', 
		    dataType: 'json',
		    success: function (data) { 
		        $.each(data, function(index, element) {
		            $('body').append($('<div>', {
		                text: element.name
		            }));
		        });
		    }
		});   
    }
 
 function submit() {
     var firstName = $("#firstname").val();
     var middleName = $("#middlename").val();
     var lastName = $("#lastname").val();
     var age = $("#age").val();
     var gender = $("#gender").val();
     var phone = $("#phone").val();
     var zip = $("#zip").val();

     var user = {
     	firstName: firstName,
         middleName: middleName,
         lastName: lastName,
         age:age,
         gender: gender,
         phoneNumber: phone,
         zip:zip
     };

     $.ajax({
         type: "POST",
         url: "/users/addUser?user="+user,
         dataType: "json",
         success: function (msg) {
             if (msg) {
                 alert(user.firstName + " was added in list !");
                 location.reload(true);
             } else {
                 alert("Cannot add to list !");
             }
         },

         data: user
     });
}
 
 </script>
     
</html>