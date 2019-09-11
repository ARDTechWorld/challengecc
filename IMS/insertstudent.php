<?php

if($_SERVER["REQUEST_METHOD"] == "POST"){
	require 'connection.php';
	createStudent();
}

function createStudent(){
	global $connect;
	
	$name = $_POST['name'];
	$batch = $_POST['batch'];
	$password = $_POST['password'];
	$phone = $_POST['phone'];
	$email = $_POST['email'];
	$query = "insert into student(name,batch,password,phone,email) values ('$name','$batch','$password','$phone','$email'); ";
	mysqli_query($connect,$query) or die (mysqli_error($connect));
	mysqli_close($connect);
}
?>