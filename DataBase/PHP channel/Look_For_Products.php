<?php

include 'Channel.php';

$code = $_GET['id'];

$asker = "select * from stand where id = '$code'";
$answer = $connection -> query( $asker );

while( $fila = $answer -> fetch_array() )
{
    $estantes[] = array_map( 'utf8_encode', $fila );
}

echo json_encode( $estantes );
$answer -> close();

?>