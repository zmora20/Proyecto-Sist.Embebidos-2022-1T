<?php

include 'Channel.php';

$code = $_POST['id'];
$product = $_POST['product'];

$ask = "update stand set product = '$product' where id = '$code'";
mysqli_query( $connection , $ask ) or die ( mysqli_error( mysqli_connect(  ) ) )

?>