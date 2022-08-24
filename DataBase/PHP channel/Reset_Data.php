<?php

include 'Channel.php';

$code = $_POST['id'];
$product = "Default";
$quantity = 0;
$scanDate = null;
$scans = 0;
$fills = 0;

$ask = "update stand set product = '$product',quantity = '$quantity',scanDate = '$scanDate',scans = '$scans',fills = '$fills' where id = '$code'";
mysqli_query( $connection , $ask ) or die ( mysqli_error( mysqli_connect() ) );
mysqli_close( $connection );

?>