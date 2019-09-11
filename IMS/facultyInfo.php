<?php

if($_SERVER["REQUEST_METHOD"] == "POST"){
	require 'connection.php';
	createStudent();
}

function createStudent(){
	global $connect;

	$query = "SELECT * FROM facinfo";
	$result = mysqli_query($connect,$query) or die (mysqli_error($connect));
	while($e = mysqli_fetch_assoc($result)){
		
		$res[] = $e;
		
	}
	echo json_encode($res);
	mysqli_close($connect);
}

?>