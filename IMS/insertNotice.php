<?php

if($_SERVER["REQUEST_METHOD"] == "POST"){
	require 'connection.php';
	createStudent();
}

function createStudent(){
	global $connect;
	
	//$n_id = $_POST['n_id'];
	$heading = $_POST['heading'];
	$description = $_POST['description'];
	$sign = $_POST['sign'];
	$n_date = $_POST['n_date'];
	
	$query = "insert into notice(heading,description,sign,n_date) values ('$heading','$description','$sign','$n_date'); ";
	mysqli_query($connect,$query) or die (mysqli_error($connect));
	mysqli_close($connect);
}
?>