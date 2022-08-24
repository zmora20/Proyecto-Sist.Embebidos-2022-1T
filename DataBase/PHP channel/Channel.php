<?php

$hostname = 'localhost';
$database = 'Control_Almacen';
$username = 'DFlamis';
$password = '2612';

$connection = new mysqli( $hostname, $username, $password, $database );

if( $connection -> connect_error )
{
    echo "No pues, valio queso el canal de comunicacion xd";
}


?>