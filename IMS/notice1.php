<?php
$notice=array();
$dbhost = 'localhost';
$dbuser = 'root';
$dbpass=' ';
$conn = mysql_connect($dbhost, $dbuser);
if(! $conn )
{
  die('Could not connect: ' . mysql_error());
}

mysql_select_db('firstdb');

$result = mysql_query("SELECT * from notice");

while($row = mysql_fetch_array($result))
	{

		$notice[] = $row;
	
	}	
	echo json_encode($notice);
?>