<?php

include 'Channel.php';

$code = $_POST['id'];
$product = $_POST['product'];
$quantity = $_POST['quantity'];
$scanDate = $_POST['scanDate'];
$scans = $_POST['scan'];
$fills = $_POST['fills'];

$ask = "insert into stand values('".$code."','".$product."','".$quantity."','".$scanDate."','".$scans."','".$fills."',)";
mysqli_query( $connection , $ask ) or die ( mysqli_error() );
mysqli_close( $connection );

?>