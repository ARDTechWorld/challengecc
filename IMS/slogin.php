<?php
$response = array();
if (isset($_POST['username']) && isset($_POST['password']) ) { 
$username = $_POST['username'];
$password = $_POST['password'];
$dbhost = 'localhost';
$dbuser = 'root';
$dbpass=' ';
$conn = mysql_connect($dbhost, $dbuser);
if(! $conn )
{
  die('Could not connect: ' . mysql_error());
}

mysql_select_db('firstdb');

	
    $result = mysql_query("Select * from student where name='$username' and password=$password");
    if (mysql_num_rows($result))
	{
		$row=mysql_fetch_array($result);
		//$name=$row['name'];
       // $pic=$row['pic'];
        

		$response["success"] = 1;
        $response["message"] = "Login successfully.";
		//$response["name"]=$name;
		//$response["pic"]=$pic;
        echo json_encode($response);		
    }
	else 
	{
        $response["success"] = 0;
        $response["message"] = "Please Enter correct roll_number and password.";
        echo json_encode($response);
    }

else 
 {
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    echo json_encode($response);
} 
}
?>