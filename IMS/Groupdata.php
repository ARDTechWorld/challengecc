<?php

if($_SERVER["REQUEST_METHOD"] == "POST"){
	require 'connection.php';
	createStudent();
}

function createStudent(){
	global $connect;
	

	$email = $_POST['email'];
	$name = $_POST['name'];
	$groupname = $_POST['groupname'];
	
	$query = "insert into datagroup(email,name,groupname) values ('$email','$name','$groupname'); ";
	mysqli_query($connect,$query) or die (mysqli_error($connect));
	mysqli_close($connect);
}

?>