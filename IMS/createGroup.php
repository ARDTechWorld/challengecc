<?php

if($_SERVER["REQUEST_METHOD"] == "POST"){
	require 'connection.php';
	createStudent();
}

function createStudent(){
	global $connect;
	
	
	$groupname = $_POST['groupname'];
	$query = "insert into stgroup(groupname) values ('$groupname') ";
	mysqli_query($connect,$query) or die (mysqli_error($connect));
	mysqli_close($connect);
}




?>