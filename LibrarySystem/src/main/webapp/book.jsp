<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="book">
		<input type="hidden" id="book_id">
        Book Name: <input type="text" id="bookname" name="book_name"><br>
        Author: <input type="text" id="author" name="author"><br>
        <a href="addAuthor.jsp">Add Author</a>
        <button onclick="submit();">Submit</button><br><br>
<button onclick="getAllBooks();">getAllBooks</button><br>
<input type="text" name="search" placeholder="Search.." value="searchItem">
<button onclick="search();">search</button><br>

</form>

</body>
<script type="text/javascript">
 getAllBooks = function(){
	 $.ajax({ 
		    type: 'GET', 
		    url: 'http://book/allBooks',
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
 
 search = function(){
	 $.ajax({ 
		    type: 'GET', 
		    url: 'http://book/findBook/?name='+searchItem, 
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
     var bookName = $("#bookName").val();
     var authors[] = $("#author").val();


     var book = {
     	bookName: bookName,
        author : authors
     };

     $.ajax({
         type: "POST",
         url: "/book/addBook?book="+book,
         dataType: "json",
         success: function (msg) {
             if (msg) {
                 alert(book.bookName + " was added in list !");
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